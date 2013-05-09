package org.cru.give.webservices;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.cru.give.service.CartService;
import org.cru.give.service.GiftService;
import org.cru.give.validators.GiftValidator;
import org.cru.give.webservices.model.GiftDetails;

@Path("/gift")
@Stateless
public class GiftResource
{

	@Inject GiftValidator giftValidator;
	
	@Inject GiftService giftService;
	@Inject CartService cartService;
		
	@GET
	@Path("/{giftId}")
	@Produces(MediaType.APPLICATION_JSON)
	public GiftDetails getGift(@PathParam("giftId") String giftId)
	{
		return giftService.fetchGift(giftId);
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<GiftDetails> getGiftsFromCart(@QueryParam("cartId") String cartId)
	{
		return cartService.fetchGiftCart(cartId).getGifts();
	}
	
	@POST
	@Path("/")
	public Response createGift() throws URISyntaxException
	{
		Long newGiftId = giftService.createNewGift();
		return Response.created(new URI("/gift/" + newGiftId)).build();
	}
	
	@DELETE
	@Path("/{giftId}")
	public Response deleteGift(@PathParam("giftId") String giftId)
	{
		giftService.deleteGift(giftId);
		return Response.noContent().build();
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateGift(GiftDetails gift) throws IOException
	{
		giftValidator.validateInputIfNecessary(gift);
		
		if(giftValidator.isValid())
		{
			giftService.updateGift(gift);
			return Response.noContent().build();
		}
		else
		{
			return Response.status(Status.BAD_REQUEST).entity(giftValidator.getErrors()).build();
		}
	}
}
