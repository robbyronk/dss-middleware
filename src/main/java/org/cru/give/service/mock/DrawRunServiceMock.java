package org.cru.give.service.mock;

import org.cru.give.service.DrawRunService;
import org.joda.time.DateTime;

public class DrawRunServiceMock implements DrawRunService
{	
	
	/**
	 * Default CC time: May 1, 2013 at 8:00 AM
	 */
	final DateTime defaultCreditCardDrawDateAndTime = new DateTime().withDayOfMonth(1).withMonthOfYear(5).withYear(2013).withHourOfDay(8).withMinuteOfHour(0).withSecondOfMinute(0);
	DateTime customCreditCardDrawDateAndTime;
	
	/**
	 * Default EFT time: May 5, 2013 at 8:00 AM
	 */
	final DateTime defaultEftDrawDateAndTime = new DateTime().withDayOfMonth(5).withMonthOfYear(5).withYear(2013).withHourOfDay(8).withMinuteOfHour(0).withSecondOfMinute(0);
	DateTime customEFTDrawDateAndTime;

	@Override
	public DateTime getLatestCreditCardDrawStartDateAndTime()
	{
		if(customCreditCardDrawDateAndTime != null) return customCreditCardDrawDateAndTime;
		return defaultCreditCardDrawDateAndTime;
	}

	@Override
	public DateTime getLatestEFTDrawStartDateAndTime()
	{
		if(customEFTDrawDateAndTime != null) return customEFTDrawDateAndTime;
		return defaultEftDrawDateAndTime;
	}

	public void overrideCreditCardDrawDateAndTime(DateTime customCreditCardDrawDateAndTime)
	{
		this.customCreditCardDrawDateAndTime = customCreditCardDrawDateAndTime;
	}

	public void overrideEFTDrawDateAndTime(DateTime customEFTDrawDateAndTime)
	{
		this.customEFTDrawDateAndTime = customEFTDrawDateAndTime;
	}
}
