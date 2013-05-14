package org.cru.give.validators;

import org.cru.give.webservices.model.GiftDetails;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DrawDayValidatorTest
{

	/**
	 * No validation should be required here.  We have a single gift so draw day is irrelevant.
	 * The gift will be picked up in the next available draw.
	 */
	@Test
	public void testSingleGift()
	{
		GiftDetails gift = new GiftDetails();
		gift.setGiftFrequency("Single");
		
		ValidationError error = new DrawDayValidator().validate(gift);
		
		Assert.assertNull(error, "No error expected");
	}
	
	/**
	 * No validation should be required here.  We have a single gift so draw day is irrelevant.
	 * The gift will be picked up in the next available draw.
	 */
	@Test
	public void testSingleGiftWithDrawDayOfMonth()
	{
		GiftDetails gift = new GiftDetails();
		gift.setGiftFrequency("Single");
		gift.setDayOfMonth("10");
		
		ValidationError error = new DrawDayValidator().validate(gift);
		
		/**really, should it throw an expection if a day is passed that will not be used*/
		Assert.assertNull(error, "No error expected");
	}
	
	/**
	 * We'll give a monthly gift a valid option of the 25th, no error expected.
	 */
	@Test
	public void testMonthlyGiftWithValidDrawDayOfMonth()
	{
		GiftDetails gift = new GiftDetails();
		gift.setGiftFrequency("Monthly");
		gift.setDayOfMonth("25");
		
		ValidationError error = new DrawDayValidator().validate(gift);
		
		Assert.assertNull(error, "No error expected");
	}
	
	/**
	 * We'll give a monthly gift no draw day of month.
	 */
	@Test
	public void testMonthlyGiftWithoutDrawDayOfMonth()
	{
		GiftDetails gift = new GiftDetails();
		gift.setGiftFrequency("Monthly");
		
		ValidationError error = new DrawDayValidator().validate(gift);
		
		Assert.assertNotNull(error, "Should throw an error here");
		Assert.assertEquals(error.getError(), ValidationErrorType.MISSING_REQUIRED_FIELD);
	}
	
	/**
	 * We'll give a monthly gift no draw day of month.
	 */
	@Test
	public void testMonthlyGiftWithInvalidDrawDayOfMonth()
	{
		GiftDetails gift = new GiftDetails();
		gift.setGiftFrequency("Monthly");
		gift.setDayOfMonth("17"); /**17 is not a valid option*/
		
		ValidationError error = new DrawDayValidator().validate(gift);
		
		Assert.assertNotNull(error, "Should throw an error here");
		Assert.assertEquals(error.getError(), ValidationErrorType.INVALID_VALUE);
	}
}
