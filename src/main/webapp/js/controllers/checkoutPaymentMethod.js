'use strict';

angular.module('dssMiddlewareApp')
	.controller('CheckoutPaymentMethodCtrl', function($scope, $routeParams, $location, cartCrud, addressService, creditCardEditorService, cartResolved) {
		var params = $routeParams;
		var pointToMailAddr;
		
		$scope.initCheckoutPaymentMethod = function() {
			$scope.isCheckout = true;
			$scope.limitedEdit = false;
			$scope.agreeToTerms = false;
			$scope.selectedPayment = {billingAddress: {}};
			pointToMailAddr = true;
			creditCardEditorService.setPointToMailAddr(pointToMailAddr);
			$scope.initCommonVariables();
			$scope.routingHelp = "Routing Number is 9 digits surrounded by the &nbsp;<img src='images/RoutingIcon.gif'/>&nbsp; symbols and may be listed left or right of the Account Number. &nbsp;If your check has an ACH/RT number, enter that as your bank routing number.";
			$scope.accountHelp = "Account Number may be up to 17 digits and is usually listed left of the &nbsp;<img src='images/AccountIcon.gif'/>&nbsp; symbol.  &nbsp;Check Number may be listed left of the Account Number, but should not be included in the Account Number.";
			$scope.retypeAccountHelp = $scope.accountHelp;
			$scope.retypeBankAccountNumber = '';
			$scope.showRoutingHelpTip = false;
			$scope.showAccountHelpTip = false;
			$scope.showRetypeAccountHelpTip = false;
			
			if(params.transType == undefined || params.transType == null || params.transType == 'BA') {
				$scope.transType = 'BA';
				$scope.selectedPayment.paymentMethod = 'EFT';
				$scope.selectedPayment.paymentType = 'Checking';
			}
			else {
				$scope.transType = params.transType;
			}
			
			$scope.displayAddress = $scope.setDisplayAddress(pointToMailAddr);
			creditCardEditorService.setSelectedPayment($scope.selectedPayment);
		};
		
		$scope.initCheckoutSelectPaymentMethod = function() {
			$scope.isCheckout = true;
			$scope.limitedEdit = true;
			$scope.paymentIdCurrentlyBeingEdited = null;
			$scope.readOnly = true;
			$scope.editingCreditCard = false;
			$scope.initCommonVariables();
			$scope.selectedPayment = $scope.paymentMethodList[0];
			creditCardEditorService.setSelectedPayment($scope.selectedPayment);
			pointToMailAddr = creditCardEditorService.areAddressesEffectivelyTheSame($scope.cart.mailingAddress, $scope.selectedPayment.billingAddress);
			creditCardEditorService.setPointToMailAddr(pointToMailAddr);
			$scope.displayAddress = $scope.setDisplayAddress(pointToMailAddr);
		};
		
		$scope.initCommonVariables = function() {
			$scope.cart = cartResolved;
			$scope.loggedIn = true;
			$scope.creditCardTypes = ['American Express', 'Diners Club', 'Discover', 'MasterCard', 'Visa'];
			$scope.availableExpirationMonths = ['01', '02', '03', '04', '05', '06', 
			                                    '07', '08', '09', '10', '11', '12'];
			$scope.availableExpirationYears = ['2013','2014','2015','2016','2017','2018','2019','2020','2021',
			                                   '2022','2023','2024','2025','2026','2027','2028','2029','2030'];
			
			$scope.states = addressService.getStates();
			$scope.countries = addressService.getCountries();
			
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
				return $scope.cart.mailingAddress;
			}
			else {
				return $scope.selectedPayment.billingAddress;
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
		$scope.editCreditCard = function(paymentId) {
			$scope.editingCreditCard = true;
			$scope.paymentIdCurrentlyBeingEdited = paymentId;
			$scope.limitedEdit = true;
			$scope.isCheckout = true;
			
			/* If the user comes into the edit mode and the billing address is
			 * different from the mailing address, we want to make sure 
			 * the user can edit the address and that it is pre-filled.
			 */ 
			if(!creditCardEditorService.getPointToMailAddr()) {
				$scope.readOnly = false;
				creditCardEditorService.setAddressToEdit(creditCardEditorService.getSelectedPayment().billingAddress);
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
				if($scope.selectedPayment.paymentType == undefined) {
					$scope.selectedPayment.paymentType = 'Checking';
				}
			}
		};
		
		//TODO: Perhaps turn this into a directive
		$scope.showHelpTip = function(field, event) {
			if(field == 'routingNumber') {
				showHelpTip(event, $scope.routingHelp, false);
			}
			else if(field == 'accountNumber') {
				showHelpTip(event, $scope.accountHelp, false);
			}
			else if(field == 'retypeAccountNumber') {
				showHelpTip(event, $scope.retypeAccountHelp, false);
			}
		};
		
		$scope.useExisting = function() {
			$location.path('/CheckoutSelectPaymentMethod/' + $scope.cart.cartId);
		};
		
		$scope.continueToSubmitPage = function() {
			if(creditCardEditorService.getPointToMailAddr()) {
				$scope.selectedPayment.billingAddress = $scope.cart.mailingAddress;
			}
			else {
				addressService.removeUnusedAddressInformation(creditCardEditorService.getAddressToEdit());
				$scope.selectedPayment.billingAddress = creditCardEditorService.getAddressToEdit();
			}
			
			$scope.cart.payment = $scope.selectedPayment;
			
			//TODO: Do we want to do client side validation on credit card expired?
			//TODO: Add a create payment method type thing
			cartCrud.updateCart($scope.cart).then(function() {
				//TODO: Redirect to submit page
			});
		};
	});