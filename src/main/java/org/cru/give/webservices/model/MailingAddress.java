package org.cru.give.webservices.model;

public class MailingAddress implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	String streetAddress1;
	String city;

	public String getStreetAddress1()
	{
		return streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1)
	{
		this.streetAddress1 = streetAddress1;
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
