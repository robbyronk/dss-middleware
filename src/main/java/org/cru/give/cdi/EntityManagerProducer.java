package org.cru.give.cdi;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer
{
	@Produces @PersistenceContext(name = "dssDev")
	EntityManager em;
}
