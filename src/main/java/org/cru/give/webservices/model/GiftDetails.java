package org.cru.give.webservices.model;

public class GiftDetails implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	String designationNumber;
	String giftAmount;
	
	public String getDesignationNumber()
	{
		return designationNumber;
	}
	public void setDesignationNumber(String designationNumber)
	{
		this.designationNumber = designationNumber;
	}
	public String getGiftAmount()
	{
		return giftAmount;
	}
	public void setGiftAmount(String giftAmount)
	{
		this.giftAmount = giftAmount;
	}
	

}
