package org.cru.give.service;

import javax.inject.Inject;

import org.cru.give.cdi.StateOptionsProducer;
import org.cru.give.model.StateOptions;

public class StateService
{
	@Inject StateOptionsProducer stateOptionsProducer;
	
	public StateOptions getStateOptions()
	{
		return stateOptionsProducer.getStateOptions();
	}
}
