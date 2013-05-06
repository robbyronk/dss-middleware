package org.cru.give.validators;


public class ValidationError implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	String fieldName;
	ValidationErrorType error;
	
	public ValidationError(ValidationErrorType error, String fieldName)
	{
		this.error = error;
		this.fieldName = fieldName;
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
	
	
}
