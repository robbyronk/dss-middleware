package org.cru.dss.middle.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "S_PROD_INT_X")
public class DesignationExtensionEntity implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "PAR_ROW_ID")
    private String rowId;
    
	@Column(name = "ATTRIB_26")
	private Date secureStartDate;
	
	@Column(name = "ATTRIB_27")
	private Date secureEndDate;

	public Date getSecureStartDate()
	{
		return secureStartDate;
	}

	public void setSecureStartDate(Date secureStartDate)
	{
		this.secureStartDate = secureStartDate;
	}

	public Date getSecureEndDate()
	{
		return secureEndDate;
	}

	public void setSecureEndDate(Date secureEndDate)
	{
		this.secureEndDate = secureEndDate;
	}

	public String getRowId()
	{
		return rowId;
	}

	public void setRowId(String rowId)
	{
		this.rowId = rowId;
	}
		
}
