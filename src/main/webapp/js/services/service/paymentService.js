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
		paymentService.willExpireTwoMonths = function(selectedPayment) {
			if(selectedPayment == undefined) return false;
			
			var expMonth = parseInt(selectedPayment.expirationMonth) - 1; //Subtract one month because Javascript is 0 based and we are 1 based
			var expirationDate = new Date(selectedPayment.expirationYear, expMonth + 1, 0); //This will set it to the last day of the expiration month
			var today = new Date();
			var thisMonth = today.getMonth();
			today.setMonth(thisMonth + 2);
			
			if(expirationDate.getTime() < today.getTime()) {
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
		paymentService.isExpired = function(selectedPayment) {
			var expMonth = parseInt(selectedPayment.expirationMonth) - 1; //Subtract one month because Javascript is 0 based and we are 1 based
			var expirationDate = new Date(selectedPayment.expirationYear, expMonth + 1, 0); //This will set it to the last day of the expiration month
			var today = new Date();
			
			if(today.getTime() >= expirationDate.getTime()) {
				return true;
			}
			else {
				return false;
			}
		};
		
		return paymentService;
	});