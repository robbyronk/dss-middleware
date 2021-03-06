package org.cru.give.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.cru.give.service.DrawRunService;
import org.cru.give.webservices.model.DrawMonth;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class ValidGiftStartDates
{
	DateTime currentDateAndTime;
	DrawRunService drawRunService;

	
	
	public ValidGiftStartDates(DrawRunService drawRunService, DateTime currentDateAndTime)
	{
		this.drawRunService = drawRunService;
		this.currentDateAndTime = currentDateAndTime;
	}
	
	public List<DrawMonth> getGiftStartMonths()
	{
		List<DrawMonth> validStartingMonths = new ArrayList<DrawMonth>();
		DateTime monthCounter = currentDateAndTime;
		
		if(getGiftStartDaysForMonth(currentDateAndTime).isEmpty())
		{
			monthCounter = monthCounter.plusMonths(1);
		}
		
		for(int i = 0; i < 12; i++)
		{
			DrawMonth drawMonth = new DrawMonth(monthCounter);
			
			validStartingMonths.add(drawMonth);
			monthCounter = monthCounter.plusMonths(1);
		}
		
		return validStartingMonths;
	}
	
	public Map<String, String> getGiftStartDaysForMonth(DateTime date)
	{
		Map<String, String> validStartDays = new LinkedHashMap<String, String>(NewGiftValidDrawDays.values);
		
		DateTime latestDraw = takeLaterDateOf(drawRunService.getLatestCreditCardDrawStartDateAndTime(), 
				drawRunService.getLatestEFTDrawStartDateAndTime());
		
		DateTime dateAndTimeWeAreConcernedAbout = takeLaterDateOf(currentDateAndTime, latestDraw);

		DateTime monthInQuestion = date.withDayOfMonth(1);
		
		/**
		 * If caller asks for a month which is beyond the date we are concerned about,
		 * then all possible options are valid.
		 */
		if(monthInQuestion.isAfter(dateAndTimeWeAreConcernedAbout)) return validStartDays;
		
		/**
		 * If the month in question is the month prior to the month we're asking about, then
		 * there are no possible valid options
		 */
		if(monthInQuestion.getMonthOfYear() < dateAndTimeWeAreConcernedAbout.getMonthOfYear()) return (Map<String,String>) Collections.EMPTY_MAP;
			
		/**
		 * Otherwise, we're in a month where some days might not be valid.  Let's go ahead
		 * and iterate through and remove choices which are no longer valid either
		 * because they are in the past or the draw for them has begun.
		 */
		for(Iterator<String> i = validStartDays.keySet().iterator(); i.hasNext(); )
		{
			if(new Integer(i.next()) <= dateAndTimeWeAreConcernedAbout.getDayOfMonth() && 
					monthInQuestion.getMonthOfYear() == dateAndTimeWeAreConcernedAbout.getMonthOfYear())
			{
				i.remove();
			}
		}
		
		return validStartDays;
	}
	
	private DateTime takeLaterDateOf(DateTime date1, DateTime date2)
	{
		if(date1.isAfter(date2)) return date1;
		else return date2;
	}
}
