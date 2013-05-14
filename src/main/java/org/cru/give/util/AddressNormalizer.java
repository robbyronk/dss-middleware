package org.cru.give.util;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import org.ccci.postalsoft.PostalAddress;
import org.ccci.postalsoft.PostalsoftService;
import org.ccci.postalsoft.Util_002fPostalSoft;
import org.ccci.webservices.services.postalsoft.CorrectionResult;
import org.cru.give.webservices.model.MailingAddress;

public class AddressNormalizer
{
	PostalsoftService postalsoft;

    private static final String namespaceURI = "http://postalsoft.ccci.org";
    private static final QName serviceName = new QName(namespaceURI ,"util/PostalSoft");

	public AddressNormalizer()
	{
		try
		{
			URL url = new URL("http://hart-a321.net.ccci.org:8680/wsapi/services/util/PostalSoft");
			Util_002fPostalSoft svc = new Util_002fPostalSoft(url, serviceName);
			postalsoft = svc.getUtil_002fPostalSoftHttpPort();
		}
		catch(MalformedURLException e)
		{
			throw new RuntimeException("Go harass the guy who coded this",e);
		}
	}
	
	public void normalize(MailingAddress address)
	{
		/**
		 * If we have a US address, run it through address correction
		 */
		if(address.isUsa(address.getCountry()))
		{
			CorrectionResult correctedAddress = postalsoft.correctAddress("dss", "MickeyMouseWasOnceHere", createPostalsoftAddressFrom(address));

			if(correctedAddress.getResultStatus().getValue().equals("SUCCESS"))
			{
				address = createMailingAddressFrom(correctedAddress);
			}
		}
		
		/**
		 * No matter what, run address normalization to shorten fields according to our Cru address standards
		 */
		address.normalize();
	}
	
	private MailingAddress createMailingAddressFrom(CorrectionResult correctedAddress)
	{
		MailingAddress mailingAddress = new MailingAddress();

		if(correctedAddress.getAddress().getValue().getAddressLine1() != null)
		{
			mailingAddress.setStreetAddress1(correctedAddress.getAddress().getValue().getAddressLine1().getValue());
		}
		if(correctedAddress.getAddress().getValue().getAddressLine2() != null)
		{
			mailingAddress.setStreetAddress2(correctedAddress.getAddress().getValue().getAddressLine2().getValue());
		}
		if(correctedAddress.getAddress().getValue().getAddressLine3() != null)
		{
			mailingAddress.setStreetAddress3(correctedAddress.getAddress().getValue().getAddressLine3().getValue());
		}
		if(correctedAddress.getAddress().getValue().getAddressLine4() != null)
		{
			mailingAddress.setStreetAddress4(correctedAddress.getAddress().getValue().getAddressLine4().getValue());
		}
		if(correctedAddress.getAddress().getValue().getCity() != null)
		{
			mailingAddress.setCity(correctedAddress.getAddress().getValue().getCity().getValue());
		}
		if(correctedAddress.getAddress().getValue().getState() != null)
		{
			mailingAddress.setState(correctedAddress.getAddress().getValue().getState().getValue());
		}
		if(correctedAddress.getAddress().getValue().getZip() != null)
		{
			mailingAddress.setZipCode(correctedAddress.getAddress().getValue().getZip().getValue());
		}
		return mailingAddress;
	}
	
	private PostalAddress createPostalsoftAddressFrom(MailingAddress address)
	{
		PostalAddress postalAddress = new PostalAddress();
		org.ccci.postalsoft.ObjectFactory postalsoftObjectFactory = new org.ccci.postalsoft.ObjectFactory();
		
		postalAddress.setAddressLine1(postalsoftObjectFactory.createPostalAddressAddressLine1(address.getStreetAddress1()));
		postalAddress.setAddressLine2(postalsoftObjectFactory.createPostalAddressAddressLine2(address.getStreetAddress2()));
		postalAddress.setAddressLine3(postalsoftObjectFactory.createPostalAddressAddressLine3(address.getStreetAddress3()));
		postalAddress.setAddressLine4(postalsoftObjectFactory.createPostalAddressAddressLine4(address.getStreetAddress4()));
		postalAddress.setCity(postalsoftObjectFactory.createPostalAddressCity(address.getCity()));
		postalAddress.setState(postalsoftObjectFactory.createPostalAddressState(address.getState()));
		postalAddress.setZip(postalsoftObjectFactory.createPostalAddressZip(address.getZipCode()));
		
		return postalAddress;
	}
}
