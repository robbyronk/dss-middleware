package org.cru.give.model;

import java.util.List;

public class CountryOptions
{
	List<ListOfValues> countryOptions;
	
	public CountryOptions(List<ListOfValues> countryOptions)
	{
		this.countryOptions = countryOptions;
	}
	
	public List<ListOfValues> getList()
	{
		return countryOptions;
	}
}
