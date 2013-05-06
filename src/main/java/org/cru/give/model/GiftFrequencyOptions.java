package org.cru.give.model;

import java.util.List;

public class GiftFrequencyOptions
{
	List<ListOfValues> giftFrequencyOptions;

	public GiftFrequencyOptions(List<ListOfValues> giftFrequencyOptions)
	{
		this.giftFrequencyOptions = giftFrequencyOptions;
	}
	
	public List<ListOfValues> getList()
	{
		return giftFrequencyOptions;
	}
}
