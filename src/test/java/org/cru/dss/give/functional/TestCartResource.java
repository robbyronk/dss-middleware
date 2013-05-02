package org.cru.dss.give.functional;

import org.cru.give.webservices.model.GiftCart;
import org.cru.give.webservices.model.MailingAddress;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCartResource
{
	static final String RESOURCE_PREFIX = "rest";
	
	Environment environment = Environment.LOCAL;
	
	GiftCartClient client;
	
	@BeforeMethod
	public void createClient()
	{
        String restApiBaseUrl = environment.getUrlAndContext() + "/" + RESOURCE_PREFIX;
        client = ProxyFactory.create(GiftCartClient.class, restApiBaseUrl);
	}

	@Test
	public void testCreateCart()
	{
		ClientResponse<GiftCart> giftCartResponse = client.createCart();
		String header = giftCartResponse.getHeaderAsLink("X-Created-Cart").getHref();
		
		Assert.assertNotNull(header);
	}
	
	@Test
	public void testFetchCart()
	{
		ClientResponse<GiftCart> giftCartResponse = client.getCart("27");
		GiftCart cart = giftCartResponse.getEntity(GiftCart.class);
		
		Assert.assertEquals(new Long(27), cart.getCartId());
	}
	

	@Test
	public void testUpdateCart()
	{
		GiftCart cart = new GiftCart();
		cart.setCartId(27L);
		cart.setMailingAddress(new MailingAddress());
		cart.getMailingAddress().setCity("Orlando");
		
		client.updateCart("27", cart);
		
		ClientResponse<GiftCart> giftCartResponse = client.getCart("27");
		GiftCart updatedCart = giftCartResponse.getEntity(GiftCart.class);
		
		Assert.assertEquals(new Long(27), updatedCart.getCartId());
		Assert.assertEquals("Orlando", updatedCart.getMailingAddress().getCity());
	}
}
