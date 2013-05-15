package org.cru.give.util;

import org.cru.give.util.AddressNormalizer;
import org.cru.give.webservices.model.MailingAddress;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressNormalizationTest
{

	@Test
	public void testCorrectedMailingAddress() throws Exception
	{
		MailingAddress addr = new MailingAddress();
		addr.setStreetAddress1("32 n college st");
		addr.setStreetAddress2("Apt c");
		addr.setCity("Athens");
		addr.setState("Ohio");
		addr.setZipCode("45701");
		addr.setCountry("us");
		
		addr = new AddressNormalizer().normalize(addr);
		
		Assert.assertEquals(addr.getStreetAddress1(), "32 N College St Ste C");
		Assert.assertEquals(addr.getStreetAddress2(), "");
		Assert.assertEquals(addr.getStreetAddress3(), "");
		Assert.assertEquals(addr.getStreetAddress4(), "");
		Assert.assertEquals(addr.getCity(), "Athens");
		Assert.assertEquals(addr.getState(), "OH");
		Assert.assertEquals(addr.getZipCode(), "45701-2464");
	}
	
	@Test
	public void testFourLineUsMailingAddress() throws Exception
	{
		MailingAddress addr = createStandardAddress();
        addr.setCountry("us");
        
        addr = new AddressNormalizer().normalize(addr);

        Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "line2");
		Assert.assertEquals(addr.getStreetAddress3(), "line3");
		Assert.assertEquals(addr.getStreetAddress4(), "line4");
		Assert.assertEquals(addr.getCity(), "city");
		Assert.assertEquals(addr.getState(), "state");
		Assert.assertEquals(addr.getZipCode(), "ZipCode");
	}
	
	@Test
	public void testThreeLineUsMailingAddress() throws Exception
	{
		MailingAddress addr = createStandardAddress();
        addr.setCountry("us");
        addr.setStreetAddress4("");
        
        addr = new AddressNormalizer().normalize(addr);

        Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "line2");
		Assert.assertEquals(addr.getStreetAddress3(), "line3");
		Assert.assertEquals(addr.getStreetAddress4(), "");
		Assert.assertEquals(addr.getCity(), "city");
		Assert.assertEquals(addr.getState(), "state");
		Assert.assertEquals(addr.getZipCode(), "ZipCode");
	}
	
	@Test
	public void testTwoLineUsMailingAddress() throws Exception
	{
		MailingAddress addr = createStandardAddress();
        addr.setCountry("us");
        addr.setStreetAddress3("");
        addr.setStreetAddress4("");
        
        addr = new AddressNormalizer().normalize(addr);

        Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "line2");
		Assert.assertEquals(addr.getStreetAddress3(), "");
		Assert.assertEquals(addr.getStreetAddress4(), "");
		Assert.assertEquals(addr.getCity(), "city");
		Assert.assertEquals(addr.getState(), "state");
		Assert.assertEquals(addr.getZipCode(), "ZipCode");
	}
	
	@Test
	public void testCanadianMailingAddress() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		addr.setCountry("ca");
		
		addr = new AddressNormalizer().normalize(addr);
		
		Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "line2");
		Assert.assertEquals(addr.getStreetAddress3(), "line3");
		Assert.assertEquals(addr.getStreetAddress4(), "line4 city state ZipCode");
		Assert.assertEquals(addr.getCity(), "");
		Assert.assertEquals(addr.getState(), "");
		Assert.assertEquals(addr.getZipCode(), "");
	}

	@Test
	public void testFourLineInternationalMailingAddress() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		addr.setCountry("x");
		
		addr = new AddressNormalizer().normalize(addr);
		
		Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "line2");
		Assert.assertEquals(addr.getStreetAddress3(), "line3");
		Assert.assertEquals(addr.getStreetAddress4(), "line4 city state ZipCode");
		Assert.assertEquals(addr.getCity(), "");
		Assert.assertEquals(addr.getState(), "");
		Assert.assertEquals(addr.getZipCode(), "");
	}

	@Test
	public void testThreeLineInternationalMailingAddress() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		addr.setCountry("x");
		addr.setStreetAddress4("");

		addr = new AddressNormalizer().normalize(addr);
		
		Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "line2");
		Assert.assertEquals(addr.getStreetAddress3(), "line3");
		Assert.assertEquals(addr.getStreetAddress4(), "city state ZipCode");
		Assert.assertEquals(addr.getCity(), "");
		Assert.assertEquals(addr.getState(), "");
		Assert.assertEquals(addr.getZipCode(), "");
	}

	@Test
	public void testTwoLineInternationalMailingAddress() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		addr.setCountry("x");
		addr.setStreetAddress3("");
		addr.setStreetAddress4("");

		addr = new AddressNormalizer().normalize(addr);
		
		Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "line2");
		Assert.assertEquals(addr.getStreetAddress3(), "city state ZipCode");
		Assert.assertEquals(addr.getStreetAddress4(), "");
		Assert.assertEquals(addr.getCity(), "");
		Assert.assertEquals(addr.getState(), "");
		Assert.assertEquals(addr.getZipCode(), "");
	}

	@Test
	public void testOneLineInternationalMailingAddress() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		addr.setCountry("x");
		addr.setStreetAddress2("");
		addr.setStreetAddress3("");
		addr.setStreetAddress4("");
		
		addr = new AddressNormalizer().normalize(addr);
		
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
