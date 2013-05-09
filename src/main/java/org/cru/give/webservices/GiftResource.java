package org.cru.give.webservices;

import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cru.give.service.CartService;
import org.cru.give.service.GiftService;
import org.cru.give.validators.GiftValidator;
import org.cru.give.webservices.model.GiftDetails;

@Path("/gift")
@Stateless
public class GiftResource
{

	@Inject GiftValidator giftValidator;
	
	@Inject EntityManager em;
	@Inject GiftService giftService;
	@Inject CartService cartService;
	
	@Context org.jboss.resteasy.spi.HttpResponse response;
	
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
	public void createGift()
	{
		Long newGiftId = giftService.createNewGift();
		response.getOutputHeaders().putSingle("X-Created-Gift", "/dss-middleware/rest/gift/" + newGiftId);
		response.setStatus(Response.Status.CREATED.getStatusCode());
	}
	
	@DELETE
	@Path("/{giftId}")
	public void deleteGift(@PathParam("giftId") String giftId)
	{
		giftService.deleteGift(giftId);
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateGift(GiftDetails gift) throws IOException
	{
		giftValidator.validateInputIfNecessary(gift, response);
		
		giftService.updateGift(gift);
		response.setStatus(200);
	}
}
