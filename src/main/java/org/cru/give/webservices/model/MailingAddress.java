package org.cru.give.webservices.model;

public class MailingAddress implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	String streetAddress1;
	String streetAddress2;
	String streetAddress3;
	String streetAddress4;
	String city;
	
	
	public String getStreetAddress1()
	{
		return streetAddress1;
	}
	public void setStreetAddress1(String streetAddress1)
	{
		this.streetAddress1 = streetAddress1;
	}
	public String getStreetAddress2()
	{
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2)
	{
		this.streetAddress2 = streetAddress2;
	}
	public String getStreetAddress3()
	{
		return streetAddress3;
	}
	public void setStreetAddress3(String streetAddress3)
	{
		this.streetAddress3 = streetAddress3;
	}
	public String getStreetAddress4()
	{
		return streetAddress4;
	}
	public void setStreetAddress4(String streetAddress4)
	{
		this.streetAddress4 = streetAddress4;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}

	
}
