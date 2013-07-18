package org.cru.give.cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.cru.give.model.ListOfValues;
import org.cru.give.model.PrefixOptions;

@ApplicationScoped
public class PrefixOptionsProducer
{
	public static String PREFIX_LOV_TYPE = "MR_MS";
	
	PrefixOptions prefixOptions;
	
	@Inject EntityManager em;
	
	@PostConstruct
	public void init()
	{
		prefixOptions = new PrefixOptions(em.createQuery("SELECT lov FROM ListOfValues lov WHERE lov.dropdownType = :lovType", ListOfValues.class)
				.setParameter("lovType", PREFIX_LOV_TYPE)
				.getResultList());
	}
	
	@Produces
	public PrefixOptions getPrefixOptions()
	{
		return prefixOptions;
	}
}
