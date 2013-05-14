package org.cru.give.validators;

import org.cru.give.webservices.model.MailingAddress;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressValidationTest
{
	@Test
	public void testZipCodeCorrectVersions() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		
		addr.setZipCode("32832");
		Assert.assertNull(new AddressValidator().validate(addr), "Valid zip-code, no error expected");
		
		addr = createStandardAddress();
		addr.setZipCode("85254");
		Assert.assertNull(new AddressValidator().validate(addr), "Valid zip-code, no error expected");
		
		addr = createStandardAddress();
		addr.setZipCode("32832-4567");
		Assert.assertNull(new AddressValidator().validate(addr), "Valid zip-code, no error expected");
		
		addr = createStandardAddress();
		addr.setZipCode("99999-0000");
		Assert.assertNull(new AddressValidator().validate(addr), "Valid zip-code, no error expected");
	}

	@Test
	public void testZipCodeIncorrectVersions() throws Exception
	{
		MailingAddress addr = createStandardAddress();
		
		addr.setZipCode("1");
		ValidationError error = new AddressValidator().validate(addr);
		
		Assert.assertNotNull(error, "Invalid zip-code, error expected");		
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);
		
		addr = createStandardAddress();
		addr.setZipCode("12");
		error = new AddressValidator().validate(addr);
		
		Assert.assertNotNull(error, "Invalid zip-code, error expected");		
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);

		addr = createStandardAddress();
		addr.setZipCode("123");
		error = new AddressValidator().validate(addr);

		Assert.assertNotNull(error, "Invalid zip-code, error expected");		
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);

		addr = createStandardAddress();
		addr.setZipCode("1234");
		error = new AddressValidator().validate(addr);
		
		Assert.assertNotNull(error, "Invalid zip-code, error expected");		
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);

		addr = createStandardAddress();
		addr.setZipCode("123456");
		error = new AddressValidator().validate(addr);

		Assert.assertNotNull(error, "Invalid zip-code, error expected");		
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);

		addr = createStandardAddress();
		addr.setZipCode("12345x");
		error = new AddressValidator().validate(addr);
		
		Assert.assertNotNull(error, "Invalid zip-code, error expected");		
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);

		addr = createStandardAddress();
		addr.setZipCode("12345--");
		error = new AddressValidator().validate(addr);
		
		Assert.assertNotNull(error, "Invalid zip-code, error expected");		
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);

		addr = createStandardAddress();
		addr.setZipCode("12345-12345");
		error = new AddressValidator().validate(addr);

		Assert.assertNotNull(error, "Invalid zip-code, error expected");		
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);

		addr = createStandardAddress();
		addr.setZipCode("12345-67");
		error = new AddressValidator().validate(addr);

		Assert.assertNotNull(error, "Invalid zip-code, error expected");		
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);

		addr = createStandardAddress();
		addr.setZipCode("12345-678");
		error = new AddressValidator().validate(addr);

		Assert.assertNotNull(error, "Invalid zip-code, error expected");		
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);

		addr = createStandardAddress();
		addr.setZipCode("12345-67899");
		error = new AddressValidator().validate(addr);

		Assert.assertNotNull(error, "Invalid zip-code, error expected");		
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);

		addr = createStandardAddress();
		addr.setZipCode("xxxxx-xxxx");
		error = new AddressValidator().validate(addr);

		Assert.assertNotNull(error, "Invalid zip-code, error expected");		
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);

		addr = createStandardAddress();
		addr.setZipCode("9876-54321");
		error = new AddressValidator().validate(addr);
		
		Assert.assertNotNull(error, "Invalid zip-code, error expected");		
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);
	}
	
	@Test
	public void testMissingStreetAddressOne()
	{
		MailingAddress addr = createStandardAddress();
		addr.setStreetAddress1(null);
		
		ValidationError error = new AddressValidator().validate(addr);
		Assert.assertNotNull(error, "Missing street address 1");		
		
		Assert.assertEquals(error.getError(), ValidationErrorType.MISSING_REQUIRED_FIELD);
	}
	
	@Test
	public void testMissingCountry()
	{
		MailingAddress addr = createStandardAddress();
		addr.setCountry(null);
		
		ValidationError error = new AddressValidator().validate(addr);
		Assert.assertNotNull(error, "Missing country");		
		
		Assert.assertEquals(error.getError(), ValidationErrorType.MISSING_REQUIRED_FIELD);
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
		addr.setCountry("USA");
		
		return addr;
	}
}
