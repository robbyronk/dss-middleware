package org.cru.dss.give.functional;

import org.cru.dss.give.functional.clients.CartClient;
import org.cru.give.webservices.model.GiftCart;
import org.cru.give.webservices.model.MailingAddress;
import org.cru.give.webservices.model.Payment;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartResourceTest
{
	static final String RESOURCE_PREFIX = "rest";
	
	Environment environment = Environment.LOCAL;
	
	CartClient client;
	
	@BeforeMethod
	public void createClient()
	{
        String restApiBaseUrl = environment.getUrlAndContext() + "/" + RESOURCE_PREFIX;
        client = ProxyFactory.create(CartClient.class, restApiBaseUrl);
	}

	@Test
	public void testCreateCart()
	{
		ClientResponse<GiftCart> giftCartResponse = client.createCart();
		String header = giftCartResponse.getHeaderAsLink("Location").getHref();
		
		Assert.assertNotNull(header);
	}
	
	@Test
	public void testFetchCart()
	{
		ClientResponse<GiftCart> giftCartResponse = client.getCart("22");
		GiftCart cart = giftCartResponse.getEntity(GiftCart.class);
		
		Assert.assertEquals(new Long(22), cart.getCartId());
	}
	
	@Test
	public void testUpdateCart()
	{
		GiftCart cart = new GiftCart();
		cart.setCartId(22L);
		cart.setMailingAddress(new MailingAddress());
		cart.getMailingAddress().setCity("Bowling Green");
		cart.setPayment(new Payment());
		cart.getPayment().setDescription("Foo's Payment");
		
		client.updateCart(cart);
		
		createClient();
		
		ClientResponse<GiftCart> giftCartResponse = client.getCart("22");
		GiftCart updatedCart = giftCartResponse.getEntity(GiftCart.class);
		
		Assert.assertEquals(new Long(22), updatedCart.getCartId());
		Assert.assertEquals("Bowling Green", updatedCart.getMailingAddress().getCity());
		Assert.assertEquals("Foo's Payment", updatedCart.getPayment().getDescription());
	}
}