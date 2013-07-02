package org.cru.give.service;

import javax.inject.Inject;

import org.cru.give.cdi.CountryOptionsProducer;
import org.cru.give.model.CountryOptions;

public class CountryService
{
	@Inject CountryOptionsProducer countryOptionsProducer;
	
	public CountryOptions getCountryOptions()
	{
		return countryOptionsProducer.getCountryOptions();
	}
}
