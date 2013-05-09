package org.cru.give.clients;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DesignationRESTfulResults
{
    private String siebelRowId;
    
    private String receiptTitle;
    private String secureStatus;
    private String designationNumber;
    private String designationType;
    private String designationStatus;
    
    private String organizationSiebelRowId;
    private String organizationShortName;
    private String organizationLongName;
    
    public DesignationRESTfulResults(){}
   
    
    //************************************************************************
    // Getters and Setters
    //************************************************************************
	public String getSiebelRowId()
	{
		return siebelRowId;
	}
	public void setSiebelRowId(String siebelRowId)
	{
		this.siebelRowId = siebelRowId;
	}
	public String getReceiptTitle()
	{
		return receiptTitle;
	}
	public void setReceiptTitle(String receiptTitle)
	{
		this.receiptTitle = receiptTitle;
	}
	public String getDesignationStatus()
	{
		return designationStatus;
	}
	public void setDesignationStatus(String designationStatus)
	{
		this.designationStatus = designationStatus;
	}
	public String getSecureStatus()
	{
		return secureStatus;
	}
	public void setSecureStatus(String secureStatus)
	{
		this.secureStatus = secureStatus;
	}
	public String getDesignationNumber()
	{
		return designationNumber;
	}
	public void setDesignationNumber(String designationNumber)
	{
		this.designationNumber = designationNumber;
	}
	public String getDesignationType()
	{
		return designationType;
	}
	public void setDesignationType(String designationType)
	{
		this.designationType = designationType;
	}
	public String getOrganizationSiebelRowId()
	{
		return organizationSiebelRowId;
	}
	public void setOrganizationSiebelRowId(String organizationSiebelRowId)
	{
		this.organizationSiebelRowId = organizationSiebelRowId;
	}
	public String getOrganizationShortName()
	{
		return organizationShortName;
	}
	public void setOrganizationShortName(String organizationShortName)
	{
		this.organizationShortName = organizationShortName;
	}
	public String getOrganizationLongName()
	{
		return organizationLongName;
	}
	public void setOrganizationLongName(String organizationLongName)
	{
		this.organizationLongName = organizationLongName;
	}
}
