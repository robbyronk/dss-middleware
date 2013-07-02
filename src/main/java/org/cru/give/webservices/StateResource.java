package org.cru.give.webservices;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.cru.give.model.StateOptions;
import org.cru.give.service.StateService;

@Path("/states")
@Stateless
public class StateResource
{
	@Inject StateService stateService;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public StateOptions getStateOptions()
	{
		return stateService.getStateOptions();
	}
}
