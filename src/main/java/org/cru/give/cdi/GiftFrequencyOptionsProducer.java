package org.cru.give.cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.cru.give.model.GiftFrequencyOptions;
import org.cru.give.model.ListOfValues;

@ApplicationScoped
public class GiftFrequencyOptionsProducer
{
	public static String FREQUENCY_LOV_TYPE = "CCCI_RECURRING_FREQ";
	
	GiftFrequencyOptions giftFrequencyOptions;
	
	@Inject EntityManager em;
	
	@PostConstruct
	public void init()
	{
		giftFrequencyOptions = new GiftFrequencyOptions(em.createQuery("SELECT lov FROM ListOfValues lov WHERE lov.dropdownType = :lovType", ListOfValues.class)
						.setParameter("lovType", FREQUENCY_LOV_TYPE)
						.getResultList());
	}

	@Produces 
	public GiftFrequencyOptions getGiftFrequencyOptions()
	{
		return giftFrequencyOptions;
	}
}
