'use strict';

angular.module('dssMiddlewareApp')
	.controller('CheckoutPaymentMethodCtrl', function($scope, $routeParams, $location, cartCrud, addressService, creditCardEditorService, paymentEditorService, cartResolved) {
		var params = $routeParams;
		
		$scope.initCheckoutPaymentMethod = function() {
			creditCardEditorService.setLimitedEdit(false);
			$scope.selectedPayment = {billingAddress: {}};
			
			creditCardEditorService.setPointToMailAddr(true);
			$scope.initCommonVariables();
			
			if(params.transType == undefined) {
				//TODO: if(cart contains a ministry desig) set to CC else set to BA
				$scope.transType = 'BA';
				$scope.selectedPayment.paymentMethod = 'EFT';
				$scope.selectedPayment.paymentType = 'Checking';
			}
			else if(params.transType == 'BA') {
				$scope.transType = 'BA';
				$scope.selectedPayment.paymentMethod = 'EFT';
				$scope.selectedPayment.paymentType = 'Checking';
			}
			else {
				$scope.transType = params.transType;
			}
			
			$scope.setDisplayAddress(creditCardEditorService.getPointToMailAddr());
			paymentEditorService.setSelectedPayment($scope.selectedPayment);
		};
		
		$scope.initCheckoutSelectPaymentMethod = function() {
			creditCardEditorService.setLimitedEdit(true);
			$scope.paymentIdCurrentlyBeingEdited = null;
			addressService.setReadOnly(true);
			$scope.editingCreditCard = false;
			$scope.initCommonVariables();
			$scope.selectedPayment = $scope.paymentMethodList[0];
			paymentEditorService.setSelectedPayment($scope.selectedPayment);
			creditCardEditorService.setPointToMailAddr(creditCardEditorService.areAddressesEffectivelyTheSame($scope.cart.mailingAddress, $scope.selectedPayment.billingAddress));
			$scope.setDisplayAddress(creditCardEditorService.getPointToMailAddr());
		};
		
		$scope.initCommonVariables = function() {
			$scope.cart = cartResolved;
			$scope.loggedIn = true;
			paymentEditorService.setIsCheckout(true);
			
			/*TODO: Create a payment method list on the server to retrieve 
			 *	    and figure out how we want to deal with updating only 
			 *		the selected payment
			 */
			$scope.paymentMethodList = [$scope.cart.payment,
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
								 			  			  country: ''}}];
		};
		
		$scope.setDisplayAddress = function(pointToMailAddr) {
			if(pointToMailAddr) {
				addressService.setDisplayAddress($scope.cart.mailingAddress);
			}
			else {
				addressService.setDisplayAddress(paymentEditorService.getSelectedPayment().billingAddress);
			}
		};
		
		/**
		 * Create a new bank account profile
		 */
		$scope.newBankAccount = function() {
			$location.path('/CheckoutPaymentMethod/' + $scope.cart.cartId + '/BA');
		};
		
		/**
		 * Create a new credit card profile
		 */
		$scope.newCreditCard = function() {
			$location.path('/CheckoutPaymentMethod/' + $scope.cart.cartId + '/CC');
		};
		
		/**
		 * Allow the user to edit their selected credit card.
		 */
		$scope.editCreditCard = function(selectedPayment) {
			$scope.editingCreditCard = true;
			$scope.paymentIdCurrentlyBeingEdited = selectedPayment.paymentId;
			
			/* If the user comes into the edit mode and the billing address is
			 * different from the mailing address, we want to make sure 
			 * the user can edit the address and that it is pre-filled.
			 */ 
			if(!creditCardEditorService.getPointToMailAddr()) {
				addressService.setReadOnly(false);
				addressService.setAddressToEdit(selectedPayment.billingAddress);
			}
		};
		
		/**
		 * Format the given month and year for display.
		 */
		$scope.longMonthYearDate = function(month, year) {
			return $scope.getMonthLongName(month) + ' ' + year;
		};
		
		/**
		 * Given a numeric month, find the proper month name, 
		 * for example: 01 = January
		 */
		$scope.getMonthLongName = function(month) {
			var months = ['', 'January', 'February', 'March', 'April', 
			              'May', 'June', 'July', 'August', 'September', 
			              'October', 'November', 'December'];
			var monthAsNumber = parseInt(month);
			return months[monthAsNumber];
		};
		
		/**
		 * Check to see if the selected payment profile is 
		 * currently expired.
		 */
		$scope.isExpired = function(selectedPayment) {
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
		
		/**
		 * Check to see if the selected payment profile will 
		 * expire in the next two months.
		 */
		$scope.willExpireTwoMonths = function(selectedPayment) {
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
		
		$scope.getAccountMasked = function(selectedPayment) {
			if(selectedPayment == undefined) return null;
			return '******' + selectedPayment.lastFourDigits;
		};
		
		$scope.setTransTypeVariables = function(transType) {
			if(transType == 'BA') {
				$scope.selectedPayment = paymentEditorService.getSelectedPayment();
				if($scope.selectedPayment.paymentType == undefined) {
					$scope.selectedPayment.paymentType = 'Checking';
					paymentEditorService.setSelectedPayment($scope.selectedPayment);
				}
			}
		};
		
		$scope.useExisting = function() {
			$location.path('/CheckoutSelectPaymentMethod/' + $scope.cart.cartId);
		};
		
		$scope.continueToSubmitPage = function() {
			$scope.selectedPayment = paymentEditorService.getSelectedPayment();
			
			if(creditCardEditorService.getPointToMailAddr()) {
				$scope.selectedPayment.billingAddress = $scope.cart.mailingAddress;
			}
			else {
				var addressToEdit = addressService.getAddressToEdit();
				addressService.removeUnusedAddressInformation(addressToEdit);
				$scope.selectedPayment.billingAddress = addressToEdit;
			}
			
			$scope.cart.payment = $scope.selectedPayment;
			paymentEditorService.setSelectedPayment($scope.selectedPayment);
			
			//TODO: Do we want to do client side validation on credit card expired?
			//TODO: Add a create payment method type thing
			cartCrud.updateCart($scope.cart).then(function() {
				//TODO: Redirect to submit page
			});
		};
	});