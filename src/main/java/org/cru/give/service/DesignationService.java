package org.cru.give.service;

import org.cru.give.clients.DesignationRESTfulResults;
import org.cru.give.clients.SiebelDesignationClient;
import org.cru.give.webservices.model.Designation;
import org.jboss.resteasy.client.ProxyFactory;

public class DesignationService
{
	
	public SiebelDesignationClient createClient()
	{
		String restApiBaseUrl = "https://wsapistaging.ccci.org/wsapi" + "/" + "rest";
		return ProxyFactory.create(SiebelDesignationClient.class, restApiBaseUrl);
	}
	
	public Designation getDesignationByNumber(String designation)
	{
		designation = "0550510";
		DesignationRESTfulResults results = createClient().lookupDesignation(designation, "-----------whatUpRibs");
		
		Designation desig = new Designation();
		desig.setId(results.getSiebelRowId());
		desig.setStatus(results.getDesignationStatus());
		desig.setNumber(results.getDesignationNumber());
		desig.setInternalDescription(results.getReceiptTitle());
		
		return desig;
	}
}
