'use strict';

angular.module('dssMiddlewareApp')
	.controller('CheckoutPaymentMethodCtrl', function($scope, $routeParams, $location, cartCrud, addressService) {
		var params = $routeParams;
		
		$scope.initPage = function() {
			cartCrud.retrieve(params.cartId).then(function(data) {
				$scope.cart = data;
				$scope.paymentIdCurrentlyBeingEdited = null;
				$scope.limitedEdit = false;
				$scope.isCheckout = false;
				$scope.readOnly = true;
				$scope.loggedIn = true;
				
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
				
				
				
				$scope.creditCardTypes = ['American Express', 'Diners Club', 'Discover', 'MasterCard', 'Visa'];
				$scope.availableExpirationMonths = ['01', '02', '03', '04', '05', '06', 
				                                    '07', '08', '09', '10', '11', '12'];
				$scope.availableExpirationYears = ['2013','2014','2015','2016','2017','2018','2019','2020','2021',
				                                   '2022','2023','2024','2025','2026','2027','2028','2029','2030'];
				
				$scope.states = addressService.getStates();
				$scope.countries = addressService.getCountries();
				
				
				if($location.path().indexOf('/CheckoutPaymentMethod') !== -1) {
					$scope.selectedPayment = {billingAddress: {}};
					$scope.pointToMailAddr = true;
					
					if(params.transType == undefined || params.transType == null) {
						$scope.transType = 'BA';
					}
					else {
						$scope.transType = params.transType;
					}
				}
				else {
					$scope.selectedPayment = $scope.paymentMethodList[0];
					$scope.pointToMailAddr = $scope.areAddressesEffectivelyTheSame($scope.cart.mailingAddress, $scope.selectedPayment.billingAddress);
					$scope.editingCreditCard = false;
				}
				
				if($scope.pointToMailAddr) {
					$scope.displayAddress = $scope.cart.mailingAddress;
				}
				else {
					$scope.displayAddress = $scope.selectedPayment.billingAddress;
				}
			});
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
			if(!$scope.pointToMailAddr) {
				$scope.readOnly = false;
				$scope.addressToEdit = $scope.selectedPayment.billingAddress;
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
		
		/**
		 * Deal with the more complex logic involved with 
		 * switching between the mailing address on file and a 
		 * separate, specific billing address for this credit card.
		 */
		$scope.changePointToMailAddr = function() {
			if($scope.pointToMailAddr) {
				/* If we are using the mailing address, we do not need the ability to
				 * edit the fields, so we want to make it read only (so the required 
				 * is taken off and we can submit the form).
				 */ 
				$scope.displayAddress = $scope.cart.mailingAddress;
				$scope.readOnly = true;
			}
			else {
				/* If we are using a separate billing address, we need to be able to 
				 * edit the address fields.
				 */
				$scope.readOnly = false;
				$scope.addressToEdit = $scope.selectedPayment.billingAddress;
				
				//If blank, set country to the current mailing address country or USA if that is blank
				if($scope.addressToEdit.country == '' || $scope.addressToEdit.country == null) {
					if($scope.cart.mailingAddress != null && $scope.cart.mailingAddress.country != '') {
						$scope.addressToEdit.country = $scope.cart.mailingAddress.country;
					}
					else {
						$scope.addressToEdit.country = 'USA';
					}
				}
			}
		};
		
		/**
		 * Determine whether the mailing address and billing address are the same place.
		 */
		$scope.areAddressesEffectivelyTheSame = function(mailingAddress, billingAddress) {
			if(billingAddress == null || billingAddress.streetAddress1 == '' || 
					(billingAddress.streetAddress1 == mailingAddress.streetAddress1 && 
					 billingAddress.streetAddress2 == mailingAddress.streetAddress2 && 
					 billingAddress.city == mailingAddress.city && 
					 billingAddress.state == mailingAddress.state && 
					 billingAddress.country == mailingAddress.country)) {
				return true;
			}
			else {
				return false;
			}
		};
		
		$scope.setTransTypeVariables = function(transType) {
			if(transType == 'CC') {
				$scope.limitedEdit = false;
				$scope.isCheckout = true;
			}
			else {
				$scope.isCheckout = true;
			}
		};
		
		$scope.useExisting = function() {
			$location.path('/CheckoutSelectPaymentMethod/' + $scope.cart.cartId);
		};
		
		$scope.continueToSubmitPage = function() {
			if($scope.pointToMailAddr) {
				$scope.selectedPayment.billingAddress = $scope.cart.mailingAddress;
			}
			else {
				addressService.removeUnusedAddressInformation($scope.addressToEdit);
				$scope.selectedPayment.billingAddress = $scope.addressToEdit;
			}
			
			$scope.cart.payment = $scope.selectedPayment;
			
			//TODO: Do we want to do client side validation on credit card expired?
			cartCrud.updateCart($scope.cart).then(function() {
				//TODO: Redirect to submit page
			});
		};
	});