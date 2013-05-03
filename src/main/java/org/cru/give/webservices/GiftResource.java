package org.cru.give.webservices;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.cru.give.service.GiftService;
import org.cru.give.webservices.model.GiftDetails;

@Path("/gift")
@Stateless
public class GiftResource
{

	@Inject GiftService giftService;
	
	@GET
	@Path("/{giftId}")
	@Produces(MediaType.APPLICATION_JSON)
	public GiftDetails getGift(@PathParam("giftId") String giftId)
	{
		return giftService.fetchGift(giftId);
	}
}
