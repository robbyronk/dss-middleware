package org.cru.give.util;

import java.util.LinkedHashMap;

public class NewGiftValidDrawDays
{
	public static LinkedHashMap<String, String> values;
	
	static
	{
		values = new LinkedHashMap<String, String>();
		
		values.put("5", "5th");
		values.put("10", "10th");
		values.put("15", "15th");
		values.put("20", "20th");
		values.put("25", "25th");
	}
}
