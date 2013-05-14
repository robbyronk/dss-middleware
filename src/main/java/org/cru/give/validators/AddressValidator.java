package org.cru.give.validators;

import org.cru.give.util.AddressNormalizer;
import org.cru.give.webservices.model.MailingAddress;

public class AddressValidator
{
	
	public ValidationErrorType validate(MailingAddress address)
	{
		new AddressNormalizer().normalize(address);

		return null;
	}
	
}
