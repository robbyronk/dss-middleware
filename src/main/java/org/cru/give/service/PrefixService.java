package org.cru.give.service;

import javax.inject.Inject;

import org.cru.give.cdi.PrefixOptionsProducer;
import org.cru.give.model.PrefixOptions;

public class PrefixService
{
	@Inject PrefixOptionsProducer prefixOptionsProducer;
	
	public PrefixOptions getPrefixOptions()
	{
		return prefixOptionsProducer.getPrefixOptions();
	}
}
