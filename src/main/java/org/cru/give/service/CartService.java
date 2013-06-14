package org.cru.give.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.cru.give.model.CapturedNameAddressAndPayment;
import org.cru.give.webservices.model.GiftCart;
import org.cru.give.webservices.model.MailingAddress;
import org.cru.give.webservices.model.NameInformation;
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
		giftCart.getMailingAddress().setStreetAddress1(capNap.getAddressLine1());
		giftCart.getMailingAddress().setStreetAddress2(capNap.getAddressLine2());
		giftCart.getMailingAddress().setStreetAddress3(capNap.getAddressLine3());
		giftCart.getMailingAddress().setStreetAddress4(capNap.getAddressLine4());
		giftCart.getMailingAddress().setCity(capNap.getCity());
		giftCart.getMailingAddress().setState(capNap.getState());
		giftCart.getMailingAddress().setZipCode(capNap.getZipCode());
		giftCart.getMailingAddress().setCountry(capNap.getCountry());
		giftCart.setPayment(new Payment());
		giftCart.getPayment().setDescription(capNap.getPaymentDescription());
		giftCart.setPrimaryName(new NameInformation());
		giftCart.getPrimaryName().setNamePrefix(capNap.getNamePrefix());
		giftCart.getPrimaryName().setFirstName(capNap.getFirstName());
		giftCart.getPrimaryName().setMiddleName(capNap.getMiddleName());
		giftCart.getPrimaryName().setLastName(capNap.getLastName());
		giftCart.getPrimaryName().setSuffix(capNap.getSuffix());
		giftCart.setSpouseName(new NameInformation());
		giftCart.getSpouseName().setNamePrefix(capNap.getSpouseNamePrefix());
		giftCart.getSpouseName().setFirstName(capNap.getSpouseFirstName());
		giftCart.getSpouseName().setMiddleName(capNap.getSpouseMiddleName());
		giftCart.getSpouseName().setLastName(capNap.getSpouseLastName());
		giftCart.getSpouseName().setSuffix(capNap.getSpouseSuffix());
		giftCart.setPhoneNumber(capNap.getPhoneNumber());
		giftCart.setEmailAddress(capNap.getEmailAddress());
		giftCart.setOrganizationName(capNap.getOrganizationName());
		giftCart.setPersonType(capNap.getAccountType());
		
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
