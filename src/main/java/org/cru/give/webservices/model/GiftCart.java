package org.cru.give.webservices.model;

import java.util.List;

public class GiftCart implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	Long cartId; 
	
	List<GiftDetails> gifts;
	MailingAddress mailingAddress;
	
	
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
	
}
