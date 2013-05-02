package org.cru.give.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="captured_gift_cart_nam_adr_pmt")
public class CapturedNameAddressAndPayment
{
    private String cartId;
    
	private String accountType;
	private String organizationName;
	private String namePrefix;
	private String firstName;
	private String middleName;
	private String lastName;
	private String suffix;
	private String spNamePrefix;
	private String spFirstName;
	private String spMiddleName;
	private String spLastName;
	private String spSuffix;
	
	@Column(name="ADDRESS_LINE1")
	private String addressLine1;
	
	@Column(name="ADDRESS_LINE2")
	private String addressLine2;
	
	@Column(name="ADDRESS_LINE3")
	private String addressLine3;
	
	@Column(name="ADDRESS_LINE4")
	private String addressLine4;
	
	private String city;
	private String state;
	private String postalCode;
	private String country;
	
	private String phoneNumber;
	private String phoneType;
	private String emailAddress;
	private String emailType;
	
	private Date created;
	
	private String status;
	private String stage;

	private String accountResolutionContext;
	
	/**
	 * account id determined by the new donor de-duplication
	 * service (when the donor did not login)
	 */
    @Column(name="ACCOUNT_ID_FROM_MATCHNG_SRVICE")
	private String accountIdFromMatchingService;
	
    /**
     * account id looked up from the donor's login information 
     */
    private String accountIdFromLogin;
    
    /** account id generated when the donor went through the account
     * registration process prior to checkout
     */
    private String accountIdFromNewDonor;

    /**
     * If the donor provided a people id, this is the corresponding accountId
     * we found
     */
    private String accountIdFromExistingPid;

    /** 
     * account id generated for completely new donors who gave without 
     * creating an account themselves
     */
    @Column(name="ACCOUNT_ID_FROM_ACCNT_CREATION")
    private String accountIdFromAccountCreation;
    
    /** the people id provided by the user */
    private String existingPeopleId;


    private String paymentSource;
    private String paymentProfileId;
	
    /** either "EFT" or "Credit Card" */
    private String paymentMethod;
    
    private String lastFourDigits;
    private String bankName;
    private String bankAccountNumber;
    private String abaRoutingNumber;
    private String paymentDescr;
    
    private String token;
    private String cardHash;
    private String expirationMonth;
    private String expirationYear;
    
    /**
     * Used to hold either 
     *  the payment card organization (Visa, MasterCard, etc) for CC payments, OR
     *  the EFT account type: Checking or Savings
     */
    private String paymentTypeCode;
    
    private String nameOnCard;
    
    /** the billing address to use with credit card (optional) */
    @Column(name="CC_ADDRESS_LINE1")
    private String ccBillingAddressLine1;
    
    @Column(name="CC_ADDRESS_LINE2")
    private String ccBillingAddressLine2;
    
    @Column(name="CC_CITY")
    private String ccBillingCity;
    
    @Column(name="CC_STATE")
    private String ccBillingState;
    
    @Column(name="CC_POSTAL_CODE")
    private String ccBillingPostalCode;
    
    @Column(name="CC_COUNTRY")
    private String ccBillingCountry;
    
    private String processingErrorMessage;
    
    /**
     * Added for DSS-1340 - handling referrer ids
     */
    private String referrerIdType;
    private String referrerIdValue;
    
