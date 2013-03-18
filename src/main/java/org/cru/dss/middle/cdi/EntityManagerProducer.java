package org.cru.dss.middle.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer
{

	@PersistenceContext(unitName = "databaseTest")
    @Produces
    EntityManager siebelEntityManager;


}
