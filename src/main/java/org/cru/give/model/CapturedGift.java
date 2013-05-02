package org.cru.give.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.api.client.util.Key;

//@Entity
//@Table(name="captured_gift_cart_gift")
public class CapturedGift
{
    @Key
    private String checkoutId;
    @Key
    private String designationId;
    
    private String quickEntryId;
//	private USDollar amount;
	
    @Column(name="CAMPAIGN_ID") /*we're really saving the campaign code here, not the row_id*/
	private String campaignCode;
	@Key
	private String giftDay;
	@Key
	private String giftFrequency;
	private Date startDate;
	private String motivation;
	
	private String commentToDonationServices;
	private String commentToStaff;
	
	/**
	 * "Donation" or "Recurring"
	 */
	private String orderType;
	
	
	private Date created;
	
	public CapturedGift()
	{
	}
	
	public CapturedGift(String checkoutId)
	{
		this.checkoutId = checkoutId;
	}
	
	public String getQuickEntryId()
	{
		return quickEntryId;
	}
	public void setQuickEntryId(String rowId)
	{
		this.quickEntryId = rowId;
	}
//	public USDollar getAmount()
//	{
//		return amount;
//	}
//	public void setAmount(USDollar amount)
//	{
//		this.amount = amount;
//	}
	public String getCampaignCode()
	{
		return campaignCode;
	}
	public void setCampaignCode(String campaignCode)
	{
		this.campaignCode = campaignCode;
	}
	public String getGiftDay()
	{
		return giftDay;
	}
	public void setGiftDay(String giftDay)
	{
		this.giftDay = giftDay;
	}
	public String getGiftFrequency()
	{
		return giftFrequency;
	}
	public void setGiftFrequency(String giftFreq)
	{
		this.giftFrequency = giftFreq;
	}
	public Date getStartDate()
	{
		return startDate;
	}
	public void setStartDate(Date startDt)
	{
		this.startDate = startDt;
	}
	public String getDesignationId()
	{
		return designationId;
	}
	public void setDesignationId(String desigId)
	{
		this.designationId = desigId;
	}
	public String getOrderType()
	{
		return orderType;
	}
	public void setOrderType(String orderType)
	{
		this.orderType = orderType;
	}
	public Date getCreated()
	{
		return created;
	}
	public void setCreated(Date created)
	{
		this.created = created;
	}

	public String getCheckoutId()
	{
		return checkoutId;
	}

	public void setCheckoutId(String checkoutId)
	{
		this.checkoutId = checkoutId;
	}

    public String getCommentToDonationServices()
    {
        return commentToDonationServices;
    }

    public void setCommentToDonationServices(String commentToDonationServices)
    {
        this.commentToDonationServices = commentToDonationServices;
    }

    public String getCommentToStaff()
    {
        return commentToStaff;
    }

    public void setCommentToStaff(String commentToStaff)
    {
        this.commentToStaff = commentToStaff;
    }

	public String getMotivation()
	{
		return motivation;
	}

	public void setMotivation(String motivation)
	{
		this.motivation = motivation;
	}
}
