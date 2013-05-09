package org.cru.give.validators;

import java.util.HashMap;
import java.util.Map;

import org.cru.give.webservices.model.GiftDetails;

public class DrawDayValidator
{
	static Map<String, String> validValues;
	
	static
	{
		validValues = new HashMap<String, String>();
		
		validValues.put("5", "5th");
		validValues.put("10", "10th");
		validValues.put("15", "15th");
		validValues.put("20", "20th");
		validValues.put("25", "25th");
	}
	
	public ValidationError validate(GiftDetails gift)
	{
		if("Single".equals(gift.getGiftFrequency())) return null;
		if(validValues.containsKey(gift.getDayOfMonth()) || validValues.containsValue(gift.getDayOfMonth())) return null;
		
		return new ValidationError(ValidationErrorType.INVALID_VALUE, 
									"gift.dayOfMonth", 
									"Gift Day of Month must be one of: ....");
	}
}
