package org.cru.give.validators;

import javax.inject.Inject;

import org.cru.give.model.GiftFrequencyOptions;
import org.cru.give.model.ListOfValues;
import org.cru.give.webservices.model.GiftDetails;

public class FrequencyValidator
{
	
	@Inject GiftFrequencyOptions giftFrequencyOptions;
	
	public ValidationError validate(GiftDetails gift)
	{
		for(ListOfValues lov : giftFrequencyOptions.getList())
		{
			if(lov.getDropdownName().equals(gift.getGiftFrequency())) return null;
		}
		
		return new ValidationError(ValidationErrorType.INVALID_VALUE, 
									"gift.giftFrequency", 
									"Gift Frequency must be one of: ....");
	}
	
}
