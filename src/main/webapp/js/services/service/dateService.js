'use strict';

angular.module('dssMiddlewareApp')
	.factory('dateService', function() {
		var dateService = {};
		var months = ['January', 'February', 'March', 'April', 
		              'May', 'June', 'July', 'August', 'September', 
		              'October', 'November', 'December'];
		
		/**
		 * 
		 * @param month - this is a 1 based month vs a 0 based like 
		 * Javascript defaults to.
		 * 
		 * @returns the name of the month passed in
		 */
		dateService.getMonthAsString = function(month) {
			return months[month - 1];
		};
		
		/**
		 * Get the 1 based month for a specific millisecond date
		 */
		dateService.parseMonth = function(millisDate) {
			var date = new Date(millisDate);
			var month = date.getMonth();  //this is 0 based
			return month + 1;
		};
		
		/**
		 * Using the month, year, and day, create a date object
		 */
		dateService.createDate = function(year, month, day) {
			var date = new Date();
			var zeroIndexMonth = month - 1;
			date.setFullYear(year, zeroIndexMonth, day);
			return date;
		};
		
		return dateService;
	});