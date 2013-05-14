package org.cru.give.validators;

import org.cru.give.util.NewGiftValidDrawDays;
import org.cru.give.webservices.model.GiftDetails;

public class DrawDayValidator
{
	
	public ValidationError validate(GiftDetails gift)
	{
		if("Single".equals(gift.getGiftFrequency())) return null;
		if(gift.getDayOfMonth() == null || gift.getDayOfMonth().trim().equals(""))
		{
			return new ValidationError(ValidationErrorType.MISSING_REQUIRED_FIELD, 
										"gift.dayOfMonth");
		}
		if(NewGiftValidDrawDays.values.containsKey(gift.getDayOfMonth()) || 
				NewGiftValidDrawDays.values.containsValue(gift.getDayOfMonth())) return null;
		
		return new ValidationError(ValidationErrorType.INVALID_VALUE, 
									"gift.dayOfMonth", 
									"Gift Day of Month must be one of: ....");
	}
}
