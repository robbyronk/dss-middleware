package org.cru.give.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.cru.dss.give.webservices.model.GiftCart;

@Path("/cart")
public class CartResource
{
	@GET
	@Path("{cartId}")
	@Produces(MediaType.APPLICATION_JSON)
	public GiftCart getCart(@PathParam("cartId") String giftCartId)
	{
		return null;
	}
	
	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createCart()
	{
		return null;
	}
	
	@DELETE
	@Path("{cartId}")
	public GiftCart deleteCart(@PathParam("cartId") String giftCartId)
	{
		return null;
	}
	
	@PUT
	@Path("{cartId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCart(@PathParam("cartId") String giftCartId, GiftCart cart)
	{
		
	}
}
