package org.cru.give.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.cru.give.model.CapturedGift;
import org.cru.give.webservices.model.GiftDetails;

public class GiftService
{
	@Inject EntityManager em;

	public GiftDetails fetchGift(String giftId)
	{
		CapturedGift capturedGift = em.find(CapturedGift.class, new Long(giftId));
		
		if(capturedGift == null) throw new RuntimeException("Gift " + giftId + " was not found :(");
		
		GiftDetails giftDetails = new GiftDetails();
		giftDetails.setGiftId(capturedGift.getGiftId());
		giftDetails.setGiftAmount(capturedGift.getAmount());
		
		return giftDetails;
	}
}
