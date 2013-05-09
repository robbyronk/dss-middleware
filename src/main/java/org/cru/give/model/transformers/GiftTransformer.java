package org.cru.give.model.transformers;

import java.util.ArrayList;
import java.util.List;

import org.cru.give.model.CapturedGift;
import org.cru.give.webservices.model.GiftDetails;

public class GiftTransformer
{

	public static GiftDetails asGiftDetails(CapturedGift capturedGift)
	{
		GiftDetails giftDetails = new GiftDetails();
		giftDetails.setGiftId(capturedGift.getGiftId());
		giftDetails.setCartId(capturedGift.getCartId());
		giftDetails.setGiftAmount(capturedGift.getAmount());
		giftDetails.setGiftFrequency(capturedGift.getGiftFrequency());
		giftDetails.setDayOfMonth(capturedGift.getGiftDay());
		giftDetails.setMotivationCode(capturedGift.getMotivation());
		giftDetails.setCampaignCode(capturedGift.getCampaignCode());
		
		return giftDetails;
	}
	
	public static List<GiftDetails> asGiftDetails(List<CapturedGift> capturedGiftList)
	{
		List<GiftDetails> gifts = new ArrayList<GiftDetails>();
		
		for(CapturedGift capturedGift : capturedGiftList)
		{
			gifts.add(asGiftDetails(capturedGift));
		}
		
		return gifts;
	}
}
