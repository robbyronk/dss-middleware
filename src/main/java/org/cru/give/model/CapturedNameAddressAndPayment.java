package org.cru.give.model;

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
	@GeneratedValue(generator = "jpa_sucks", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="jpa_sucks", sequenceName = "cru_gift_cart_seq", allocationSize=1)
	@Column(name = "CART_ID")
    private Long cartId;
	@Column(name = "CHECKOUT_ID")
	private String checkoutId;

	@Column(name = "NAME_PREFIX")
	private String namePrefix;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "SP_NAME_PREFIX")
	private String spouseNamePrefix;
	@Column(name = "SP_FIRST_NAME")
	private String spouseFirstName;
	@Column(name = "SP_MIDDLE_NAME")
	private String spouseMiddleName;
	@Column(name = "SP_LAST_NAME")
	private String spouseLastName;
	
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
	
}
