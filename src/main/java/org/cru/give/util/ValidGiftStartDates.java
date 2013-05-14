package org.cru.give.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.cru.give.service.DrawRunService;
import org.joda.time.DateTime;

public class ValidGiftStartDates
{
	DateTime currentDateAndTime;
	DrawRunService drawRunService;

	public ValidGiftStartDates(DrawRunService drawRunService, DateTime currentDateAndTime)
	{
		this.drawRunService = drawRunService;
		this.currentDateAndTime = currentDateAndTime;
	}
	
//	public List<String> getGiftStartMonthsForDayOfMonth(String dayOfMonth)
//	{
//		List<String> validStartMonths = new ArrayList<String>();
//
//		DateTime latestDraw = takeLaterDateOf(drawRunService.getLatestCreditCardDrawStartDateAndTime(), 
//												drawRunService.getLatestEFTDrawStartDateAndTime());
//	}
	
	public Map<String, String> getGiftStartDaysForMonth(String month)
	{
		Map<String, String> validStartDays = new LinkedHashMap<String, String>(NewGiftValidDrawDays.values);
		
		DateTime latestDraw = takeLaterDateOf(drawRunService.getLatestCreditCardDrawStartDateAndTime(), 
				drawRunService.getLatestEFTDrawStartDateAndTime());
		
		DateTime dateAndTimeWeAreConcernedAbout = takeLaterDateOf(currentDateAndTime, latestDraw);
		
		for(Iterator<String> i = validStartDays.keySet().iterator(); i.hasNext(); )
		{
			if(new Integer(i.next()) > dateAndTimeWeAreConcernedAbout.getDayOfMonth())
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
