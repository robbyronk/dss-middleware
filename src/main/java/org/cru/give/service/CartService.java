package org.cru.give.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.cru.give.model.CapturedNameAddressAndPayment;
import org.cru.give.webservices.model.GiftCart;
import org.cru.give.webservices.model.MailingAddress;
import org.cru.give.webservices.model.Payment;

public class CartService
{
	@Inject EntityManager em;
	
	@Inject GiftService giftService;
	
	public GiftCart fetchGiftCart(String cartId)
	{
		CapturedNameAddressAndPayment capNap = em.find(CapturedNameAddressAndPayment.class, new Long(cartId));
		
		if(capNap == null) throw new RuntimeException("Gift Cart: " + cartId + " was not found :(");
		
		GiftCart giftCart = new GiftCart();
		giftCart.setCartId(capNap.getCartId());
		giftCart.setMailingAddress(new MailingAddress());
		giftCart.getMailingAddress().setCity(capNap.getCity());
		giftCart.setPayment(new Payment());
		giftCart.getPayment().setDescription(capNap.getPaymentDescription());
		
		giftCart.setGifts(giftService.fetchGiftsForCart(cartId));
		
		return giftCart;
	}
	
	public Long createNewGiftCart()
	{
		CapturedNameAddressAndPayment capNap = new CapturedNameAddressAndPayment();
		
		em.persist(capNap);
		
		em.flush();
		
		em.refresh(capNap);
		
		return capNap.getCartId();
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
