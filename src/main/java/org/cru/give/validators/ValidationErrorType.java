package org.cru.give.validators;

public enum ValidationErrorType implements java.io.Serializable
{
	INVALID_VALUE("Invalid value supplied for this field");

	private ValidationErrorType(String message)
	{
		this.message = message;
	}
	
	String message;
	
	@Override
	public String toString()
	{
		return message;
	}
}
