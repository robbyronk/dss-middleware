package org.cru.give.cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.cru.give.model.CountryOptions;
import org.cru.give.model.ListOfValues;

@ApplicationScoped
public class CountryOptionsProducer
{
public static String FREQUENCY_LOV_TYPE = "COUNTRY";
	
	CountryOptions countryOptions;
	
	@Inject EntityManager em;
	
	@PostConstruct
	public void init()
	{
		countryOptions = new CountryOptions(em.createQuery("SELECT lov FROM ListOfValues lov WHERE lov.dropdownType = :lovType", ListOfValues.class)
				.setParameter("lovType", FREQUENCY_LOV_TYPE)
				.getResultList());
	}
	
	@Produces
	public CountryOptions getCountryOptions()
	{
		return countryOptions;
	}
}
