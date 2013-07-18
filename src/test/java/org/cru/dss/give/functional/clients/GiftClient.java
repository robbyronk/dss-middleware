package org.cru.dss.give.functional.clients;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.cru.give.webservices.model.GiftDetails;
import org.jboss.resteasy.client.ClientResponse;
@Path("/gift")
public interface GiftClient
{
	@GET
	@Path("/{giftId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse<GiftDetails> getGift(@PathParam("giftId") String giftId);
	
	@POST
	@Path("/")
	public ClientResponse<GiftDetails> createGift();
	
	@DELETE
	@Path("/{giftId}")
	public ClientResponse<GiftDetails> deleteGift(@PathParam("giftId") String giftId);
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public ClientResponse<GiftDetails> updateGift(GiftDetails gift);
}