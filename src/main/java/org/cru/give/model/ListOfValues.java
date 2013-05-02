package org.cru.give.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "S_LST_OF_VAL")
public class ListOfValues
{
	@Column(name = "VAL")
	String dropdownValue;
	@Column(name = "NAME")
	String dropdownName;
	@Column(name = "TYPE")
	String dropdownType;
	@Column(name = "ORDER_BY")
	String dropdownOrderBy;
	
	
	public String getDropdownValue()
	{
		return dropdownValue;
	}
	public void setDropdownValue(String dropdownValue)
	{
		this.dropdownValue = dropdownValue;
	}
	public String getDropdownName()
	{
		return dropdownName;
	}
	public void setDropdownName(String dropdownName)
	{
		this.dropdownName = dropdownName;
	}
	public String getDropdownType()
	{
		return dropdownType;
	}
	public void setDropdownType(String dropdownType)
	{
		this.dropdownType = dropdownType;
	}
	public String getDropdownOrderBy()
	{
		return dropdownOrderBy;
	}
	public void setDropdownOrderBy(String dropdownOrderBy)
	{
		this.dropdownOrderBy = dropdownOrderBy;
	}
	
}
