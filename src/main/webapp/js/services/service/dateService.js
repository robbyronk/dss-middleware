'use strict';

angular.module('dssMiddlewareApp')
	.factory('dateService', function() {
		var dateService = {};
		var months = ['January', 'February', 'March', 'April', 
		              'May', 'June', 'July', 'August', 'September', 
		              'October', 'November', 'December'];
		
		/**
		 * Get the name of the month based on the number month
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
		 * 
		 * @param millisDate - a date in milliseconds
		 * 
		 * @returns the month of the date which was passed in, 
		 * this is 1 based, not 0 based
		 */
		dateService.parseMonth = function(millisDate) {
			var date = new Date(millisDate);
			var month = date.getMonth();  //this is 0 based
			return month + 1;
		};
		
		/**
		 * Get the year for a specific millisecond date
		 * 
		 * @param millisDate - a date in milliseconds
		 * 
		 * @returns the year of the date which was passed in
		 */
		dateService.parseYear = function(millisDate) {
			var date = new Date(millisDate);
			return date.getFullYear();
		};
		
		/**
		 * Using the month, year, and day, create a date object
		 * 
		 * @param year
		 * @param month
		 * @param day
		 * 
		 * @returns a date object with the passed in parameters
		 */
		dateService.createDate = function(year, month, day) {
			var date = new Date();
			var zeroIndexMonth = month - 1;
			date.setFullYear(year, zeroIndexMonth, day);
			return date;
		};
		
		return dateService;
	});