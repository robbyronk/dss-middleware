package org.cru.dss.give.functional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.cru.dss.give.webservices.model.GiftCart;
import org.cru.dss.give.webservices.model.GiftDetails;

@Path("/giftcart")
public interface GiftCartClient
{
	
	@GET
	@Path("/retrieve")
	@Produces({ "application/json" })
	public GiftCart retrieveGiftCart();
	
	@POST
	@Path("/addGift")
	@Consumes({ "application/json" })
	public void addGiftToGiftCart(GiftDetails newGift);
}
