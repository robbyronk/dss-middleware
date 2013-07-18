package org.cru.give.webservices;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.cru.give.model.SuffixOptions;
import org.cru.give.service.SuffixService;

@Path("/suffixes")
@Stateless
public class SuffixResource
{
	@Inject SuffixService suffixService;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public SuffixOptions getSuffixOptions()
	{
		return suffixService.getSuffixOptions();
	}
}
