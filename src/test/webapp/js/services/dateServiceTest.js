'use strict';

describe('Date service tests', function() {
	describe('Date', function() {
		
		params = {designationNumber: '2843160'};
		var controlDate;
		var date;
		
		beforeEach(module('dssMiddlewareApp'));
		
		it('should be May 5th, 2013', inject(function(dateService) {
			controlDate = new Date();
			controlDate.setFullYear(2013, 4, 5);
			removeTime(controlDate);
			date = dateService.createDate(2013, 5, 5);
			removeTime(date);
			expect(date).toEqual(controlDate);
		}));
		
		it('should be January 20th, 2014', inject(function(dateService) {
			controlDate = new Date();
			controlDate.setFullYear(2014, 0, 20);
			removeTime(controlDate);
			date = dateService.createDate(2014, 1, 20);
			removeTime(date);
			expect(date).toEqual(controlDate);
		}));
		
		function removeTime(date) {
			date.setHours(0);
			date.setMinutes(0);
			date.setSeconds(0);
			date.setMilliseconds(0);
		}
	});
	
	describe('Parsed year', function() {
		beforeEach(module('dssMiddlewareApp'));
		
		it('should be 2014', inject(function(dateService) {
			var millisDate = 1392047691000;
			var parsedYear = dateService.parseYear(millisDate);
			expect(parsedYear).toEqual(2014);
		}));
	});
	
	describe('Parsed month', function() {
		beforeEach(module('dssMiddlewareApp'));
		
		it('should be February', inject(function(dateService) {
			var millisDate = 1392047691000;
			var parsedMonth = dateService.parseMonth(millisDate);
			expect(parsedMonth).toEqual(2);
		}));
	});
		
	describe('Month as string', function() {
		var monthInt = 0;
		
		beforeEach(module('dssMiddlewareApp'));
		
		it('should be February', inject(function(dateService) {
			monthInt = 2;
			var monthString = dateService.getMonthAsString(monthInt);
			expect(monthString).toEqual('February');
		}));
		
		it('should be June', inject(function(dateService) {
			monthInt = 6;
			var monthString = dateService.getMonthAsString(monthInt);
			expect(monthString).toEqual('June');
		}));
	});
});