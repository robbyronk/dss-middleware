'use strict';

angular.module('dssMiddlewareApp')
	.controller('CheckoutPaymentMethodCtrl', function($scope, $routeParams, $location, 
			cartCrud, addressService, creditCardEditorService, paymentEditorService, 
			paymentService, paymentCrud, designationService, cartResolved, paymentMethodListResolved) {
		var params = $routeParams;
		
		$scope.initCheckoutPaymentMethod = function() {
			creditCardEditorService.setLimitedEdit(false);
			creditCardEditorService.setPointToMailAddr(true);
			
			$scope.selectedPayment = {billingAddress: {}};
			$scope.initCommonVariables();
			
			$scope.transType = {};
			$scope.setInitialTransactionType(params, $scope.transType, $scope.selectedPayment, $scope.cart);
			
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
			creditCardEditorService.setPointToMailAddr($scope.shouldPointToMailAddrOnInit($scope.cart.mailingAddress, $scope.selectedPayment.billingAddress));
			$scope.setDisplayAddress(creditCardEditorService.getPointToMailAddr());
		};
		
		$scope.initCommonVariables = function() {
			$scope.cart = cartResolved;
			$scope.paymentMethodList = paymentMethodListResolved;
			$scope.loggedIn = true;
			paymentEditorService.setIsCheckout(true);
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
		 * Allow the user to edit their selected credit card.
		 */
		$scope.editCreditCard = function(selectedPayment) {
			$scope.editingCreditCard = true;
			$scope.paymentIdCurrentlyBeingEdited = selectedPayment.existingPaymentId;
			
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
		
		$scope.setInitialTransactionType = function(params, transType, selectedPayment, cart) {
			/* If the user is coming into the checkout 
			 * payment page from the mailing address page, 
			 * we want to set the transaction type to credit 
			 * card if they are giving to a ministry designation, 
			 * otherwise set it to a bank account.
			 */
			if(params.transType == undefined) {
				var hasMinistry = false;
				for(var i = 0; i < cart.gifts.length; i++) {
					if($scope.isMinistry(cart.gifts[i].designationNumber)) {
//						transType = 'CC';
						transType.type = 'CC';
						selectedPayment.paymentMethod = 'Credit Card';
						hasMinistry = true;
					}
				}
				
				if(!hasMinistry) {
//					transType = 'BA';
					transType.type = 'BA';
					selectedPayment.paymentMethod = 'EFT';
					selectedPayment.paymentType = 'Checking';
				}
			}
			else if(params.transType == 'BA') {
//				transType = 'BA';
				transType.type = 'BA';
				selectedPayment.paymentMethod = 'EFT';
				selectedPayment.paymentType = 'Checking';
			}
			else {
//				transType = params.transType;
				transType.type = params.transType;
				selectedPayment.paymentMethod = 'Credit Card';
			}
		};
		
		//TODO: put this into a designation service
		$scope.isMinistry = function(designationNumber) {
			return designationService.isMinistry(designationNumber);
		};
		
		$scope.isExpired = function(selectedPayment) {
			return paymentService.isExpired(selectedPayment, new Date());
		};
		
		$scope.willExpireTwoMonths = function(selectedPayment) {
			return paymentService.willExpireTwoMonths(selectedPayment, new Date());
		};
		
		$scope.getAccountMasked = function(selectedPayment) {
			return paymentService.getAccountMasked(selectedPayment);
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
		
		$scope.shouldPointToMailAddrOnInit = function(mailingAddress, billingAddress) {
			return billingAddress == null || billingAddress.streetAddress1 == '' || 
				creditCardEditorService.areAddressesEffectivelyTheSame(mailingAddress, billingAddress);
		};
		
		/**
		 * Use an existing payment profile
		 */
		$scope.useExisting = function() {
			$location.path('/CheckoutSelectPaymentMethod/' + $scope.cart.cartId);
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
		
		$scope.continueToSubmitPage = function() {
			/*TODO: Figure out how we want to deal with updating only 
			 *		the selected payment
			 */
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