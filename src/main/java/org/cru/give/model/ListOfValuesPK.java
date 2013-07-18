package org.cru.give.model;

/**
 * Primary key class to satisfy JPA requirements for 
 * composite keys
 * 
 * @author Bill Randall
 *
 */
public class ListOfValuesPK implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	String dropdownName;
	String dropdownType;
	
	public ListOfValuesPK() {}
	
	public ListOfValuesPK(String dropdownName, String dropdownType)
	{
		this.dropdownName = dropdownName;
		this.dropdownType = dropdownType;
	}
	
	public boolean equals(Object b)
	{
		return super.equals(b);
	}
	
	public int hashCode()
	{
		return super.hashCode();
	}
}