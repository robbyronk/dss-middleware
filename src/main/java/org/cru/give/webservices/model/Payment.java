package org.cru.give.webservices.model;

public class Payment
{
	String existingPaymentId;
	String description;
	String paymentMethod;
	String paymentType;
	String lastFourDigits;
	String bankName;
	String bankAccountNumber;
	String bankRoutingNumber;
	String creditCardToken;
	String creditCardHash;
	String expirationMonth;
	String expirationYear;
	String cardholderName;
	
	MailingAddress billingAddress;

	public String getExistingPaymentId()
	{
		return existingPaymentId;
	}

	public void setExistingPaymentId(String existingPaymentId)
	{
		this.existingPaymentId = existingPaymentId;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getPaymentMethod()
	{
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentType()
	{
		return paymentType;
	}

	public void setPaymentType(String paymentType)
	{
		this.paymentType = paymentType;
	}

	public String getLastFourDigits()
	{
		return lastFourDigits;
	}

	public void setLastFourDigits(String lastFourDigits)
	{
		this.lastFourDigits = lastFourDigits;
	}

	public String getBankName()
	{
		return bankName;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	public String getBankAccountNumber()
	{
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber)
	{
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankRoutingNumber()
	{
		return bankRoutingNumber;
	}

	public void setBankRoutingNumber(String bankRoutingNumber)
	{
		this.bankRoutingNumber = bankRoutingNumber;
	}

	public String getCreditCardToken()
	{
		return creditCardToken;
	}

	public void setCreditCardToken(String creditCardToken)
	{
		this.creditCardToken = creditCardToken;
	}

	public String getCreditCardHash()
	{
		return creditCardHash;
	}

	public void setCreditCardHash(String creditCardHash)
	{
		this.creditCardHash = creditCardHash;
	}

	public String getExpirationMonth()
	{
		return expirationMonth;
	}

	public void setExpirationMonth(String expirationMonth)
	{
		this.expirationMonth = expirationMonth;
	}

	public String getExpirationYear()
	{
		return expirationYear;
	}

	public void setExpirationYear(String expirationYear)
	{
		this.expirationYear = expirationYear;
	}

	public String getCardholderName()
	{
		return cardholderName;
	}

	public void setCardholderName(String cardholderName)
	{
		this.cardholderName = cardholderName;
	}

	public MailingAddress getBillingAddress()
	{
		return billingAddress;
	}

	public void setBillingAddress(MailingAddress billingAddress)
	{
		this.billingAddress = billingAddress;
	}
}
