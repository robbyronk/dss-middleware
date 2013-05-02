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

	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "CITY")
	private String city;
	
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
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}

}
