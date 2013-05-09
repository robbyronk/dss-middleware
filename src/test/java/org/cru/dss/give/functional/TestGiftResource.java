package org.cru.dss.give.functional;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.cru.give.webservices.model.GiftDetails;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;
import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGiftResource
{
	static final String RESOURCE_PREFIX = "rest";

	Environment environment = Environment.LOCAL;

	public GiftClient createClient()
	{
		ClientConnectionManager cm = new ThreadSafeClientConnManager();
		HttpClient httpClient = new DefaultHttpClient(cm);
		ClientExecutor executor = new ApacheHttpClient4Executor(httpClient);
		
		String restApiBaseUrl = environment.getUrlAndContext() + "/" + RESOURCE_PREFIX;
		return ProxyFactory.create(GiftClient.class, restApiBaseUrl, executor);
	}

	@Test
	public void testCreateGift()
	{
		ClientResponse<GiftDetails> giftResponse = createClient().createGift();
		String header = giftResponse.getHeaderAsLink("Location").getHref();

		Assert.assertNotNull(header);
	}

	@Test
	public void testFetchGift()
	{
		ClientResponse<GiftDetails> giftResponse = createClient().getGift("1");
		GiftDetails gift = giftResponse.getEntity(GiftDetails.class);

		Assert.assertEquals(gift.getGiftId(), new Long(1));
	}

	@Test
	public void testUpdateGift()
	{
		GiftDetails gift = new GiftDetails();
		gift.setGiftId(1L);
		gift.setGiftAmount(20.25);
		gift.setGiftFrequency("Monthly");
		gift.setDayOfMonth("10");
		gift.setStartDate(new DateTime().plusYears(1).toDate());
		gift.setValidate(true);

		createClient().updateGift(gift);

		ClientResponse<GiftDetails> updatedGiftResponse = createClient().getGift("1");
		GiftDetails updatedGift = updatedGiftResponse.getEntity(GiftDetails.class);

		Assert.assertNotNull(updatedGift);
		Assert.assertEquals(updatedGift.getGiftId(), new Long(1));
		Assert.assertEquals(updatedGift.getGiftAmount(), 20.25);
	}

	@Test 
	public void testUpdateGiftInvalidFrequency()
	{
		GiftDetails gift = new GiftDetails();
		gift.setGiftId(1L);
		gift.setGiftFrequency("Multi-month");
		gift.setValidate(true);

		ClientResponse<GiftDetails> updateResponse = createClient().updateGift(gift);
		Assert.assertEquals(updateResponse.getStatus(), 400);
	}
	
	@Test 
	public void testUpdateGiftInvalidStartDate()
	{
		GiftDetails gift = new GiftDetails();
		gift.setGiftId(1L);
		gift.setStartDate(new DateTime().withDayOfMonth(1).withMonthOfYear(1).withYear(1900).toDate());
		gift.setValidate(true);

		ClientResponse<GiftDetails> updateResponse = createClient().updateGift(gift);
		Assert.assertEquals(updateResponse.getStatus(), 400);
	}
	
	@Test 
	public void testUpdateGiftInvalidDrawDay()
	{
		GiftDetails gift = new GiftDetails();
		gift.setGiftId(1L);
		gift.setGiftFrequency("Monthly");
		gift.setDayOfMonth("22");
		gift.setValidate(true);

		ClientResponse<GiftDetails> updateResponse = createClient().updateGift(gift);
		Assert.assertEquals(updateResponse.getStatus(), 400);
	}
}
