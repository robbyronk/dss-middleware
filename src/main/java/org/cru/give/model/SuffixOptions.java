package org.cru.give.model;

import java.util.List;

public class SuffixOptions
{
	List<ListOfValues> suffixOptions;
	
	public SuffixOptions(List<ListOfValues> suffixOptions)
	{
		this.suffixOptions = suffixOptions;
	}
	
	public List<ListOfValues> getList()
	{
		return suffixOptions;
	}
}
