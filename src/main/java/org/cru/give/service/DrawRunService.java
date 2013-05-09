package org.cru.give.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.cru.give.model.Activity;
import org.cru.give.model.Activity_;
import org.joda.time.DateTime;

public class DrawRunService
{
	private static final String CREDIT_CARD_DRAW_DESCRIPTION = "CC - Generate Donations";
	private static final String EFT_DRAW_DESCRIPTION = "EFT - Generate Donations";
	
	@Inject EntityManager em;
	

	public DateTime getLatestCreditCardDrawStartDateAndTime()
	{
		return getDrawStartDateAndTimeForType(CREDIT_CARD_DRAW_DESCRIPTION);
	}

	public DateTime getLatestEFTDrawStartDateAndTime()
	{
		return getDrawStartDateAndTimeForType(EFT_DRAW_DESCRIPTION);
	}

	private DateTime getDrawStartDateAndTimeForType(String paymentType)
	{
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Activity> query = criteriaBuilder.createQuery(Activity.class);
		Root<Activity> activity = query.from(Activity.class);
		
		query.select(activity)
		    .where(criteriaBuilder.equal(activity.get(Activity_.paymentType), paymentType),
		    		criteriaBuilder.isNotNull(activity.get(Activity_.runDateAndTime)),
		    		criteriaBuilder.notEqual(activity.get(Activity_.drawRunStatus), "Open"),
		    		criteriaBuilder.notEqual(activity.get(Activity_.drawRunStatus), "Cancelled"))
			.orderBy(criteriaBuilder.desc(activity.get(Activity_.runDateAndTime)));
		
		TypedQuery<Activity> typedQuery = em.createQuery(query);
		
		List<Activity> results = typedQuery.setMaxResults(1).getResultList();
		
		if(results == null || results.isEmpty()) throw new RuntimeException("No draws found... something is really wrong! for: " + paymentType);
		if(results.get(0).getRunDateAndTime() == null) throw new IllegalStateException("The latest draw has no start time, something is really wrong");
		
		return new DateTime(results.get(0).getRunDateAndTime());
	}
}
