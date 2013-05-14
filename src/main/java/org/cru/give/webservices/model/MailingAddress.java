package org.cru.give.webservices.model;

import org.ccci.util.Util;

public class MailingAddress implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	String streetAddress1;
	String streetAddress2;
	String streetAddress3;
	String streetAddress4;
	String city;
	String state;
	String zipCode;
	String country;
	
	/**
	 * Attempts to normalize the address to the specifications of the
	 * Cru Donation system.  The rules are this:
	 * 
	 * 1) If not a US or Canadian address, move city, state, zipcode up to first
	 *    available address line (append to line 3 if necessary)
	 * 
	 */
	public void normalize()
	{
		if(!(isUsa(getCountry()))) 
		{
			String line = "";
			if (!Util.isBlank(getCity())) line += " " + getCity().trim();
			if (!Util.isBlank(getState())) line += " " + getState().trim();
			if (!Util.isBlank(getZipCode())) line += " " + getZipCode().trim();
			line = line.trim();
			addToLastAddrLine(line);

			setCity("");
			setState("");
			setZipCode("");
		}
	}
	
    public boolean isUsa(String countryCode)
    {
        return "".equalsIgnoreCase(countryCode) ||
        		"us".equalsIgnoreCase(countryCode) ||
        		"usa".equalsIgnoreCase(countryCode);
    }
    
    private void addToLastAddrLine(String newLine)
	{
		if(Util.isBlank(getStreetAddress2()))
		{
			setStreetAddress2(newLine);
		}
		else if(Util.isBlank(getStreetAddress3()))
		{
			setStreetAddress3(newLine);
		}
		else if(Util.isBlank(getStreetAddress4()))
		{
			setStreetAddress4(newLine);
		}
		else
		{
			setStreetAddress4(getStreetAddress4() + " " + newLine);
		}
	}
	
	//*****************************************************************************
	// GETTERS AND SETTERS
	//*****************************************************************************
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
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getZipCode()
	{
		return zipCode;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	
}
