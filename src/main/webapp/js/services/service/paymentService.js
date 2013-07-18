'use strict';

/**
 * This service is designed to contain logic pertaining 
 * to data specific to either a credit card or bank account 
 * payment method.
 */
angular.module('dssMiddlewareApp')
	.factory('paymentService', function() {
		var paymentService = {};
		
		paymentService.getAccountMasked = function(selectedPayment) {
			if(selectedPayment == undefined) return null;
			return '******' + selectedPayment.lastFourDigits;
		};
		
		/**
		 * Check to see if the selected payment profile will 
		 * expire in the next two months.
		 */
		paymentService.willExpireTwoMonths = function(selectedPayment, today) {
			if(selectedPayment == undefined) return false;
			
			var expMonth = parseInt(selectedPayment.expirationMonth) - 1; //Subtract one month because Javascript is 0 based and we are 1 based
			var expirationDate = new Date(selectedPayment.expirationYear, expMonth + 1, 0); //This will set it to the last day of the expiration month
			var thisMonth = today.getMonth();
			var twoMonthDay = new Date(today);
			twoMonthDay.setMonth(thisMonth + 2);
			
			if(expirationDate.getTime() < twoMonthDay.getTime()) {
				return true;
			}
			else {
				return false;
			}
		};
		
		/**
		 * Check to see if the selected payment profile is 
		 * currently expired.
		 */
		paymentService.isExpired = function(selectedPayment, today) {
			if(selectedPayment == undefined) return false; //TODO: Maybe do a try/catch instead of this (same with willExpireTwoMonths)
			
			var expMonth = parseInt(selectedPayment.expirationMonth) - 1; //Subtract one month because Javascript is 0 based and we are 1 based
			var expirationDate = new Date(selectedPayment.expirationYear, expMonth + 1, 0); //This will set it to the last day of the expiration month
			
			if(today.getTime() >= expirationDate.getTime()) {
				return true;
			}
			else {
				return false;
			}
		};
		
		return paymentService;
	});