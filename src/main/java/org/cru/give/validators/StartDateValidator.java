package org.cru.give.validators;

import javax.inject.Inject;

import org.ccci.util.time.Clock;
import org.cru.give.service.DrawRunService;
import org.cru.give.webservices.model.GiftDetails;
import org.joda.time.DateTime;

public class StartDateValidator
{
	
	@Inject Clock systemClock;
	@Inject DrawRunService drawRunService;
	
	/**
	 * Things about Start Date that are validated:
	 * 	1. The start date must be today or in the future.
	 *  2. The start date must not be today if the draw for today has been started.
	 *  
	 * @param gift
	 * @return
	 */
	public ValidationError validate(GiftDetails gift)
	{
		if(gift.getStartDate() == null) return new ValidationError(ValidationErrorType.MISSING_REQUIRED_FIELD, "gift.startDate");
		
		DateTime giftStartDate = new DateTime(gift.getStartDate());
		DateTime todayAtMidnight = systemClock.currentDateTime().withMillisOfDay(0);
		
		DateTime latestCreditCardRun = drawRunService.getLatestCreditCardDrawStartDateAndTime();
		DateTime latestEftRun = drawRunService.getLatestEFTDrawStartDateAndTime();
		
		/**
		 * The gift can be given today, so long as the draw hasn't started.  Draw check happens next.
		 */
		if(!giftStartDate.isAfter(todayAtMidnight))
		{
			return new ValidationError(ValidationErrorType.INVALID_VALUE, "gift.startDate", "Start date must be set today or in the future.");
		}
		
		/**
		 * Now check the gift start date at midnight versus the latest draw runs.. this will ensure that if a draw
		 * is started for the desired gift start date, an exception is thrown
		 */
		if(!giftStartDate.withMillisOfDay(0).isAfter(latestCreditCardRun) && !giftStartDate.withMillisOfDay(0).isAfter(latestEftRun))
		{
			return new ValidationError(ValidationErrorType.INVALID_VALUE, "gift.startDate", "Start date must be after latest draw");
		}
		
		return null;
	}
}
