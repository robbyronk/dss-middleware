'use strict';

angular.module('dssMiddlewareApp')
	.controller('CheckoutPaymentMethodCtrl', function($scope, $routeParams, cartCrud) {
		var params = $routeParams;
		
		$scope.initPage = function() {
			cartCrud.retrieve(params.cartId).then(function(data) {
				$scope.cart = data;
				$scope.pointToMailAddr = true;
				$scope.paymentIdCurrentlyBeingEdited = null;
				$scope.limitedEdit = false;
				$scope.isCheckout = false;
				
				//TODO: Get these from server
				$scope.paymentMethodList = [{existingPaymentId: '1',
											 description: 'Test Credit Card', 
											 paymentMethod: 'Credit Card',
											 paymentType: 'Visa',
											 lastFourDigits: '1111',
											 bankName: null,
											 bankAccountNumber: null,
											 bankRoutingNumber: null,
											 creditCardToken: '34q23jfhalr2r',
											 creditCardHash: '2w3jajraks32',
											 expirationMonth: 'April',
											 expirationYear: '2020',
											 cardholderName: 'Bob Jones',
											 billingAddress: {streetAddress1: '',
												 			  streetAddress2: '',
												 			  streetAddress3: '',
												 			  streetAddress4: '',
												 			  city: '',
												 			  state: '',
												 			  zipCode: '',
												 			  country: ''}},
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
				
				//TODO: Need to do DSSAddressEditor differently.  Probably a service of some sort.
				$scope.countries = [{countryCode: 'Canada', countryName: 'Canada'},
				                    {countryCode: 'Macedonia, The Former Yugoslav', countryName: 'Macedonia, The Former Yugoslav'},
				                    {countryCode: 'USA', countryName: 'USA'}, 
				                    {countryCode: 'Zimbabwe', countryName: 'Zimbabwe'}];
				
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
			return month + ' ' + year;
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
		
		//TODO: Move these two functions into some sort of service or something
		//TODO: Rename mailingAddress to address (in both of these functions)
		$scope.isUsa = function(mailingAddress) {
			if(mailingAddress == undefined) return false;
			return mailingAddress.country === 'USA';
		};
		
		$scope.isCanadianAddress = function(mailingAddress) {
			if(mailingAddress == undefined) return false;
			return mailingAddress.country === 'Canada';
		};
		
		$scope.continueToSubmitPage = function() {
			
		};
	});