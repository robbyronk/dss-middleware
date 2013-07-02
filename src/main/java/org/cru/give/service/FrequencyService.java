package org.cru.give.service;

import javax.inject.Inject;

import org.cru.give.cdi.GiftFrequencyOptionsProducer;
import org.cru.give.model.GiftFrequencyOptions;

public class FrequencyService
{
	@Inject GiftFrequencyOptionsProducer producer;
	
	public GiftFrequencyOptions getFrequencies()
	{
		return producer.getGiftFrequencyOptions();
	}
}
