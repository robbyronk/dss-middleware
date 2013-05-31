package org.cru.dss.give.functional.clients;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.cru.give.webservices.DrawDayResource.DrawDay;
import org.jboss.resteasy.client.ClientResponse;
import org.joda.time.DateTime;

@Path("/drawday")
public interface DrawDayClient
{
	@Path("/{date}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse<List<DrawDay>> getValidDrawDays(@PathParam("date") DateTime date);
}
