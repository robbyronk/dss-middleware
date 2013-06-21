package org.cru.give.webservices.model;

import java.util.List;

import org.cru.give.model.CapturedNameAddressAndPayment;

public class GiftCart implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	Long cartId;
	
	String status;
	
	List<GiftDetails> gifts;
	
	NameInformation primaryName;
	NameInformation spouseName;
	List<NameInformation> additionalNames;
	
	MailingAddress mailingAddress;
	
	Payment payment;
	
	String emailAddress;
	String phoneNumber;
	String organizationName;
	String personType;
	
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
			capturedNameAddressPayment.setSuffix(primaryName.getSuffix());
		}
		if(spouseName != null)
		{
			capturedNameAddressPayment.setSpouseNamePrefix(spouseName.getNamePrefix());
			capturedNameAddressPayment.setSpouseFirstName(spouseName.getFirstName());
			capturedNameAddressPayment.setSpouseMiddleName(spouseName.getMiddleName());
			capturedNameAddressPayment.setSpouseLastName(spouseName.getLastName());
			capturedNameAddressPayment.setSpouseSuffix(spouseName.getSuffix());
		}
		
		if(mailingAddress != null)
		{
			capturedNameAddressPayment.setAddressLine1(mailingAddress.getStreetAddress1());
			capturedNameAddressPayment.setAddressLine2(mailingAddress.getStreetAddress2());
			capturedNameAddressPayment.setAddressLine3(mailingAddress.getStreetAddress3());
			capturedNameAddressPayment.setAddressLine4(mailingAddress.getStreetAddress4());
			capturedNameAddressPayment.setCity(mailingAddress.getCity());
			capturedNameAddressPayment.setState(mailingAddress.getState());
			capturedNameAddressPayment.setZipCode(mailingAddress.getZipCode());
			capturedNameAddressPayment.setCountry(mailingAddress.getCountry());
		}
		
		if(payment != null)
		{
			capturedNameAddressPayment.setPaymentDescription(payment.getDescription());
			capturedNameAddressPayment.setPaymentMethod(payment.getPaymentMethod());
			capturedNameAddressPayment.setPaymentType(payment.getPaymentType());
			capturedNameAddressPayment.setLastFourDigits(payment.getLastFourDigits());
			capturedNameAddressPayment.setBankName(payment.getBankName());
			capturedNameAddressPayment.setBankAccountNumber(payment.getBankAccountNumber());
			capturedNameAddressPayment.setBankRoutingNumber(payment.getBankRoutingNumber());
			capturedNameAddressPayment.setCreditCardToken(payment.getCreditCardToken());
			capturedNameAddressPayment.setCreditCardHash(payment.getCreditCardHash());
			capturedNameAddressPayment.setExpirationMonth(payment.getExpirationMonth());
			capturedNameAddressPayment.setExpirationYear(payment.getExpirationYear());
			capturedNameAddressPayment.setNameOnCard(payment.getCardholderName());
			capturedNameAddressPayment.setCcBillingAddressLine1(payment.getBillingAddress().getStreetAddress1());
			capturedNameAddressPayment.setCcBillingAddressLine2(payment.getBillingAddress().getStreetAddress2());
			capturedNameAddressPayment.setCcBillingCity(payment.getBillingAddress().getCity());
			capturedNameAddressPayment.setCcBillingState(payment.getBillingAddress().getState());
			capturedNameAddressPayment.setCcBillingZipCode(payment.getBillingAddress().getZipCode());
			capturedNameAddressPayment.setCcBillingCountry(payment.getBillingAddress().getCountry());
		}
		
		capturedNameAddressPayment.setEmailAddress(emailAddress);
		capturedNameAddressPayment.setPhoneNumber(phoneNumber);
		capturedNameAddressPayment.setOrganizationName(organizationName);
		capturedNameAddressPayment.setAccountType(personType);
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

	public Payment getPayment()
	{
		return payment;
	}

	public void setPayment(Payment payment)
	{
		this.payment = payment;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}
	
}
