package org.cru.give.validators;

import org.cru.give.util.AddressNormalizer;
import org.cru.give.webservices.model.MailingAddress;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressNormalizationTest
{

	@Test
	public void testCanadianMailingAddress() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		addr.setCountry("ca");
		
		new AddressNormalizer().normalize(addr);
		
		Assert.assertEquals(addr.getStreetAddress1(), "line1");
		Assert.assertEquals(addr.getStreetAddress2(), "line2");
		Assert.assertEquals(addr.getStreetAddress3(), "line3 line4 city state ZipCode");
		Assert.assertEquals(addr.getStreetAddress4(), "");
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
		Assert.assertEquals(addr.getStreetAddress3(), "line3 line4 city state ZipCode");
		Assert.assertEquals(addr.getStreetAddress4(), "");
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
		Assert.assertEquals(addr.getStreetAddress3(), "line3 city state ZipCode");
		Assert.assertEquals(addr.getStreetAddress4(), "");
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

	@Test
	public void testZipCodeCorrectVersions() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		addr.setZipCode("32832");
		addr.setZipCode("85254");
		addr.setZipCode("32832-4567");
		addr.setZipCode("99999-0000");

	}

	@Test
	public void testZipCodeIncorrectVersions() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		try { addr.setZipCode("1");
		Assert.fail("should have thrown exception");}
		catch(Exception e){System.out.println("Expected exception was caught. 1");}

		try	{ addr.setZipCode("12");
		Assert.fail("should have thrown exception");}
		catch(Exception e){System.out.println("Expected exception was caught. 2");}

		try	{ addr.setZipCode("123");
		Assert.fail("should have thrown exception");}
		catch(Exception e){System.out.println("Expected exception was caught. 3");}

		try	{ addr.setZipCode("1234");
		Assert.fail("should have thrown exception");}
		catch(Exception e){System.out.println("Expected exception was caught. 4");}

		try	{ addr.setZipCode("123456");
		Assert.fail("should have thrown exception");}
		catch(Exception e){System.out.println("Expected exception was caught. 5");}

		try	{ addr.setZipCode("12345x");
		Assert.fail("should have thrown exception");}
		catch(Exception e){System.out.println("Expected exception was caught. 6");}

		try	{ addr.setZipCode("12345--");
		Assert.fail("should have thrown exception");}
		catch(Exception e){System.out.println("Expected exception was caught. 7");}

		try	{ addr.setZipCode("12345-12345");
		Assert.fail("should have thrown exception");}
		catch(Exception e){System.out.println("Expected exception was caught. 8");}

		try	{ addr.setZipCode("12345-67");
		Assert.fail("should have thrown exception");}
		catch(Exception e){System.out.println("Expected exception was caught. 9");}

		try	{ addr.setZipCode("12345-678");
		Assert.fail("should have thrown exception");}
		catch(Exception e){System.out.println("Expected exception was caught. 10");}

		try	{addr.setZipCode("12345-67899");
		Assert.fail("should have thrown exception");}
		catch(Exception e){System.out.println("Expected exception was caught. 11");}

		try	{addr.setZipCode("xxxxx-xxxx");
		Assert.fail("should have thrown exception");}
		catch(Exception e){System.out.println("Expected exception was caught. 12");}

		try {addr.setZipCode("9876-54321");
		Assert.fail("should have thrown exception");}
		catch(Exception e){System.out.println("Expected exception was caught. 13 in all");}

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
