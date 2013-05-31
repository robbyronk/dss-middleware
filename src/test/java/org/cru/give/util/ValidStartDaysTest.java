package org.cru.give.util;

import java.util.Map;

import org.cru.give.service.mock.DrawRunServiceMock;
import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidStartDaysTest
{
	
	@Test
	public void testLookupThisMonth()
	{
		DateTime currentDateAndTime = new DateTime().withDayOfMonth(2).withMonthOfYear(5).withYear(2013).withMillisOfDay(0);
		ValidGiftStartDates giftStartDatesProcess = new ValidGiftStartDates(new DrawRunServiceMock(), currentDateAndTime);
		
		Map<String, String> validStartDays = giftStartDatesProcess.getGiftStartDaysForMonth(new DateTime(2013, 5, 1, 0, 0, 0, 0));

		/**
		 * The 5th should not be a valid option b/c the mock service says the May 5th, 2013 draw has begun. 
		 * The 10th-25th should all be viable though.
		 */
		Assert.assertFalse(validStartDays.containsKey("5"));
		Assert.assertTrue(validStartDays.containsKey("10"));
		Assert.assertTrue(validStartDays.containsKey("15"));
		Assert.assertTrue(validStartDays.containsKey("20"));
		Assert.assertTrue(validStartDays.containsKey("25"));
	}
	
	@Test
	public void testLookupNextMonth()
	{
		DateTime currentDateAndTime = new DateTime().withDayOfMonth(2).withMonthOfYear(5).withYear(2013).withMillisOfDay(0);
		ValidGiftStartDates giftStartDatesProcess = new ValidGiftStartDates(new DrawRunServiceMock(), currentDateAndTime);
		
		Map<String, String> validStartDays = giftStartDatesProcess.getGiftStartDaysForMonth(new DateTime(2013, 6, 1, 0, 0, 0, 0));

		/**
		 * The 5th should not be a valid option b/c the mock service says the May 5th, 2013 draw has begun. 
		 * The 10th-25th should all be viable though.
		 */
		Assert.assertTrue(validStartDays.containsKey("5"));
		Assert.assertTrue(validStartDays.containsKey("10"));
		Assert.assertTrue(validStartDays.containsKey("15"));
		Assert.assertTrue(validStartDays.containsKey("20"));
		Assert.assertTrue(validStartDays.containsKey("25"));
	}
	
	@Test
	public void testLookupThisMonthAdvancedDraw()
	{
		DrawRunServiceMock drawRunService = new DrawRunServiceMock();
		drawRunService.overrideEFTDrawDateAndTime(new DateTime().withDate(2013, 5, 10));
		
		DateTime currentDateAndTime = new DateTime().withDayOfMonth(2).withMonthOfYear(5).withYear(2013).withMillisOfDay(0);
		ValidGiftStartDates giftStartDatesProcess = new ValidGiftStartDates(drawRunService, currentDateAndTime);
		
		Map<String, String> validStartDays = giftStartDatesProcess.getGiftStartDaysForMonth(new DateTime(2013, 5, 1, 0, 0, 0, 0));

		/**
		 * The 5th & 10th should not be valid options b/c the mock service says the May 10th, 2013 draw has begun. 
		 * The 10th-25th should all be viable though.
		 */
		Assert.assertFalse(validStartDays.containsKey("5"));
		Assert.assertFalse(validStartDays.containsKey("10"));
		Assert.assertTrue(validStartDays.containsKey("15"));
		Assert.assertTrue(validStartDays.containsKey("20"));
		Assert.assertTrue(validStartDays.containsKey("25"));
	}
	
	@Test
	public void testLookupNearEndOfMonth()
	{
		DrawRunServiceMock drawRunService = new DrawRunServiceMock();
		drawRunService.overrideCreditCardDrawDateAndTime(new DateTime().withDate(2013, 5, 28));
		
		DateTime currentDateAndTime = new DateTime().withDayOfMonth(26).withMonthOfYear(5).withYear(2013).withMillisOfDay(0);
		ValidGiftStartDates giftStartDatesProcess = new ValidGiftStartDates(drawRunService, currentDateAndTime);
		
		Map<String, String> validStartDays = giftStartDatesProcess.getGiftStartDaysForMonth(new DateTime(2013, 5, 1, 0, 0, 0, 0));

		/**
		 * There should not be any valid options this month, b/c we're at the end of the month and the 
		 * June 5th draw has started.
		 */
		Assert.assertFalse(validStartDays.containsKey("5"));
		Assert.assertFalse(validStartDays.containsKey("10"));
		Assert.assertFalse(validStartDays.containsKey("15"));
		Assert.assertFalse(validStartDays.containsKey("20"));
		Assert.assertFalse(validStartDays.containsKey("25"));
		
		validStartDays = giftStartDatesProcess.getGiftStartDaysForMonth(new DateTime(2013, 6, 1, 0, 0, 0, 0));

		/**
		 * All June options should be valid
		 */
		Assert.assertTrue(validStartDays.containsKey("5"));
		Assert.assertTrue(validStartDays.containsKey("10"));
		Assert.assertTrue(validStartDays.containsKey("15"));
		Assert.assertTrue(validStartDays.containsKey("20"));
		Assert.assertTrue(validStartDays.containsKey("25"));
		
		validStartDays = giftStartDatesProcess.getGiftStartDaysForMonth(new DateTime(2013, 7, 1, 0, 0, 0, 0));

		/**
		 * All the July dates should be valid
		 */
		Assert.assertTrue(validStartDays.containsKey("5"));
		Assert.assertTrue(validStartDays.containsKey("10"));
		Assert.assertTrue(validStartDays.containsKey("15"));
		Assert.assertTrue(validStartDays.containsKey("20"));
		Assert.assertTrue(validStartDays.containsKey("25"));
	}
	
	@Test
	public void testLookupAroundEndOfMonth()
	{
		DrawRunServiceMock drawRunService = new DrawRunServiceMock();
		drawRunService.overrideEFTDrawDateAndTime(new DateTime().withDate(2013, 6, 5));
		
		DateTime currentDateAndTime = new DateTime().withDayOfMonth(29).withMonthOfYear(5).withYear(2013).withMillisOfDay(0);
		ValidGiftStartDates giftStartDatesProcess = new ValidGiftStartDates(drawRunService, currentDateAndTime);
		
		Map<String, String> validStartDays = giftStartDatesProcess.getGiftStartDaysForMonth(new DateTime(2013, 5, 1, 0, 0, 0, 0));

		/**
		 * No May dates should be options, we're passed them all and the draw has started.
		 */
		Assert.assertFalse(validStartDays.containsKey("5"));
		Assert.assertFalse(validStartDays.containsKey("10"));
		Assert.assertFalse(validStartDays.containsKey("15"));
		Assert.assertFalse(validStartDays.containsKey("20"));
		Assert.assertFalse(validStartDays.containsKey("25"));
		
		validStartDays = giftStartDatesProcess.getGiftStartDaysForMonth(new DateTime(2013, 6, 1, 0, 0, 0, 0));

		/**
		 * The 5th should not be a valid option b/c the mock service says the June 5th, 2013 draw has begun. 
		 * The 10th-25th should all be viable though.
		 */
		Assert.assertFalse(validStartDays.containsKey("5"));
		Assert.assertTrue(validStartDays.containsKey("10"));
		Assert.assertTrue(validStartDays.containsKey("15"));
		Assert.assertTrue(validStartDays.containsKey("20"));
		Assert.assertTrue(validStartDays.containsKey("25"));
		
		validStartDays = giftStartDatesProcess.getGiftStartDaysForMonth(new DateTime(2013, 7, 1, 0, 0, 0, 0));

		/**
		 * All July dates should be valid
		 */
		Assert.assertTrue(validStartDays.containsKey("5"));
		Assert.assertTrue(validStartDays.containsKey("10"));
		Assert.assertTrue(validStartDays.containsKey("15"));
		Assert.assertTrue(validStartDays.containsKey("20"));
		Assert.assertTrue(validStartDays.containsKey("25"));
		
	}
}
