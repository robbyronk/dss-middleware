package org.cru.dss.middle.cdi;

import javax.enterprise.inject.Produces;

import org.cru.dss.middle.localcontent.LocalContentCacheService;

public class LocalContentCacheServiceProducer
{

	@Produces public LocalContentCacheService createLocalContentCacheService()
	{
		//TODO: this will eventually come from a properties file.
		return new LocalContentCacheService("middleware-content-cache/");
	}
}
