package org.cru.give.clients;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/siebel")
public interface SiebelDesignationClient
{
	@GET
	@Path("/designation/{desigNum}")
	@Produces(MediaType.APPLICATION_JSON)
	public DesignationRESTfulResults lookupDesignation(@PathParam("desigNum")String designation,
												@QueryParam("key") String securityKey);
}
