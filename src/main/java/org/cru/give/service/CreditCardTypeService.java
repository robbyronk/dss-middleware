package org.cru.give.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.cru.give.model.CreditCardType;

public class CreditCardTypeService
{
	@Inject EntityManager em;
	
	public List<CreditCardType> getCreditCardTypes()
	{
		return em.createQuery("SELECT ccType FROM CreditCardType ccType", CreditCardType.class)
				.getResultList();
	}
}
