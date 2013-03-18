package org.cru.dss.middle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "S_ORG_EXT")
public class AccountEntity implements java.io.Serializable
{
    @Id
    @Column(name = "ROW_ID")
    private String rowId;

    @Column(name = "SUPPRESS_SHARE_FLG")
    private String supressShareFlag;


    public String getRowId()
    {
        return rowId;
    }

    public void setRowId(String rowId)
    {
        this.rowId = rowId;
    }

    public String getSupressShareFlag()
    {
        return supressShareFlag;
    }

    public void setSupressShareFlag(String supressShareFlag)
    {
        this.supressShareFlag = supressShareFlag;
    }

    private static final long serialVersionUID = 1L;
}
