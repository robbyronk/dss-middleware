'use strict';

describe('Checkout payment method controller tests', function() {
	var scope = null;
	var cartResolved = {};
	var paymentMethodListResolved = {};
	
	describe('editCreditCard function test', function() {
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
						 	   expirationMonth: '06',
						 	   expirationYear: '2013',
						 	   cardholderName: 'Bob Jones',
						 	   billingAddress: {streetAddress1: '123',
				 			  			  	  	streetAddress2: 'Line2',
				 			  			  	  	streetAddress3: '',
				 			  			  	  	streetAddress4: '',
				 			  			  	  	city: 'Orlando',
				 			  			  	  	state: 'FL',
				 			  			  	  	zipCode: '32832',
				 			  			  	  	country: 'USA'}};
		
		describe('editing credit card', function() {
			beforeEach(module('dssMiddlewareApp'));

			beforeEach(inject(function($rootScope, $controller) {
				scope = $rootScope.$new();
				$controller('CheckoutPaymentMethodCtrl', {$scope: scope, cartResolved: cartResolved, paymentMethodListResolved: paymentMethodListResolved});
			}));
			
			it('should be true', function() {
				scope.editingCreditCard = {beingEdited: false};
				scope.editCreditCard(selectedPayment);
				var isEditable = scope.editingCreditCard.beingEdited;
				expect(isEditable).toBe(true);
			});
		});
		
		describe('payment ID currently being edited', function() {
			beforeEach(module('dssMiddlewareApp'));

			beforeEach(inject(function($rootScope, $controller) {
				scope = $rootScope.$new();
				$controller('CheckoutPaymentMethodCtrl', {$scope: scope, cartResolved: cartResolved, paymentMethodListResolved: paymentMethodListResolved});
			}));
			
			it('should equal 2', function() {
				scope.editingCreditCard = {beingEdited: false};
				scope.editCreditCard(selectedPayment);
				var paymentIdCurrentlyBeingEdited = scope.paymentCurrentlyBeingEdited.id;
				expect(paymentIdCurrentlyBeingEdited).toEqual('2');
			});
		});
		
		describe('read only', function() {
			beforeEach(module('dssMiddlewareApp'));

			beforeEach(inject(function($rootScope, $controller) {
				scope = $rootScope.$new();
				$controller('CheckoutPaymentMethodCtrl', {$scope: scope, cartResolved: cartResolved, paymentMethodListResolved: paymentMethodListResolved});
			}));
			
			it('should be false', inject(function(addressService, creditCardEditorService) {
				//Mimic coming into the select payment method page with differing mailing and billing addresses
				initCheckoutSelectPaymentMethod(addressService);
				creditCardEditorService.setPointToMailAddr(false);
				scope.editCreditCard(selectedPayment);
				expect(addressService.getReadOnly().isReadOnly).toBe(false);
			}));
			
			it('should be true', inject(function(addressService, creditCardEditorService) {
				//Mimic coming into the select payment method page with no billing address or the same mailing and billing address
				initCheckoutSelectPaymentMethod(addressService);
				creditCardEditorService.setPointToMailAddr(true);
				scope.editCreditCard(selectedPayment);
				expect(addressService.getReadOnly().isReadOnly).toBe(true);
			}));
		});
		
		describe('address to edit', function() {
			beforeEach(module('dssMiddlewareApp'));

			beforeEach(inject(function($rootScope, $controller) {
				scope = $rootScope.$new();
				$controller('CheckoutPaymentMethodCtrl', {$scope: scope, cartResolved: cartResolved, paymentMethodListResolved: paymentMethodListResolved});
			}));
			
			it('should be set to billing address', inject(function(addressService, creditCardEditorService) {
				//Mimic coming into the select payment method page with differing mailing and billing addresses
				initCheckoutSelectPaymentMethod(addressService);
				creditCardEditorService.setPointToMailAddr(false);
				scope.editCreditCard(selectedPayment);
				expect(addressService.getAddressToEdit()).toEqual(selectedPayment.billingAddress);
			}));
			
			it('should be empty', inject(function(addressService, creditCardEditorService) {
				//Mimic coming into the select payment method page with no billing address or the same mailing and billing address
				initCheckoutSelectPaymentMethod(addressService);
				creditCardEditorService.setPointToMailAddr(true);
				scope.editCreditCard(selectedPayment);
				expect(addressService.getAddressToEdit()).toEqual({});
			}));
		});
		
		
		function initCheckoutSelectPaymentMethod(addressService) {
			scope.paymentCurrentlyBeingEdited = null;
			addressService.setReadOnly(true);
			scope.editingCreditCard = {beingEdited: false};
		} 
	});
	
	describe('Payment type', function() {
		beforeEach(module('dssMiddlewareApp'));

		beforeEach(inject(function($rootScope, $controller) {
			scope = $rootScope.$new();
			$controller('CheckoutPaymentMethodCtrl', {$scope: scope, cartResolved: cartResolved, paymentMethodListResolved: paymentMethodListResolved});
		}));
		
		it('should be set to "Checking"', inject(function(paymentEditorService) {
			//Mimic coming to the payment method page not logged in
			var selectedPayment = {billingAddress: {}};
			paymentEditorService.setSelectedPayment(selectedPayment);
			
			expect(selectedPayment.paymentType).toBe(undefined);
			
			scope.setTransTypeVariables('BA');
			selectedPayment = paymentEditorService.getSelectedPayment();
			expect(selectedPayment.paymentType).toEqual('Checking');
		}));
		
		it('should be undefined', inject(function(paymentEditorService) {
			//Mimic coming to the payment method page not logged in, but with a ministry designation in the cart
			var selectedPayment = {billingAddress: {}};
			paymentEditorService.setSelectedPayment(selectedPayment);
			
			expect(selectedPayment.paymentType).toBe(undefined);
			
			scope.setTransTypeVariables('CC');
			selectedPayment = paymentEditorService.getSelectedPayment();
			expect(selectedPayment.paymentType).toBe(undefined);
		}));
	});
	
	describe('Initial transaction type', function() {
		beforeEach(module('dssMiddlewareApp'));

		beforeEach(inject(function($rootScope, $controller) {
			scope = $rootScope.$new();
			$controller('CheckoutPaymentMethodCtrl', {$scope: scope, cartResolved: cartResolved, paymentMethodListResolved: paymentMethodListResolved});
		}));
		
		it('should be set to Credit Card', function() {
			var cart = {gifts: [{commentsToDonationServices: null,
								 designationNumber: '2843160',
								 giftAmount: 50.0,
								 giftFrequency: "Monthly",
								 motivationCode: null,
								 campaignCode: null,
								 commentsToRecipient: "Testing Mailing Address",
								 dayOfMonth: "20",
								 validate: false,
								 giftId: 513,
								 cartId: 470,
								 startDate: 1371740972000}]
					  };
			var selectedPayment = {billingAddress: {}};
			var params = {transType: 'CC'};
			var transType = {};
			
			scope.setInitialTransactionType(params, transType, selectedPayment, cart);
			expect(transType.type).toEqual('CC');
			expect(selectedPayment.paymentMethod).toEqual('Credit Card');
			
			//This will come out as Credit Card because there is a ministry in the cart
			selectedPayment = {billingAddress: {}};
			params = {};
			transType = {};
			
			scope.setInitialTransactionType(params, transType, selectedPayment, cart);
			expect(transType.type).toEqual('CC');
			expect(selectedPayment.paymentMethod).toEqual('Credit Card');
			
			//Add a Staff gift to the cart
			cart.gifts.push({commentsToDonationServices: null,
							 designationNumber: '0550510',
							 giftAmount: 50.0,
							 giftFrequency: "Monthly",
							 motivationCode: null,
							 campaignCode: null,
							 commentsToRecipient: "Testing Mailing Address",
							 dayOfMonth: "20",
							 validate: false,
							 giftId: 513,
							 cartId: 470,
							 startDate: 1371740972000});
			
			/* This will still come out as a Credit Card because, while there is 
			 * a Staff gift in the cart, we default to Credit Card if there are 
			 * any Ministry gifts (or Fund Appeal gifts) in the cart.
			 */
			selectedPayment = {billingAddress: {}};
			params = {};
			transType = {};
			
			scope.setInitialTransactionType(params, transType, selectedPayment, cart);
			expect(transType.type).toEqual('CC');
			expect(selectedPayment.paymentMethod).toEqual('Credit Card');
			
			cart = {gifts: [{commentsToDonationServices: null,
							 designationNumber: '2571058',
							 giftAmount: 50.0,
							 giftFrequency: "Monthly",
							 motivationCode: null,
							 campaignCode: null,
							 commentsToRecipient: "Testing Mailing Address",
							 dayOfMonth: "20",
							 validate: false,
							 giftId: 513,
							 cartId: 470,
							 startDate: 1371740972000}]
				  };
			
			//This will come out as Credit Card because there is a fund appeal  in the cart
			selectedPayment = {billingAddress: {}};
			params = {};
			transType = {};
			
			scope.setInitialTransactionType(params, transType, selectedPayment, cart);
			expect(transType.type).toEqual('CC');
			expect(selectedPayment.paymentMethod).toEqual('Credit Card');
		});
		
		it('should be set to EFT', function() {
			var cart = {gifts: [{commentsToDonationServices: null,
								 designationNumber: '0550510',
								 giftAmount: 50.0,
								 giftFrequency: "Monthly",
								 motivationCode: null,
								 campaignCode: null,
								 commentsToRecipient: "Testing Mailing Address",
								 dayOfMonth: "20",
								 validate: false,
								 giftId: 513,
								 cartId: 470,
								 startDate: 1371740972000}]
					  };
			var selectedPayment = {billingAddress: {}};
			var params = {transType: 'BA'};
			var transType = {};
			
			scope.setInitialTransactionType(params, transType, selectedPayment, cart);
			expect(transType.type).toEqual('BA');
			expect(selectedPayment.paymentMethod).toEqual('EFT');
			
			//This will come out as EFT because there is no ministry or fund appeal in the cart
			selectedPayment = {billingAddress: {}};
			params = {};
			transType = {};
			
			scope.setInitialTransactionType(params, transType, selectedPayment, cart);
			expect(transType.type).toEqual('BA');
			expect(selectedPayment.paymentMethod).toEqual('EFT');
		});
	});
});