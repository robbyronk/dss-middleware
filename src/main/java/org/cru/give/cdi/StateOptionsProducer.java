package org.cru.give.cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.cru.give.model.ListOfValues;
import org.cru.give.model.StateOptions;

@ApplicationScoped
public class StateOptionsProducer
{
	public static String STATE_LOV_TYPE = "STATE_ABBREV";
	
	StateOptions stateOptions;
	
	@Inject EntityManager em;
	
	@PostConstruct
	public void init()
	{
		stateOptions = new StateOptions(em.createQuery("SELECT lov FROM ListOfValues lov WHERE lov.dropdownType = :lovType", ListOfValues.class)
				.setParameter("lovType", STATE_LOV_TYPE)
				.getResultList());
	}
	
	@Produces
	public StateOptions getStateOptions()
	{
		return stateOptions;
	}
}
