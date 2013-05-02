package org.cru.dss.give.functional;

import org.cru.dss.give.webservices.model.GiftCart;
import org.cru.dss.give.webservices.model.GiftDetails;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GiftCartResourceTests
{
	private static final String RESOURCE_PREFIX = "rest";
	Environment environment = Environment.LOCAL;
	
	private GiftCartClient client;
	
    @BeforeMethod
    public void buildClient()
    {
        String restApiBaseUrl = environment.getUrlAndContext() + "/" + RESOURCE_PREFIX;
        client = ProxyFactory.create(GiftCartClient.class, restApiBaseUrl);
    }

	@Test
	public void testRetrieveEmptyGiftCart()
	{
		GiftCart cart = client.retrieveGiftCart();
		Assert.assertNotNull(cart);
	}
	
	@Test
	public void testAddGiftToGiftCart()
	{
		GiftDetails gift = new GiftDetails();
		gift.setDesignationNumber("0550510");
		gift.setGiftAmount("50.25");
		
		client.addGiftToGiftCart(gift);
		
		GiftCart cart = client.retrieveGiftCart();
		Assert.assertNotNull(cart);
		Assert.assertFalse(cart.getGifts().isEmpty());
	}
}
