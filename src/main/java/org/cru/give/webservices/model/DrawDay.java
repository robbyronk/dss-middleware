package org.cru.give.webservices.model;

public class DrawDay implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	String key;
	String value;
	
	public String getKey()
	{
		return key;
	}
	public void setKey(String key)
	{
		this.key = key;
	}
	public String getValue()
	{
		return value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
}
