package org.cru.dss.middle.jobs;

import javax.inject.Inject;

import org.cru.dss.middle.localcontent.LocalContentCacheService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class UpdateLocalContentJob implements Job
{

	@Inject LocalContentCacheService localCacheService;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		
		
	}

}
