package org.cru.give.util;

import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.spi.StringConverter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

@Provider
public class DateTimeConverter implements StringConverter<DateTime>
{

	DateTimeFormatter formatter = ISODateTimeFormat.dateTime();
	
	@Override
	public DateTime fromString(String string)
	{
		return formatter.parseDateTime(string);
	}

	@Override
	public String toString(DateTime value)
	{
		return formatter.print(value);
	} 
}
