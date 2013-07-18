'use strict';

describe('Payment service tests', function() {
	var today = new Date(2013, 6, 0); //Last day of June
	var currentMonth = today.getMonth() + 1; //Plus 1 because Javascript uses 0 based and we used 1 based
	var currentYear = today.getFullYear();
	var selectedPayment = {existingPaymentId: '2',
					 	   description: 'Test Credit Card', 
					 	   paymentMethod: 'Credit Card',
					 	   paymentType: 'Visa',
					 	   lastFourDigits: '1111',
					 	   bankName: null,
					 	   bankAccountNumber: null,
					 	   bankRoutingNumber: null,
					 	   creditCardToken: '1234abcd',
					 	   creditCardHash: 'bcdef1423',
					 	   expirationMonth: currentMonth.toString(),
					 	   expirationYear: currentYear.toString(),
					 	   cardholderName: 'Bob Jones',
					 	   billingAddress: {streetAddress1: '123',
			 			  			  	  	streetAddress2: 'Line2',
			 			  			  	  	streetAddress3: '',
			 			  			  	  	streetAddress4: '',
			 			  			  	  	city: 'Orlando',
			 			  			  	  	state: 'FL',
			 			  			  	  	zipCode: '32832',
			 			  			  	  	country: 'USA'}};
	
	describe('Credit card', function() {
		beforeEach(module('dssMiddlewareApp'));
		
		it('should expire in the next two months', inject(function(paymentService) {
			selectedPayment.expirationMonth = (currentMonth + 1).toString();
			selectedPayment.expirationYear = currentYear.toString();
			var willExpireTwoMonths = paymentService.willExpireTwoMonths(selectedPayment, today);
			expect(willExpireTwoMonths).toBe(true);
			
			selectedPayment.expirationMonth = currentMonth.toString();
			selectedPayment.expirationYear = currentYear.toString();
			willExpireTwoMonths = paymentService.willExpireTwoMonths(selectedPayment, today);
			expect(willExpireTwoMonths).toBe(true);
		}));
		
		it('should not expire in the next two months', inject(function(paymentService) {
			selectedPayment.expirationMonth = (currentMonth + 2).toString();
			selectedPayment.expirationYear = currentYear.toString();
			var willExpireTwoMonths = paymentService.willExpireTwoMonths(selectedPayment, today);
			expect(willExpireTwoMonths).toBe(false);
			
			selectedPayment.expirationMonth = (currentMonth + 3).toString();
			selectedPayment.expirationYear = currentYear.toString();
			willExpireTwoMonths = paymentService.willExpireTwoMonths(selectedPayment, today);
			expect(willExpireTwoMonths).toBe(false);
			
			selectedPayment.expirationMonth = currentMonth.toString();
			selectedPayment.expirationYear = (currentYear + 1).toString();
			willExpireTwoMonths = paymentService.willExpireTwoMonths(selectedPayment, today);
			expect(willExpireTwoMonths).toBe(false);
		}));
		
		it('should be expired', inject(function(paymentService) {
			selectedPayment.expirationMonth = (currentMonth - 1).toString();
			selectedPayment.expirationYear = currentYear.toString();
			var isExpired = paymentService.isExpired(selectedPayment, today);
			expect(isExpired).toBe(true);
			
			selectedPayment.expirationMonth = currentMonth.toString();
			selectedPayment.expirationYear = (currentYear -1).toString();
			isExpired = paymentService.isExpired(selectedPayment, today);
			expect(isExpired).toBe(true);
			
			selectedPayment.expirationMonth = currentMonth.toString();
			selectedPayment.expirationYear = currentYear.toString();
			isExpired = paymentService.isExpired(selectedPayment, today);
			expect(isExpired).toBe(true);
		}));
		
		it('should not be expired', inject(function(paymentService) {
			selectedPayment.expirationMonth = (currentMonth + 1).toString();
			selectedPayment.expirationYear = currentYear.toString();
			var isExpired = paymentService.isExpired(selectedPayment, today);
			expect(isExpired).toBe(false);
			
			selectedPayment.expirationMonth = currentMonth.toString();
			selectedPayment.expirationYear = (currentYear + 1).toString();
			isExpired = paymentService.isExpired(selectedPayment, today);
			expect(isExpired).toBe(false);
		}));
	});
	
	describe('Account masked', function() {
		beforeEach(module('dssMiddlewareApp'));
		
		var masked = null;
		
		it('should be ******1111', inject(function(paymentService) {
			masked = paymentService.getAccountMasked(selectedPayment);
			expect(masked).toEqual('******1111');
		}));
		
		it('should be null', inject(function(paymentService) {
			var selectedPaymentUndefined = undefined;
			masked = paymentService.getAccountMasked(selectedPaymentUndefined);
			expect(masked).toBeNull();
		}));
	});
});