package org.cru.give.webservices;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.cru.give.model.CountryOptions;
import org.cru.give.service.CountryService;

@Path("/countries")
@Stateless
public class CountryResource
{
	@Inject CountryService countryService;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public CountryOptions getStateOptions()
	{
		return countryService.getCountryOptions();
	}
}
