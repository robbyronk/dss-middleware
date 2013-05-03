package org.cru.give.webservices;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cru.give.service.GiftCartService;
import org.cru.give.webservices.model.GiftCart;

@Path("/cart")
@Stateless
public class CartResource
{
	
	@Inject GiftCartService cartService;
	
	@Context org.jboss.resteasy.spi.HttpResponse response;
	
	@GET
	@Path("/{cartId}")
	@Produces(MediaType.APPLICATION_JSON)
	public GiftCart getCart(@PathParam("cartId") String giftCartId)
	{
		return cartService.fetchGiftCart(giftCartId);
	}
	
	@POST
	@Path("/")
	public void createCart()
	{
		String cartId = cartService.createNewGiftCart();
		response.getOutputHeaders().putSingle("X-Created-Cart", "/dss-middleware/rest/cart/" + cartId);
		response.setStatus(Response.Status.CREATED.getStatusCode()); 
	}
	
	@DELETE
	@Path("/{cartId}")
	public void deleteCart(@PathParam("cartId") String giftCartId)
	{
		cartService.deleteGiftCart(giftCartId);
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCart(GiftCart cart)
	{
		cartService.updateGiftCart(cart);
	}
}
