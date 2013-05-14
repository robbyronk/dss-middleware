package org.cru.give.validators;

import org.cru.give.util.AddressNormalizer;
import org.cru.give.webservices.model.MailingAddress;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressNormalizationTest
{

	@Test
	public void testUsMailingAddress() throws Exception
	{
		MailingAddress addr = createStandardAddress();
        addr.setCountry("us");
        
		new AddressNormalizer().normalize(addr);

        Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "line2");
		Assert.assertEquals(addr.getStreetAddress3(), "line3");
		Assert.assertEquals(addr.getStreetAddress4(), "line4");
		Assert.assertEquals(addr.getCity(), "city");
		Assert.assertEquals(addr.getState(), "state");
		Assert.assertEquals(addr.getZipCode(), "ZipCode");
	}
	
	@Test
	public void testCanadianMailingAddress() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		addr.setCountry("ca");
		
		new AddressNormalizer().normalize(addr);
		
		Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "line2");
		Assert.assertEquals(addr.getStreetAddress3(), "line3");
		Assert.assertEquals(addr.getStreetAddress4(), "line4 city state ZipCode");
		Assert.assertEquals(addr.getCity(), "");
		Assert.assertEquals(addr.getState(), "");
		Assert.assertEquals(addr.getZipCode(), "");
	}

	@Test
	public void testInternationalMailingAddress() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		addr.setCountry("x");
		
		new AddressNormalizer().normalize(addr);
		
		Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "line2");
		Assert.assertEquals(addr.getStreetAddress3(), "line3");
		Assert.assertEquals(addr.getStreetAddress4(), "line4 city state ZipCode");
		Assert.assertEquals(addr.getCity(), "");
		Assert.assertEquals(addr.getState(), "");
		Assert.assertEquals(addr.getZipCode(), "");
	}

	@Test
	public void testInternationalMailingAddress2() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		addr.setCountry("x");
		addr.setStreetAddress4("");

		new AddressNormalizer().normalize(addr);
		
		Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "line2");
		Assert.assertEquals(addr.getStreetAddress3(), "line3");
		Assert.assertEquals(addr.getStreetAddress4(), "city state ZipCode");
		Assert.assertEquals(addr.getCity(), "");
		Assert.assertEquals(addr.getState(), "");
		Assert.assertEquals(addr.getZipCode(), "");
	}

	@Test
	public void testInternationalMailingAddress3() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		addr.setCountry("x");
		addr.setStreetAddress3("");
		addr.setStreetAddress4("");

		new AddressNormalizer().normalize(addr);
		
		Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "line2");
		Assert.assertEquals(addr.getStreetAddress3(), "city state ZipCode");
		Assert.assertEquals(addr.getStreetAddress4(), "");
		Assert.assertEquals(addr.getCity(), "");
		Assert.assertEquals(addr.getState(), "");
		Assert.assertEquals(addr.getZipCode(), "");
	}

	@Test
	public void testInternationalMailingAddress4() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		addr.setCountry("x");
		addr.setStreetAddress2("");
		addr.setStreetAddress3("");
		addr.setStreetAddress4("");
		
		new AddressNormalizer().normalize(addr);
		
		Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "city state ZipCode");
		Assert.assertEquals(addr.getStreetAddress3(), "");
		Assert.assertEquals(addr.getStreetAddress4(), "");
		Assert.assertEquals(addr.getCity(), "");
		Assert.assertEquals(addr.getState(), "");
		Assert.assertEquals(addr.getZipCode(), "");
	}

	private MailingAddress createStandardAddress()
	{
		MailingAddress addr = new MailingAddress();
		addr.setStreetAddress1("line1");
		addr.setStreetAddress2("line2");
		addr.setStreetAddress3("line3");
		addr.setStreetAddress4("line4");
		addr.setCity("city");
		addr.setState("state");
		addr.setZipCode("ZipCode");
		return addr;
	}

}
