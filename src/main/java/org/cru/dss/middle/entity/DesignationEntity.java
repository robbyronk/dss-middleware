package org.cru.dss.middle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "S_PROD_INT")
public class DesignationEntity implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public enum Status
    {
        Active,
        Inactive,
        Pointed,
        Pending,
        Future;
    }

    @Id
    @Column(name = "ROW_ID")
    private String rowId;

    @Column(name = "PART_NUM")
    private String number;

    @Column(name = "STATUS_CD")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "ALIAS_NAME")
    private String description;

    @ManyToOne
    @JoinColumn(name = "VENDR_OU_ID")
    private AccountEntity account;

	@Column(name = "PAR_PROD_INT_ID") @Transient
	private String parentDesignationRowId;

    @Column(name = "SUB_TYPE_CD")
    private String designationType;

    @Column(name = "CATEGORY_CD")
    private String categoryCode;

    @Column(name = "BU_ID")
    private String organizationId;
    
    @OneToOne
    @JoinColumn(name = "ROW_ID")
    private DesignationExtensionEntity designationExtension;
    
    public String getNumber()
    {
        return number;
    }
    public void setNumber(String number)
    {
        this.number = number;
    }
    public Status getStatus()
    {
        return status;
    }
    public void setStatus(Status status)
    {
        this.status = status;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getRowId()
    {
        return rowId;
    }
    public void setRowId(String rowId)
    {
        this.rowId = rowId;
    }

    public AccountEntity getAccount()
    {
        return account;
    }
    public void setAccount(AccountEntity accountEntity)
    {
        this.account = accountEntity;
    }
	public String getParentDesignationRowId()
	{
		return parentDesignationRowId;
	}
	public void setParentDesignationRowId(String parentDesignationRowId)
	{
		this.parentDesignationRowId = parentDesignationRowId;
	}

    public String getDesignationType()
    {
        return designationType;
    }

    public void setDesignationType(String designationType)
    {
        this.designationType = designationType;
    }

    public String getCategoryCode()
    {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode)
    {
        this.categoryCode = categoryCode;
    }
	public String getOrganizationId()
	{
		return organizationId;
	}
	public void setOrganizationId(String organizationId)
	{
		this.organizationId = organizationId;
	}
	public DesignationExtensionEntity getDesignationExtension()
	{
		return designationExtension;
	}
	public void setDesignationExtension(DesignationExtensionEntity designationExtension)
	{
		this.designationExtension = designationExtension;
	}
}
