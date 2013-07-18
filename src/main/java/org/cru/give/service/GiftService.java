package org.cru.give.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.cru.give.model.CapturedGift;
import org.cru.give.model.transformers.GiftTransformer;
import org.cru.give.webservices.model.GiftDetails;

public class GiftService
{
	@Inject EntityManager em;
	@Inject DesignationService designationService;

	public GiftDetails fetchGift(String giftId)
	{
		CapturedGift capturedGift = findGift(giftId);
		
		if(capturedGift == null) throw new RuntimeException("Gift " + giftId + " was not found :(");

		return GiftTransformer.asGiftDetails(capturedGift);
	}
	
	public List<GiftDetails> fetchGiftsForCart(String cartId)
	{
		return GiftTransformer.asGiftDetails(
					em.createQuery("SELECT gift FROM CapturedGift gift WHERE cartId = :cartId", CapturedGift.class)
							.setParameter("cartId", new Long(cartId))
							.getResultList());
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
		em.remove(em.find(CapturedGift.class, new Long(giftId)));
	}
	
	public void updateGift(GiftDetails gift)
	{
		CapturedGift capturedGift = gift.asCapturedGift();
		
		capturedGift = setSiebelDesignationId(gift.getDesignationNumber(), capturedGift);

		em.merge(capturedGift);
	}

	/**
	 * We will assume that the external client does not know the Siebel Row
	 * ID of the designation number, so we'll set that for them by using
	 * the Siebel resource in WSAPI project to look it up.
	 * @param gift
	 * @param capturedGift
	 */
	private CapturedGift setSiebelDesignationId(String designationNumber, CapturedGift capturedGift)
	{
		capturedGift.setDesignationId(designationService.getDesignationByNumber(designationNumber).getId());
		return capturedGift;
	}
	
	private CapturedGift findGift(String giftId)
	{
		return em.find(CapturedGift.class, new Long(giftId));
	}

}
