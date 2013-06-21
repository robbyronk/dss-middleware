'use strict';

angular.module('dssMiddlewareApp')
	.controller('CheckoutPaymentMethodCtrl', function($scope, $routeParams, cartCrud, addressService) {
		var params = $routeParams;
		
		$scope.initPage = function() {
			cartCrud.retrieve(params.cartId).then(function(data) {
				$scope.cart = data;
				$scope.pointToMailAddr = true; //TODO: This should be dynamic based on if the billing address and mailing address are the same and billing address is filled in
				$scope.paymentIdCurrentlyBeingEdited = null;
				$scope.limitedEdit = false;
				$scope.isCheckout = false;
				$scope.readOnly = true;
				
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
				
				$scope.selectedPayment = $scope.paymentMethodList[0];
				$scope.editingCreditCard = false;
				
				$scope.creditCardTypes = ['Visa', 'Mastercard', 'Discover', 'Diners Club'];
				$scope.availableExpirationMonths = [{number: '01', name: 'January'},{number: '02', name: 'February'},
				                                    {number: '03', name: 'March'},{number: '04', name: 'April'},
				                                    {number: '05', name: 'May'},{number: '06', name: 'June'},
				                                    {number: '07', name: 'July'},{number: '08', name: 'August'},
				                                    {number: '09', name: 'September'},{number: '10', name: 'October'},
				                                    {number: '11', name: 'November'},{number: '12', name: 'December'}];
				$scope.availableExpirationYears = ['2013','2014','2015','2016','2017','2018','2019','2020','2021',
				                                   '2022','2023','2024','2025','2026','2027','2028','2029','2030'];
				
				$scope.states = addressService.getStates();
				$scope.countries = addressService.getCountries();
				
				if($scope.pointToMailAddr) {
					$scope.displayAddress = $scope.cart.mailingAddress;
				}
				else {
					$scope.displayAddress = $scope.selectedPayment.billingAddress;
				}
			});
			
			
		};
		
		$scope.newBankAccount = function() {
			
		};
		
		$scope.newCreditCard = function() {
			
		};
		
		$scope.editCreditCard = function(paymentId) {
			$scope.editingCreditCard = true;
			$scope.paymentIdCurrentlyBeingEdited = paymentId;
			$scope.limitedEdit = true;
			$scope.isCheckout = true;
		};
		
		$scope.longMonthYearDate = function(month, year) {
			return $scope.getMonthLongName(month) + ' ' + year;
		};
		
		$scope.getMonthLongName = function(month) {
			var months = ['', 'January', 'February', 'March', 'April', 
			              'May', 'June', 'July', 'August', 'September', 
			              'October', 'November', 'December'];
			var monthAsNumber = parseInt(month);
			return months[monthAsNumber];
		};
		
		$scope.isExpired = function(selectedPayment) {
			
		};
		
		$scope.willExpireTwoMonths = function(selectedPayment) {
			
		};
		
		$scope.getAccountMasked = function(selectedPayment) {
			if(selectedPayment == undefined) return null;
			return '******' + selectedPayment.lastFourDigits;
		};
		
		$scope.changePointToMailAddr = function() {
			if($scope.pointToMailAddr) {
				$scope.displayAddress = $scope.cart.mailingAddress;
				$scope.readOnly = true;
			}
			else {
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
		
		$scope.isCanadianAddress = function(address) {
			return addressService.isCanada(address);
		};
		
		$scope.continueToSubmitPage = function() {
			if($scope.pointToMailAddr) {
				$scope.selectedPayment.billingAddress = $scope.displayAddress;
			}
			else {
				$scope.selectedPayment.billingAddress = $scope.addressToEdit;
			}
			
			$scope.cart.payment = $scope.selectedPayment;
			
			cartCrud.updateCart($scope.cart).then(function() {
				//TODO: Redirect to submit page
			});
		};
	});