    /**
     * Added for DSS-1469 - storing giving client information
     */
    private String checkoutType;
    private String screenWidth;
    private String screenHeight;
    private String operatingSystem;

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
	public String getSpNamePrefix()
	{
		return spNamePrefix;
	}
	public void setSpNamePrefix(String spNamePrefix)
	{
		this.spNamePrefix = spNamePrefix;
	}
	public String getSpFirstName()
	{
		return spFirstName;
	}
	public void setSpFirstName(String spFirstName)
	{
		this.spFirstName = spFirstName;
	}
	public String getSpMiddleName()
	{
		return spMiddleName;
	}
	public void setSpMiddleName(String spMiddleName)
	{
		this.spMiddleName = spMiddleName;
	}
	public String getSpLastName()
	{
		return spLastName;
	}
	public void setSpLastName(String spLastName)
	{
		this.spLastName = spLastName;
	}
	public String getSpSuffix()
	{
		return spSuffix;
	}
	public void setSpSuffix(String spSuffix)
	{
		this.spSuffix = spSuffix;
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
	public String getPostalCode()
	{
		return postalCode;
	}
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneType()
	{
		return phoneType;
	}
	public void setPhoneType(String phoneType)
	{
		this.phoneType = phoneType;
	}
	public String getEmailAddress()
	{
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	public String getEmailType()
	{
		return emailType;
	}
	public void setEmailType(String emailType)
	{
		this.emailType = emailType;
	}
	public Date getCreated()
	{
		return created;
	}
	public void setCreated(Date created)
	{
		this.created = created;
	}
	public String getAccountIdFromMatchingService()
	{
		return accountIdFromMatchingService;
	}
	public void setAccountIdFromMatchingService(String matchedAcctId)
	{
		this.accountIdFromMatchingService = matchedAcctId;
	}
	public String getAccountIdFromAccountCreation()
	{
		return accountIdFromAccountCreation;
	}
	public void setAccountIdFromAccountCreation(String foundAcctId)
	{
		this.accountIdFromAccountCreation = foundAcctId;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getAccountType()
	{
		return accountType;
	}

	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}

    public String getAccountIdFromLogin()
    {
        return accountIdFromLogin;
    }

    public void setAccountIdFromLogin(String accountRowIdFromLogin)
    {
        this.accountIdFromLogin = accountRowIdFromLogin;
    }

    public String getAccountIdFromNewDonor()
    {
        return accountIdFromNewDonor;
    }

    public void setAccountIdFromNewDonor(String accountRowIdFromNewDonor)
    {
        this.accountIdFromNewDonor = accountRowIdFromNewDonor;
    }

    public String getExistingPeopleId()
    {
        return existingPeopleId;
    }

    public void setExistingPeopleId(String existingPeopleId)
    {
        this.existingPeopleId = existingPeopleId;
    }

    public String getPaymentMethod()
    {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
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

    public void setBankAccountNumber(String bankAccntNum)
    {
        this.bankAccountNumber = bankAccntNum;
    }

    public String getAbaRoutingNumber()
    {
        return abaRoutingNumber;
    }

    public void setAbaRoutingNumber(String abaRoutingNum)
    {
        this.abaRoutingNumber = abaRoutingNum;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String extTokenId)
    {
        this.token = extTokenId;
    }

    public String getCardHash()
    {
        return cardHash;
    }

    public void setCardHash(String cardHash)
    {
        this.cardHash = cardHash;
    }

    public String getExpirationMonth()
    {
        return expirationMonth;
    }

    public void setExpirationMonth(String expMonth)
    {
        this.expirationMonth = expMonth;
    }

    public String getExpirationYear()
    {
        return expirationYear;
    }

    public void setExpirationYear(String expYear)
    {
        this.expirationYear = expYear;
    }

    public String getPaymentTypeCode()
    {
        return paymentTypeCode;
    }

    public void setPaymentTypeCode(String paymentTypeCd)
    {
        this.paymentTypeCode = paymentTypeCd;
    }

    public String getPaymentProfileId()
    {
        return paymentProfileId;
    }

    public void setPaymentProfileId(String paymentProfileId)
    {
        this.paymentProfileId = paymentProfileId;
    }

    public String getStage()
    {
        return stage;
    }

    public void setStage(String stage)
    {
        this.stage = stage;
    }

    public String getProcessingErrorMessage()
    {
        return processingErrorMessage;
    }

    public void setProcessingErrorMessage(String processingErrorMessage)
    {
        this.processingErrorMessage = processingErrorMessage;
    }

    public String getAccountIdFromExistingPid()
    {
        return accountIdFromExistingPid;
    }

    public void setAccountIdFromExistingPid(String accountIdFromExistingPid)
    {
        this.accountIdFromExistingPid = accountIdFromExistingPid;
    }

    public String getAccountResolutionContext()
    {
        return accountResolutionContext;
    }

    public void setAccountResolutionContext(String accountResolutionContext)
    {
        this.accountResolutionContext = accountResolutionContext;
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

	public String getCcBillingPostalCode()
	{
		return ccBillingPostalCode;
	}

	public void setCcBillingPostalCode(String ccBillingPostalCode)
	{
		this.ccBillingPostalCode = ccBillingPostalCode;
	}

	public String getCcBillingCountry()
	{
		return ccBillingCountry;
	}

	public void setCcBillingCountry(String ccBillingCountry)
	{
		this.ccBillingCountry = ccBillingCountry;
	}

	public String getPaymentDescription()
	{
		return paymentDescr;
	}

	public void setPaymentDescription(String paymentDescription)
	{
		this.paymentDescr = paymentDescription;
	}

	public String getPaymentDescr()
	{
		return paymentDescr;
	}

	public void setPaymentDescr(String paymentDescr)
	{
		this.paymentDescr = paymentDescr;
	}

	public String getReferrerIdType()
	{
		return referrerIdType;
	}

	public void setReferrerIdType(String referrerIdType)
	{
		this.referrerIdType = referrerIdType;
	}

	public String getReferrerIdValue()
	{
		return referrerIdValue;
	}

	public void setReferrerIdValue(String referrerIdValue)
	{
		this.referrerIdValue = referrerIdValue;
	}

	public void setPaymentSource(String paymentSource)
	{
		this.paymentSource = paymentSource;
	}

	public String getCheckoutType()
	{
		return checkoutType;
	}

	public void setCheckoutType(String checkoutType)
	{
		this.checkoutType = checkoutType;
	}

	public String getOperatingSystem()
	{
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem)
	{
		this.operatingSystem = operatingSystem;
	}

	public String getScreenWidth()
	{
		return screenWidth;
	}

	public void setScreenWidth(String screenWidth)
	{
		this.screenWidth = screenWidth;
	}

	public String getScreenHeight()
	{
		return screenHeight;
	}

	public void setScreenHeight(String screenHeight)
	{
		this.screenHeight = screenHeight;
	}
}
