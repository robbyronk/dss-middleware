package org.cru.give.webservices;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.cru.give.model.CreditCardType;
import org.cru.give.service.CreditCardTypeService;

@Path("/cards")
@Stateless
public class CreditCardTypeResource
{
	@Inject CreditCardTypeService creditCardTypeService;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CreditCardType> getCreditCardTypes()
	{
		return creditCardTypeService.getCreditCardTypes();
	}
}
