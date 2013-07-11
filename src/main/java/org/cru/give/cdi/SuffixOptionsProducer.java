package org.cru.give.cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.cru.give.model.ListOfValues;
import org.cru.give.model.SuffixOptions;

@ApplicationScoped
public class SuffixOptionsProducer
{
public static String SUFFIX_LOV_TYPE = "FIN_SUFFIX";
	
	SuffixOptions suffixOptions;
	
	@Inject EntityManager em;
	
	@PostConstruct
	public void init()
	{
		suffixOptions = new SuffixOptions(em.createQuery("SELECT lov FROM ListOfValues lov WHERE lov.dropdownType = :lovType", ListOfValues.class)
				.setParameter("lovType", SUFFIX_LOV_TYPE)
				.getResultList());
	}
	
	@Produces
	public SuffixOptions getSuffixOptions()
	{
		return suffixOptions;
	}
}
