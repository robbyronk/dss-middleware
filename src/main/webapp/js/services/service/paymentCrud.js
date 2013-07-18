'use strict';

/**
 * Handle create, read, update, delete of 
 * payment methods.
 */
angular.module('dssMiddlewareApp')
	.factory('paymentCrud', ['$q', 'cartCrud', function($q, cartCrud) { //TODO: Remove cartCrud when we have a list on the server
		var payment = {};
		
		payment.retrievePayment = function(paymentId) {
			
		};
		
		//TODO: Create a list on the server to retrieve (Current production has this in personalInfo)
		payment.retrievePaymentMethodList = function(cartId) {
			var deferred = $q.defer();
			cartCrud.retrieve(cartId).then(function(cart) {
				var paymentMethodList = {list: [cart.payment,
				                                {existingPaymentId: '2',
					 	 						 description: 'Test Bank Account', 
					 	 						 paymentMethod: 'EFT',
					 	 						 paymentType: 'Checking',
					 	 						 lastFourDigits: '6789',
					 	 						 bankName: 'Test Bank',
					 	 						 bankAccountNumber: '123456789',
					 	 						 bankRoutingNumber: '123123123',
					 	 						 creditCardToken: null,
					 	 						 creditCardHash: null,
					 	 						 expirationMonth: null,
					 	 						 expirationYear: null,
					 	 						 cardholderName: null,
					 	 						 billingAddress: {streetAddress1: '',
					 	 							 			  streetAddress2: '',
					 	 							 			  streetAddress3: '',
					 	 							 			  streetAddress4: '',
					 	 							 			  city: '',
					 	 							 			  state: '',
					 	 							 			  zipCode: '',
					 	 							 			  country: ''}}]};
				deferred.resolve(paymentMethodList);
			});
			return deferred.promise;
		};
		
		payment.create = function() {
			
		};
		
		payment.deletePayment = function(paymentId) {
			
		};
		
		return payment;
	}]);