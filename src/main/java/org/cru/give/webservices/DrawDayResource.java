package org.cru.give.webservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ccci.util.time.Clock;
import org.cru.give.service.DrawRunService;
import org.cru.give.util.ValidGiftStartDates;
import org.cru.give.webservices.model.DrawDay;
import org.cru.give.webservices.model.DrawMonth;
import org.joda.time.DateTime;

@Path("/draw")
public class DrawDayResource
{
	
	@Inject DrawRunService drawRunService;
	@Inject Clock clock;
	
	@Path("/months/{date}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DrawMonth> getValidStartMonths()
	{
		return new ValidGiftStartDates(drawRunService,clock.currentDateTime()).getGiftStartMonths();
	}
	
	@Path("/days/{date}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DrawDay> getValidDrawDays(@PathParam("date") DateTime date)
	{
		Map<String,String> validGiftStartDates = new ValidGiftStartDates(drawRunService, clock.currentDateTime()).getGiftStartDaysForMonth(new DateTime(date));
		
		/**
		 * if there aren't any valid options this month, then bounce to the first of next month
		 */
		if(validGiftStartDates.isEmpty())
		{
			validGiftStartDates = new ValidGiftStartDates(drawRunService, clock.currentDateTime()).getGiftStartDaysForMonth(new DateTime(date).plusMonths(1).withDayOfMonth(1));
		}
		
		List<DrawDay> drawDayList = new ArrayList<DrawDay>();
		
		for(String key : validGiftStartDates.keySet())
		{
			DrawDay drawDay = new DrawDay();
			drawDay.setKey(key);
			drawDay.setValue(validGiftStartDates.get(key));
		
			drawDayList.add(drawDay);
		}
		
		return drawDayList;
	}
	
	
}
