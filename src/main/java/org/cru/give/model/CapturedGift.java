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
@Table(name="captured_gift_cart_gift")
public class CapturedGift implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "gift_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="gift_seq", sequenceName = "cru_gift_seq", allocationSize=1)
	@Column(name = "GIFT_ID")
	private Long giftId;
	@Column(name = "CREATED")
	private Date created;
	
	/**
	 * Foreign keys
	 */
	@Column(name = "CART_ID")
	private Long cartId;
	@Column(name = "CHECKOUT_ID")
    private String checkoutId;
	@Column(name = "QUICK_ENTRY_ID")
    private String quickEntryId;
    
    /**
     * Required Gift information fields
     */
	
	/**
	 * "Donation" or "Recurring"
	 */
	@Column(name = "ORDER_TYPE")
    private String orderType;
	@Column(name = "DESIGNATION_ID")
    private String designationId;
	@Column(name = "AMOUNT")
    private Double amount;
	@Column(name = "GIFT_DAY")
    private String giftDay;
	@Column(name = "GIFT_FREQUENCY")
	private String giftFrequency;
	@Column(name = "START_DATE")
	private Date startDate;
	
	/**
	 * Optional marketing fields
	 */
    @Column(name = "CAMPAIGN_ID") /*we're really saving the campaign code here, not the row_id*/
	private String campaignCode;
    @Column(name = "MOTIVATION")
    private String motivation;
    
	/**
	 * Optional comments from gift-giver
	 */
    @Column(name = "COMMENT_TO_DONATION_SERVICES")
	private String commentToDonationServices;
    @Column(name = "COMMENT_TO_STAFF")
    private String commentToStaff;

	public Long getGiftId()
	{
		return giftId;
	}

	public void setGiftId(Long giftId)
	{
		this.giftId = giftId;
	}

	public Date getCreated()
	{
		return created;
	}

	public void setCreated(Date created)
	{
		this.created = created;
	}

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

	public String getQuickEntryId()
	{
		return quickEntryId;
	}

	public void setQuickEntryId(String quickEntryId)
	{
		this.quickEntryId = quickEntryId;
	}

	public String getDesignationId()
	{
		return designationId;
	}

	public void setDesignationId(String designationId)
	{
		this.designationId = designationId;
	}

	public Double getAmount()
	{
		return amount;
	}

	public void setAmount(Double amount)
	{
		this.amount = amount;
	}

	public String getGiftDay()
	{
		return giftDay;
	}

	public void setGiftDay(String giftDay)
	{
		this.giftDay = giftDay;
	}

	public String getGiftFrequency()
	{
		return giftFrequency;
	}

	public void setGiftFrequency(String giftFrequency)
	{
		this.giftFrequency = giftFrequency;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public String getCampaignCode()
	{
		return campaignCode;
	}

	public void setCampaignCode(String campaignCode)
	{
		this.campaignCode = campaignCode;
	}

	public String getMotivation()
	{
		return motivation;
	}

	public void setMotivation(String motivation)
	{
		this.motivation = motivation;
	}

	public String getCommentToDonationServices()
	{
		return commentToDonationServices;
	}

	public void setCommentToDonationServices(String commentToDonationServices)
	{
		this.commentToDonationServices = commentToDonationServices;
	}

	public String getCommentToStaff()
	{
		return commentToStaff;
	}

	public void setCommentToStaff(String commentToStaff)
	{
		this.commentToStaff = commentToStaff;
	}

	public String getOrderType()
	{
		return orderType;
	}

	public void setOrderType(String orderType)
	{
		this.orderType = orderType;
	}
}
