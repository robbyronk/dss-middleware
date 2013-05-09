package org.cru.give.webservices;

import java.net.URI;
import java.net.URISyntaxException;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cru.give.service.CartService;
import org.cru.give.webservices.model.GiftCart;

@Path("/cart")
@Stateless
public class CartResource
{
	
	@Inject CartService cartService;
	
	@GET
	@Path("/{cartId}")
	@Produces(MediaType.APPLICATION_JSON)
	public GiftCart getCart(@PathParam("cartId") String cartId)
	{
		return cartService.fetchGiftCart(cartId);
	}
	
	@POST
	@Path("/")
	public Response createCart() throws URISyntaxException
	{
		Long cartId = cartService.createNewGiftCart();
		return Response.created(new URI("/cart/" + cartId)).build(); 
	}
	
	@DELETE
	@Path("/{cartId}")
	public Response deleteCart(@PathParam("cartId") String cartId)
	{
		cartService.deleteGiftCart(cartId);
		return Response.noContent().build();
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCart(GiftCart cart)
	{
		cartService.updateGiftCart(cart);
		return Response.noContent().build();
	}
}
