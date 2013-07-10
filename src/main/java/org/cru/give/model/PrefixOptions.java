package org.cru.give.model;

import java.util.List;

public class PrefixOptions
{
	List<ListOfValues> prefixOptions;
	
	public PrefixOptions(List<ListOfValues> prefixOptions)
	{
		this.prefixOptions = prefixOptions;
	}
	
	public List<ListOfValues> getList()
	{
		return prefixOptions;
	}
}
