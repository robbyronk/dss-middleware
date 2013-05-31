package org.cru.give.webservices;

import java.util.ArrayList;
import java.util.Date;
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
import org.joda.time.DateTime;

@Path("/drawday")
public class DrawDayResource
{
	
	@Inject DrawRunService drawRunService;
	@Inject Clock clock;
	
	@Path("")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getValidStartMonths()
	{
		return new ValidGiftStartDates(drawRunService,clock.currentDateTime()).getGiftStartMonths();
	}
	
	@Path("/{date}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DrawDay> getValidDrawDays(@PathParam("date") DateTime date)
	{
		Map<String,String> mappy = new ValidGiftStartDates(drawRunService, clock.currentDateTime()).getGiftStartDaysForMonth(new DateTime(date));
		List<DrawDay> drawDayList = new ArrayList<DrawDay>();
		
		for(String key : mappy.keySet())
		{
			DrawDay drawDay = new DrawDay();
			drawDay.setKey(key);
			drawDay.setValue(mappy.get(key));
		
			drawDayList.add(drawDay);
		}
		
		return drawDayList;
	}
	
	public static class DrawDay implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
	
		String key;
		String value;
		
		public String getKey()
		{
			return key;
		}
		public void setKey(String key)
		{
			this.key = key;
		}
		public String getValue()
		{
			return value;
		}
		public void setValue(String value)
		{
			this.value = value;
		}
	}
}
