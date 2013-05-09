package org.cru.give.webservices.model;

public class Designation implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	String id;
	String number;
	String status;
	String internalDescription;
	String externalDescription;
	
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getInternalDescription()
	{
		return internalDescription;
	}
	public void setInternalDescription(String internalDescription)
	{
		this.internalDescription = internalDescription;
	}
	public String getExternalDescription()
	{
		return externalDescription;
	}
	public void setExternalDescription(String externalDescription)
	{
		this.externalDescription = externalDescription;
	}

}
