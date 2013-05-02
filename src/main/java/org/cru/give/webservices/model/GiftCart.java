package org.cru.give.webservices.model;

import java.util.List;

import org.cru.give.model.CapturedNameAddressAndPayment;

public class GiftCart implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	Long cartId;
	
	List<GiftDetails> gifts;
	
	NameInformation primaryName;
	NameInformation spouseName;
	List<NameInformation> additionalNames;
	
	MailingAddress mailingAddress;
	
	public CapturedNameAddressAndPayment asCapturedNameAddressAndPayment()
	{
		CapturedNameAddressAndPayment capturedNameAddressPayment = new CapturedNameAddressAndPayment();
		
		capturedNameAddressPayment.setCartId(cartId);
		
		if(primaryName != null)
		{
			capturedNameAddressPayment.setNamePrefix(primaryName.getNamePrefix());
			capturedNameAddressPayment.setFirstName(primaryName.getFirstName());
			capturedNameAddressPayment.setMiddleName(primaryName.getMiddleName());
			capturedNameAddressPayment.setLastName(primaryName.getLastName());
		}
		if(spouseName != null)
		{
			capturedNameAddressPayment.setSpouseNamePrefix(spouseName.getNamePrefix());
			capturedNameAddressPayment.setSpouseFirstName(spouseName.getFirstName());
			capturedNameAddressPayment.setSpouseMiddleName(spouseName.getMiddleName());
			capturedNameAddressPayment.setSpouseLastName(spouseName.getLastName());
		}
		
		if(mailingAddress != null)
		{
			capturedNameAddressPayment.setAddressLine1(mailingAddress.getStreetAddress1());
			capturedNameAddressPayment.setAddressLine2(mailingAddress.getStreetAddress2());
			capturedNameAddressPayment.setAddressLine3(mailingAddress.getStreetAddress3());
			capturedNameAddressPayment.setAddressLine4(mailingAddress.getStreetAddress4());
			capturedNameAddressPayment.setCity(mailingAddress.getCity());
		}
		return capturedNameAddressPayment;
	}
	
	public List<GiftDetails> getGifts()
	{
		return gifts;
	}
	public void setGifts(List<GiftDetails> gifts)
	{
		this.gifts = gifts;
	}
	public MailingAddress getMailingAddress()
	{
		return mailingAddress;
	}
	public void setMailingAddress(MailingAddress mailingAddress)
	{
		this.mailingAddress = mailingAddress;
	}
	public Long getCartId()
	{
		return cartId;
	}
	public void setCartId(Long cartId)
	{
		this.cartId = cartId;
	}
	public NameInformation getPrimaryName()
	{
		return primaryName;
	}
	public void setPrimaryName(NameInformation primaryName)
	{
		this.primaryName = primaryName;
	}
	public NameInformation getSpouseName()
	{
		return spouseName;
	}
	public void setSpouseName(NameInformation spouseName)
	{
		this.spouseName = spouseName;
	}
	public List<NameInformation> getAdditionalNames()
	{
		return additionalNames;
	}
	public void setAdditionalNames(List<NameInformation> additionalNames)
	{
		this.additionalNames = additionalNames;
	}
	
}
