package org.cru.give.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "S_EVT_ACT")
public class Activity implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	@Id @Column(name = "ROW_ID")
	private String activityId;
	@Column(name = "CEM_PLAN_END_DT")
	private Date runDateAndTime;
	@Column(name = "X_SUBTYPE")
	private String paymentType;
	@Column(name = "EVT_STAT_CD")
	private String drawRunStatus;

	
	public String getActivityId()
	{
		return activityId;
	}
	public void setActivityId(String activityId)
	{
		this.activityId = activityId;
	}
	public Date getRunDateAndTime()
	{
		return runDateAndTime;
	}
	public void setRunDateAndTime(Date runDateAndTime)
	{
		this.runDateAndTime = runDateAndTime;
	}
	public String getPaymentType()
	{
		return paymentType;
	}
	public void setPaymentType(String paymentType)
	{
		this.paymentType = paymentType;
	}
	public String getDrawRunStatus()
	{
		return drawRunStatus;
	}
	public void setDrawRunStatus(String drawRunStatus)
	{
		this.drawRunStatus = drawRunStatus;
	}
	
}
