package org.cru.give.service;

import org.joda.time.DateTime;

public interface DrawRunService
{

	public DateTime getLatestCreditCardDrawStartDateAndTime();

	public DateTime getLatestEFTDrawStartDateAndTime();

}