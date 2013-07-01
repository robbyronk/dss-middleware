'use strict';

angular.module('dssMiddlewareApp')
	.controller('CartInfoCtrl', function($scope, $location, paymentService, addressService, checkoutSubmitService, creditCardEditorService, paymentEditorService) {
		$scope.initCartInfo = function() {
			$scope.cart = checkoutSubmitService.getCart();
//			$scope.payment = {existingPaymentId: '2',
//				 	 description: 'Test Bank Account', 
//				 	 paymentMethod: 'EFT',
//				 	 paymentType: 'Checking',
//				 	 lastFourDigits: '6789',
//				 	 bankName: 'Test Bank',
//				 	 bankAccountNumber: '123456789',
//				 	 bankRoutingNumber: '123123123',
//				 	 creditCardToken: null,
//				 	 creditCardHash: null,
//				 	 expirationMonth: null,
//				 	 expirationYear: null,
//				 	 cardholderName: null,
//				 	 billingAddress: {streetAddress1: '',
//		 			  			  	  streetAddress2: '',
//		 			  			  	  streetAddress3: '',
//		 			  			  	  streetAddress4: '',
//		 			  			  	  city: '',
//		 			  			  	  state: '',
//		 			  			  	  zipCode: '',
//		 			  			  	  country: ''}};
			$scope.payment = $scope.cart.payment;
			
			if($scope.payment.paymentMethod == 'Credit Card') {
				$scope.setDisplayAddress($scope.shouldPointToMailAddrOnInit($scope.cart.mailingAddress, $scope.payment.billingAddress));
			}
			
			$scope.editable = false;  //This is only used by branded checkout right now
		};
		
		$scope.setDisplayAddress = function(pointToMailAddr) {
			if(pointToMailAddr) {
				addressService.setDisplayAddress($scope.cart.mailingAddress);
			}
			else {
				addressService.setDisplayAddress($scope.cart.payment.billingAddress);
			}
		};
		
		//TODO: Perhaps move this to a service
		$scope.shouldPointToMailAddrOnInit = function(mailingAddress, billingAddress) {
			return billingAddress == null || billingAddress.streetAddress1 == '' || 
				creditCardEditorService.areAddressesEffectivelyTheSame(mailingAddress, billingAddress);
		};
		
		/**
		 * Format the given month and year for display.
		 */
		$scope.longMonthYearDate = function(month, year) {
			return $scope.getMonthLongName(month) + ' ' + year;
		};
		
		//TODO: Move this to a service
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
		 * Display logic for the person name for the address block
		 */
		$scope.displayPersonName = function(name) {
			var prefix = '';
			var middleName = '';
			var suffix = '';
			
			if(name.namePrefix.length > 0) {
				prefix = name.namePrefix + ' ';
			}
			if(name.middleName.length > 0) {
				middleName = name.middleName + ' ';
			}
			if(name.suffix.length > 0) {
				suffix = ' ' + name.suffix;
			}
			return prefix + name.firstName + ' ' + middleName + name.lastName + suffix;
		};
		
		$scope.getAccountMasked = function(payment) {
			return paymentService.getAccountMasked(payment);
		};
		
		$scope.backToPayment = function() {
			//TODO: if(cart.paymentSource == NEW) redirect to /CheckoutPaymentMethod/cartId
			$location.path('/CheckoutSelectPaymentMethod/' + $scope.cart.cartId);
		};
		
		$scope.checkoutMailingAddress = function() {
			$location.path('/CheckoutMailingAddress/' + $scope.cart.cartId);
		};
	});