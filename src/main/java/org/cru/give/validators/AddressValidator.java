package org.cru.give.validators;

import org.ccci.util.Util;
import org.cru.give.webservices.model.MailingAddress;

public class AddressValidator
{
	
	public ValidationError validate(MailingAddress address)
	{
		if(Util.isBlank(address.getStreetAddress1()))
		{
			return new ValidationError(ValidationErrorType.MISSING_REQUIRED_FIELD, "address.streetAddress1");
		}
		
		if(Util.isBlank(address.getCountry()))
		{
			return new ValidationError(ValidationErrorType.MISSING_REQUIRED_FIELD, "address.country");
		}
		
		if(!Util.isBlank(address.getZipCode()) && !address.getZipCode().matches("\\d{5}-\\d{4}") && !address.getZipCode().matches("\\d{5}"))
		{
			return new ValidationError(ValidationErrorType.INVALID_VALUE, "address.zipCode");
		}

		return null;
	}
	 
}