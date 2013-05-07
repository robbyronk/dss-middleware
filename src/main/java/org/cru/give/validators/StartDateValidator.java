package org.cru.give.validators;

import javax.inject.Inject;

import org.ccci.util.time.Clock;
import org.cru.give.webservices.model.GiftDetails;
import org.joda.time.DateTime;

public class StartDateValidator
{
	
	@Inject Clock systemClock;
	
	/**
	 * Things about Start Date that are validated:
	 * 	1. The start date must be in the future, that is after the current system time.
	 *  2.
	 *  
	 * @param gift
	 * @return
	 */
	public ValidationError validate(GiftDetails gift)
	{
		if(gift.getStartDate() == null) return new ValidationError(ValidationErrorType.INVALID_VALUE, "gift.startDate");
		
		DateTime giftStartDate = new DateTime(gift.getStartDate());
		DateTime currentDateTime = systemClock.currentDateTime();
		
		if(!giftStartDate.isAfter(currentDateTime))
		{
			return new ValidationError(ValidationErrorType.INVALID_VALUE, "gift.startDate");
		}
		
		return null;
	}
}
