package org.cru.give.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(ListOfValuesPK.class)
@Table(name = "S_LST_OF_VAL")
public class ListOfValues implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "VAL")
	String dropdownValue;
	@Id @Column(name = "NAME")
	String dropdownName;
	@Id @Column(name = "TYPE")
	String dropdownType;
	@Column(name = "ORDER_BY")
	String dropdownOrderBy;
	@Column(name = "DESC_TEXT")
	String descText;
	
	
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
	public String getDescText()
	{
		return descText;
	}
	public void setDescText(String descText)
	{
		this.descText = descText;
	}
}
