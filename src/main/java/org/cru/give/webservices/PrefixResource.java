package org.cru.give.webservices;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.cru.give.model.PrefixOptions;
import org.cru.give.service.PrefixService;

@Path("/prefixes")
@Stateless
public class PrefixResource
{
	@Inject PrefixService prefixService;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public PrefixOptions getPrefixOptions()
	{
		return prefixService.getPrefixOptions();
	}
}
