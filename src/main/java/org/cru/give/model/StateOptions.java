package org.cru.give.model;

import java.util.List;


public class StateOptions
{
	List<ListOfValues> stateOptions;
	
	public StateOptions(List<ListOfValues> stateOptions)
	{
		this.stateOptions = stateOptions;
	}
	
	public List<ListOfValues> getList()
	{
		return stateOptions;
	}
}
