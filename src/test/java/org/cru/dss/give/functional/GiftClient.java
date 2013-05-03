package org.cru.dss.give.functional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.cru.give.webservices.model.GiftDetails;

public interface GiftClient
{
	@GET
	@Path("/{giftId}")
	@Produces(MediaType.APPLICATION_JSON)
	public GiftDetails getGift(@PathParam("giftId") String giftId);
}
