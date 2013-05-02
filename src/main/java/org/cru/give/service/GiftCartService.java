package org.cru.give.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.cru.give.model.CapturedNameAddressAndPayment;
import org.cru.give.webservices.model.GiftCart;
import org.cru.give.webservices.model.MailingAddress;

public class GiftCartService
{
	@Inject EntityManager em;
	
	public GiftCart fetchGiftCart(String cartId)
	{
		CapturedNameAddressAndPayment capNap = em.find(CapturedNameAddressAndPayment.class, new Long(cartId));
		
		GiftCart giftCart = new GiftCart();
		giftCart.setCartId(capNap.getCartId());
		giftCart.setMailingAddress(new MailingAddress());
		giftCart.getMailingAddress().setCity(capNap.getCity());
		
		return giftCart;
	}
	
	public String createNewGiftCart()
	{
		CapturedNameAddressAndPayment capNap = new CapturedNameAddressAndPayment();
		
		em.persist(capNap);
		
		em.flush();
		
		em.refresh(capNap);
		
		return capNap.getCartId().toString();
	}
	
	public void deleteGiftCart(String cartId)
	{
		em.remove(em.find(CapturedNameAddressAndPayment.class, new Long(cartId)));
	}
	
	public void updateGiftCart(GiftCart cart)
	{
		em.merge(cart.asCapturedNameAddressAndPayment());
	}
}
