package org.cru.give.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="captured_gift_cart_nam_adr_pmt")
public class CapturedNameAddressAndPayment implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "gift_cart_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="gift_cart_seq", sequenceName = "cru_gift_cart_seq", allocationSize=1)
	@Column(name = "CART_ID")
    private Long cartId;
	@Column(name = "CHECKOUT_ID")
	private String checkoutId;

	@Column(name = "CREATED")
	private Date created;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "STAGE")
	private String stage;
	
	@Column(name = "ACCOUNT_ID_FROM_MATCHNG_SRVICE")
	private String accountIdFromMatchngSrvice;
	@Column(name = "ACCOUNT_ID_FROM_ACCNT_CREATION")
	private String accountIdFromAccntCreation;
	@Column(name = "ACCOUNT_ID_FROM_LOGIN")
	private String accountIdFromLogin;
	@Column(name = "ACCOUNT_ID_FROM_NEW_DONOR")
	private String accountIdFromNewDonor;
	@Column(name = "ACCOUNT_ID_FROM_EXISTING_PID")
	private String accountIdFromExistingPid;
	@Column(name = "EXISTING_PEOPLE_ID")
	private String existingPeopleId;
	
	@Column(name = "ACCOUNT_TYPE")
	private String accountType;
	@Column(name = "ORGANIZATION_NAME")
	private String organizationName;
	
	@Column(name = "NAME_PREFIX")
	private String namePrefix;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "SUFFIX")
	private String suffix;
	
	@Column(name = "SP_NAME_PREFIX")
	private String spouseNamePrefix;
	@Column(name = "SP_FIRST_NAME")
	private String spouseFirstName;
	@Column(name = "SP_MIDDLE_NAME")
	private String spouseMiddleName;
	@Column(name = "SP_LAST_NAME")
	private String spouseLastName;
	@Column(name = "SP_SUFFIX")
	private String spouseSuffix;
	
	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;
	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;
	@Column(name = "ADDRESS_LINE3")
	private String addressLine3;
	@Column(name = "ADDRESS_LINE4")
	private String addressLine4;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "POSTAL_CODE")
	private String zipCode;
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "PAYMENT_PROFILE_ID")
	private String paymentProfileId;
	@Column(name = "PAYMENT_DESCR")
	private String paymentDescription;
	@Column(name = "PAYMENT_METHOD")
	private String paymentMethod;
	@Column(name = "PAYMENT_TYPE_CODE")
	private String paymentType;
	@Column(name = "LAST_FOUR_DIGITS")
	private String lastFourDigits;
	@Column(name = "BANK_NAME")
	private String bankName;
	@Column(name = "BANK_ACCOUNT_NUMBER")
	private String bankAccountNumber;
	@Column(name = "ABA_ROUTING_NUMBER")
	private String bankRoutingNumber;
	@Column(name = "TOKEN")
	private String creditCardToken;
	@Column(name = "CARD_HASH")
	private String creditCardHash;
	@Column(name = "EXPIRATION_MONTH")
	private String expirationMonth;
	@Column(name = "EXPIRATION_YEAR")
	private String expirationYear;
	@Column(name = "NAME_ON_CARD")
	private String nameOnCard;
	
	@Column(name = "CC_ADDRESS_LINE1")
	private String ccBillingAddressLine1;
	@Column(name = "CC_ADDRESS_LINE2")
	private String ccBillingAddressLine2;
	@Column(name = "CC_CITY")
	private String ccBillingCity;
	@Column(name = "CC_STATE")
	private String ccBillingState;
	@Column(name = "CC_POSTAL_CODE")
	private String ccBillingZipCode;
	@Column(name = "CC_COUNTRY")
	private String ccBillingCountry;
	
	
	public Long getCartId()
	{
		return cartId;
	}
	public void setCartId(Long cartId)
	{
		this.cartId = cartId;
	}
	public String getCheckoutId()
	{
		return checkoutId;
	}
	public void setCheckoutId(String checkoutId)
	{
		this.checkoutId = checkoutId;
	}
	public Date getCreated()
	{
		return created;
	}
	public void setCreated(Date created)
	{
		this.created = created;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getStage()
	{
		return stage;
	}
	public void setStage(String stage)
	{
		this.stage = stage;
	}
	public String getAccountIdFromMatchngSrvice()
	{
		return accountIdFromMatchngSrvice;
	}
	public void setAccountIdFromMatchngSrvice(String accountIdFromMatchngSrvice)
	{
		this.accountIdFromMatchngSrvice = accountIdFromMatchngSrvice;
	}
	public String getAccountIdFromAccntCreation()
	{
		return accountIdFromAccntCreation;
	}
	public void setAccountIdFromAccntCreation(String accountIdFromAccntCreation)
	{
		this.accountIdFromAccntCreation = accountIdFromAccntCreation;
	}
	public String getAccountIdFromLogin()
	{
		return accountIdFromLogin;
	}
	public void setAccountIdFromLogin(String accountIdFromLogin)
	{
		this.accountIdFromLogin = accountIdFromLogin;
	}
	public String getAccountIdFromNewDonor()
	{
		return accountIdFromNewDonor;
	}
	public void setAccountIdFromNewDonor(String accountIdFromNewDonor)
	{
		this.accountIdFromNewDonor = accountIdFromNewDonor;
	}
	public String getAccountIdFromExistingPid()
	{
		return accountIdFromExistingPid;
	}
	public void setAccountIdFromExistingPid(String accountIdFromExistingPid)
	{
		this.accountIdFromExistingPid = accountIdFromExistingPid;
	}
	public String getExistingPeopleId()
	{
		return existingPeopleId;
	}
	public void setExistingPeople_id(String existingPeopleId)
	{
		this.existingPeopleId = existingPeopleId;
	}
	public String getAccountType()
	{
		return accountType;
	}
	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}
	public String getOrganizationName()
	{
		return organizationName;
	}
	public void setOrganizationName(String organizationName)
	{
		this.organizationName = organizationName;
	}
	public String getNamePrefix()
	{
		return namePrefix;
	}
	public void setNamePrefix(String namePrefix)
	{
		this.namePrefix = namePrefix;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getMiddleName()
	{
		return middleName;
	}
	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getSuffix()
	{
		return suffix;
	}
	public void setSuffix(String suffix)
	{
		this.suffix = suffix;
	}
	public String getSpouseNamePrefix()
	{
		return spouseNamePrefix;
	}
	public void setSpouseNamePrefix(String spouseNamePrefix)
	{
		this.spouseNamePrefix = spouseNamePrefix;
	}
	public String getSpouseFirstName()
	{
		return spouseFirstName;
	}
	public void setSpouseFirstName(String spouseFirstName)
	{
		this.spouseFirstName = spouseFirstName;
	}
	public String getSpouseMiddleName()
	{
		return spouseMiddleName;
	}
	public void setSpouseMiddleName(String spouseMiddleName)
	{
		this.spouseMiddleName = spouseMiddleName;
	}
	public String getSpouseLastName()
	{
		return spouseLastName;
	}
	public void setSpouseLastName(String spouseLastName)
	{
		this.spouseLastName = spouseLastName;
	}
	public String getSpouseSuffix()
	{
		return spouseSuffix;
	}
	public void setSpouseSuffix(String spouseSuffix)
	{
		this.spouseSuffix = spouseSuffix;
	}
	public String getAddressLine1()
	{
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2()
	{
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3()
	{
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3)
	{
		this.addressLine3 = addressLine3;
	}
	public String getAddressLine4()
	{
		return addressLine4;
	}
	public void setAddressLine4(String addressLine4)
	{
		this.addressLine4 = addressLine4;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getZipCode()
	{
		return zipCode;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
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
	public String getPaymentProfileId()
	{
		return paymentProfileId;
	}
	public void setPaymentProfileId(String paymentProfileId)
	{
		this.paymentProfileId = paymentProfileId;
	}
	public String getPaymentDescription()
	{
		return paymentDescription;
	}
	public void setPaymentDescription(String paymentDescription)
	{
		this.paymentDescription = paymentDescription;
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
	public String getNameOnCard()
	{
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard)
	{
		this.nameOnCard = nameOnCard;
	}
	public String getCcBillingAddressLine1()
	{
		return ccBillingAddressLine1;
	}
	public void setCcBillingAddressLine1(String ccBillingAddressLine1)
	{
		this.ccBillingAddressLine1 = ccBillingAddressLine1;
	}
	public String getCcBillingAddressLine2()
	{
		return ccBillingAddressLine2;
	}
	public void setCcBillingAddressLine2(String ccBillingAddressLine2)
	{
		this.ccBillingAddressLine2 = ccBillingAddressLine2;
	}
	public String getCcBillingCity()
	{
		return ccBillingCity;
	}
	public void setCcBillingCity(String ccBillingCity)
	{
		this.ccBillingCity = ccBillingCity;
	}
	public String getCcBillingState()
	{
		return ccBillingState;
	}
	public void setCcBillingState(String ccBillingState)
	{
		this.ccBillingState = ccBillingState;
	}
	public String getCcBillingZipCode()
	{
		return ccBillingZipCode;
	}
	public void setCcBillingZipCode(String ccBillingZipCode)
	{
		this.ccBillingZipCode = ccBillingZipCode;
	}
	public String getCcBillingCountry()
	{
		return ccBillingCountry;
	}
	public void setCcBillingCountry(String ccBillingCountry)
	{
		this.ccBillingCountry = ccBillingCountry;
	}
	
}
