package org.cru.dss.give.functional;

import org.cru.give.webservices.model.GiftDetails;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestGiftResource
{
	static final String RESOURCE_PREFIX = "rest";

	Environment environment = Environment.LOCAL;

	GiftClient client;

	@BeforeMethod
	public void createClient()
	{
		String restApiBaseUrl = environment.getUrlAndContext() + "/" + RESOURCE_PREFIX;
		client = ProxyFactory.create(GiftClient.class, restApiBaseUrl);
	}

	@Test
	public void testCreateGift()
	{
		ClientResponse<GiftDetails> giftResponse = client.createGift();
		String header = giftResponse.getHeaderAsLink("X-Created-Gift").getHref();

		Assert.assertNotNull(header);
	}

	@Test
	public void testFetchGift()
	{
		ClientResponse<GiftDetails> giftResponse = client.getGift("1");
		GiftDetails gift = giftResponse.getEntity(GiftDetails.class);

		Assert.assertEquals(gift.getGiftId(), new Long(1));
	}

	@Test
	public void testUpdateGift()
	{
		GiftDetails gift = new GiftDetails();
		gift.setGiftId(1L);
		gift.setGiftAmount(20.25);

		client.updateGift(gift);

		createClient();

		ClientResponse<GiftDetails> updatedGiftResponse = client.getGift("1");
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

		ClientResponse<GiftDetails> updateResponse = client.updateGift(gift);
		Assert.assertEquals(updateResponse.getStatus(), 400);
	}
	
	@Test 
	public void testUpdateGiftInvalidStartDate()
	{
		GiftDetails gift = new GiftDetails();
		gift.setGiftId(1L);
		gift.setStartDate(new DateTime().withDayOfMonth(1).withMonthOfYear(1).withYear(1900).toDate());
		gift.setValidate(true);

		ClientResponse<GiftDetails> updateResponse = client.updateGift(gift);
		Assert.assertEquals(updateResponse.getStatus(), 400);

	}
}
