package org.cru.give.webservices;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.cru.give.model.GiftFrequencyOptions;
import org.cru.give.service.GiftFrequencyService;
import org.cru.give.validators.FrequencyValidator;

@Path("/frequencies")
@Stateless
public class GiftFrequencyResource
{
	@Inject FrequencyValidator frequencyValidator;
	@Inject GiftFrequencyService frequencyService;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public GiftFrequencyOptions getFrequencies()
	{
		return frequencyService.getFrequencies();
	}
}
