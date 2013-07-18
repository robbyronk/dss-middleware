package org.cru.give.service;

import javax.inject.Inject;

import org.cru.give.cdi.SuffixOptionsProducer;
import org.cru.give.model.SuffixOptions;

public class SuffixService
{
	@Inject SuffixOptionsProducer suffixOptionsProducer;
	
	public SuffixOptions getSuffixOptions()
	{
		return suffixOptionsProducer.getSuffixOptions();
	}
}
