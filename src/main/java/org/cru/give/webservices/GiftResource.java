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
	
	@POST
	@Path("/")
	public void createGift()
	{
		
	}
	
	@DELETE
	@Path("/{giftId}")
	public void deleteGift(@PathParam("giftId") String giftId)
	{
		
	}
	
	@PUT
	@Path("/{giftId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCart(@PathParam("giftId") String giftId, GiftDetails gift)
	{
		
	}
	
}
