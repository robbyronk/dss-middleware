'use strict';

angular.module('dssMiddlewareApp')
	.controller('CheckoutPaymentMethodCtrl', function($scope, $routeParams, $location, 
			cartCrud, addressService, creditCardEditorService, paymentEditorService, dateService, 
			paymentService, paymentCrud, designationService, cartResolved, paymentMethodListResolved) {
		var params = $routeParams;
		var paymentSource = null;
		
		$scope.initCheckoutPaymentMethod = function() {
			creditCardEditorService.setLimitedEdit(false);
			creditCardEditorService.setPointToMailAddr(true);
			
			$scope.selectedPayment = {billingAddress: {}};
			$scope.initCommonVariables();
			
			$scope.transType = {};
			$scope.setInitialTransactionType(params, $scope.transType, $scope.selectedPayment, $scope.cart);
			
			$scope.setDisplayAddress(creditCardEditorService.getPointToMailAddr());
			paymentEditorService.setSelectedPayment($scope.selectedPayment);
			paymentSource = 'NEW';
		};
		
		$scope.initCheckoutSelectPaymentMethod = function() {
			creditCardEditorService.setLimitedEdit(true);
			$scope.paymentCurrentlyBeingEdited = null;
			addressService.setReadOnly(true);
			$scope.editingCreditCard = {beingEdited: false};
			$scope.initCommonVariables();
			
			$scope.selectedPayment = $scope.paymentMethodList.list[0];
			paymentEditorService.setSelectedPayment($scope.selectedPayment);
			creditCardEditorService.setPointToMailAddr($scope.shouldPointToMailAddrOnInit($scope.cart.mailingAddress, $scope.selectedPayment.billingAddress));
			$scope.setDisplayAddress(creditCardEditorService.getPointToMailAddr().isMailAddr);
			paymentSource = 'EXISTING';
		};
		
		$scope.initCommonVariables = function() {
			$scope.cart = cartResolved;
			$scope.paymentMethodList = paymentMethodListResolved;
			$scope.authentication = {loggedIn: true};
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
			$scope.editingCreditCard.beingEdited = true;
			$scope.paymentCurrentlyBeingEdited = {id: selectedPayment.existingPaymentId};
			
			/* If the user comes into the edit mode and the billing address is
			 * different from the mailing address, we want to make sure 
			 * the user can edit the address and that it is pre-filled.
			 */ 
			if(!creditCardEditorService.getPointToMailAddr().isMailAddr) {
				addressService.setReadOnly(false);
				addressService.setAddressToEdit(selectedPayment.billingAddress);
			}
			paymentSource = 'EXISTING_EDITED';
		};
		
		$scope.changeSelectedPayment = function() {
			$scope.editingCreditCard.beingEdited = false;
			paymentSource = 'EXISTING';
		};
		
		/**
		 * Format the given month and year for display.
		 */
		$scope.longMonthYearDate = function(month, year) {
			return dateService.getMonthAsString(parseInt(month)) + ' ' + year;
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
						transType.type = 'CC';
						selectedPayment.paymentMethod = 'Credit Card';
						hasMinistry = true;
						paymentEditorService.setCreditCardRequired(true);
						paymentEditorService.setBankAccountRequired(false);
					}
				}
				
				if(!hasMinistry) {
					transType.type = 'BA';
					selectedPayment.paymentMethod = 'EFT';
					selectedPayment.paymentType = 'Checking';
					paymentEditorService.setCreditCardRequired(false);
					paymentEditorService.setBankAccountRequired(true);
				}
			}
			else if(params.transType === 'BA') {
				transType.type = 'BA';
				selectedPayment.paymentMethod = 'EFT';
				selectedPayment.paymentType = 'Checking';
				paymentEditorService.setCreditCardRequired(false);
				paymentEditorService.setBankAccountRequired(true);
			}
			else {
				transType.type = params.transType;
				selectedPayment.paymentMethod = 'Credit Card';
				paymentEditorService.setCreditCardRequired(true);
				paymentEditorService.setBankAccountRequired(false);
			}
		};
		
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
			if(transType === 'BA') {
				$scope.selectedPayment = paymentEditorService.getSelectedPayment();
				if($scope.selectedPayment.paymentType == undefined) {
					$scope.selectedPayment.paymentType = 'Checking';
					paymentEditorService.setSelectedPayment($scope.selectedPayment);
				}
				paymentEditorService.setBankAccountRequired(true);
				paymentEditorService.setCreditCardRequired(false);
			}
			else {
				paymentEditorService.setBankAccountRequired(false);
				paymentEditorService.setCreditCardRequired(true);
			}
		};
		
		$scope.shouldPointToMailAddrOnInit = function(mailingAddress, billingAddress) {
			return billingAddress == null || billingAddress.streetAddress1 === '' || 
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
			
			if(creditCardEditorService.getPointToMailAddr().isMailAddr) {
				$scope.selectedPayment.billingAddress = $scope.cart.mailingAddress;
			}
			else {
				var addressToEdit = addressService.getAddressToEdit();
				addressService.removeUnusedAddressInformation(addressToEdit);
				$scope.selectedPayment.billingAddress = addressToEdit;
			}
			
			$scope.selectedPayment.paymentSource = paymentSource;
			$scope.cart.payment = $scope.selectedPayment;
			paymentEditorService.setSelectedPayment($scope.selectedPayment);
			
			$location.path('/CheckoutSubmitGift/' + $scope.cart.cartId); //TODO: put this after the updates/creates
			
			//TODO: Do we want to do client side validation on credit card expired?
			//TODO: Add a create payment method type thing
//			cartCrud.updateCart($scope.cart).then(function() {
//				
//			});
		};
	});