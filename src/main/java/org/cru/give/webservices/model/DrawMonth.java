package org.cru.give.webservices.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DrawMonth implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	String display;
	String month;
	String year;
	
	public DrawMonth(DateTime monthCounter)
	{
		DateTimeFormatter formatter = DateTimeFormat.forPattern("MMMM, yyyy");
		
		display = formatter.print(monthCounter);
		month = String.valueOf(monthCounter.getMonthOfYear());
		year = String.valueOf(monthCounter.getYear());		
	}

	public String getDisplay()
	{
		return display;
	}
	public void setDisplay(String display)
	{
		this.display = display;
	}
	public String getMonth()
	{
		return month;
	}
	public void setMonth(String month)
	{
		this.month = month;
	}
	public String getYear()
	{
		return year;
	}
	public void setYear(String year)
	{
		this.year = year;
	}

}
