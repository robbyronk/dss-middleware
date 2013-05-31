package org.cru.dss.give.functional;

import java.util.List;

import org.cru.dss.give.functional.clients.DrawDayClient;
import org.cru.give.webservices.DrawDayResource.DrawDay;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.joda.time.DateTime;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DrawDayResourceTest
{
	static final String RESOURCE_PREFIX = "rest";
	
	Environment environment = Environment.LOCAL;

	DrawDayClient client;
	
	@BeforeMethod
	public void createClient()
	{
        String restApiBaseUrl = environment.getUrlAndContext() + "/" + RESOURCE_PREFIX;
        client = ProxyFactory.create(DrawDayClient.class, restApiBaseUrl);
	}
	
	@Test
	public void testWhatever()
	{
		ClientResponse<List<DrawDay>> results = client.getValidDrawDays(new DateTime(2013, 6, 1, 0, 0, 0, 0));
		List<DrawDay> resultingMap = results.getEntity();
		
		resultingMap.toString();
	}
}
