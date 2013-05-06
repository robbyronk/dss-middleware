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
		CapturedGift capturedGift = findGift(giftId);
		
		if(capturedGift == null) throw new RuntimeException("Gift " + giftId + " was not found :(");
		
		GiftDetails giftDetails = new GiftDetails();
		giftDetails.setGiftId(capturedGift.getGiftId());
		giftDetails.setGiftAmount(capturedGift.getAmount());
		
		return giftDetails;
	}
	
	public Long createNewGift()
	{
		CapturedGift capturedGift = new CapturedGift();
		
		em.persist(capturedGift);
		
		em.flush();
		
		em.refresh(capturedGift);
		
		return capturedGift.getGiftId();
	}
	
	public void deleteGift(String giftId)
	{
		em.remove(em.find(CapturedGift.class, giftId));
	}
	
	public void updateGift(GiftDetails gift)
	{
		em.merge(gift.asCapturedGift());
	}
	
	private CapturedGift findGift(String giftId)
	{
		return em.find(CapturedGift.class, new Long(giftId));
	}

}
