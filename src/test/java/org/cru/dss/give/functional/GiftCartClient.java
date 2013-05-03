package org.cru.dss.give.functional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.cru.give.webservices.model.GiftCart;
import org.jboss.resteasy.client.ClientResponse;

@Path("/cart")
public interface GiftCartClient
{
	
	@GET
	@Path("/{cartId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse<GiftCart> getCart(@PathParam("cartId") String giftCartId);
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public ClientResponse<GiftCart> createCart();
	
	@DELETE
	@Path("/{cartId}")
	public ClientResponse<GiftCart> deleteCart(@PathParam("cartId") String giftCartId);
	
	@PUT
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	public ClientResponse<GiftCart> updateCart(GiftCart cart);
}
