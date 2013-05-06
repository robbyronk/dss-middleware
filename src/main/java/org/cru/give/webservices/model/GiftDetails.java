package org.cru.give.webservices.model;

import java.util.Date;

import org.cru.give.model.CapturedGift;

public class GiftDetails implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	Long giftId;
	
	String designationNumber;
	Double giftAmount;
	String giftFrequency;
	String dayOfMonth;
	Date startDate;
	
	String motivationCode;
	String campaignCode;
	
	String commentsToRecipient;
	String commentsToDonationServices;
	
	boolean validate;
	
	public CapturedGift asCapturedGift()
	{
		CapturedGift capturedGift = new CapturedGift();
		
		capturedGift.setGiftId(giftId);
		
		capturedGift.setDesignationId(designationNumber);
		capturedGift.setAmount(giftAmount);
		
		capturedGift.setGiftFrequency(giftFrequency);
		capturedGift.setGiftDay(dayOfMonth);

		capturedGift.setMotivation(motivationCode);
		capturedGift.setCampaignCode(campaignCode);
		capturedGift.setCommentToDonationServices(commentsToDonationServices);
		capturedGift.setCommentToStaff(commentsToRecipient);
		
		return capturedGift;
	}
	
	public String getDesignationNumber()
	{
		return designationNumber;
	}
	public void setDesignationNumber(String designationNumber)
	{
		this.designationNumber = designationNumber;
	}
	public Double getGiftAmount()
	{
		return giftAmount;
	}
	public void setGiftAmount(Double giftAmount)
	{
		this.giftAmount = giftAmount;
	}
	public String getGiftFrequency()
	{
		return giftFrequency;
	}
	public void setGiftFrequency(String giftFrequency)
	{
		this.giftFrequency = giftFrequency;
	}
	public String getDayOfMonth()
	{
		return dayOfMonth;
	}
	public void setDayOfMonth(String dayOfMonth)
	{
		this.dayOfMonth = dayOfMonth;
	}
	public Date getStartDate()
	{
		return startDate;
	}
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}
	public String getMotivationCode()
	{
		return motivationCode;
	}
	public void setMotivationCode(String motivationCode)
	{
		this.motivationCode = motivationCode;
	}
	public String getCampaignCode()
	{
		return campaignCode;
	}
	public void setCampaignCode(String campaignCode)
	{
		this.campaignCode = campaignCode;
	}
	public String getCommentsToRecipient()
	{
		return commentsToRecipient;
	}
	public void setCommentsToRecipient(String commentsToRecipient)
	{
		this.commentsToRecipient = commentsToRecipient;
	}
	public String getCommentsToDonationServices()
	{
		return commentsToDonationServices;
	}
	public void setCommentsToDonationServices(String commentsToDonationServices)
	{
		this.commentsToDonationServices = commentsToDonationServices;
	}

	public Long getGiftId()
	{
		return giftId;
	}

	public void setGiftId(Long giftId)
	{
		this.giftId = giftId;
	}

	public boolean isValidate()
	{
		return validate;
	}

	public void setValidate(boolean validate)
	{
		this.validate = validate;
	}
}
