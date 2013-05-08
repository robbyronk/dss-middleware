package org.cru.give.validators;


public class ValidationError implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	String fieldName;
	ValidationErrorType error;
	String customErrorMessage;
	
	public ValidationError(ValidationErrorType error, String fieldName)
	{
		this(error, fieldName, null);
	}

	public ValidationError(ValidationErrorType error, String fieldName, String customErrorMessage)
	{
		this.error = error;
		this.fieldName = fieldName;
		this.customErrorMessage = customErrorMessage;
	}

	
	public ValidationErrorType getError()
	{
		return error;
	}
	public void setError(ValidationErrorType error)
	{
		this.error = error;
	}
	public String getFieldName()
	{
		return fieldName;
	}
	public void setFieldName(String fieldName)
	{
		this.fieldName = fieldName;
	}

	public String getCustomErrorMessage()
	{
		return customErrorMessage;
	}

	public void setCustomErrorMessage(String customErrorMessage)
	{
		this.customErrorMessage = customErrorMessage;
	}	
}
