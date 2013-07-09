'use strict';

angular.module('dssMiddlewareApp')
	.controller('CheckoutMailingAddressCtrl', function ($scope, $location, giftCrud, cartCrud, addressService, cartResolved) {
		
		$scope.initPage = function() {
			$scope.cart = cartResolved;
			
			//TODO: Get these from the server
			$scope.personalInfo = {isStaff: false, hasPaymentMethods: false};
			$scope.prefixes = {list: [{namePrefix: 'Mr.', namePrefixCode: 'Mr'},
			                          {namePrefix: 'Mrs.', namePrefixCode: 'Mrs'},
			                          {namePrefix: 'Lieutenant Commander (NAVY,CG)', namePrefixCode: 'LCDR'}]};
			$scope.suffixes = {list: [{suffix: 'Jr.', nameSuffix: 'Jr.'},
			                          {suffix: 'Sr.', nameSuffix: 'Sr.'},
			                          {suffix: 'II', nameSuffix: 'II'},
			                          {suffix: 'III', nameSuffix: 'III'},
			                          {suffix: 'IV', nameSuffix: 'IV'}]};
			$scope.phoneTypes = {types: [{display: 'Home', value: 'HOME'},
			                             {display: 'Work', value: 'WORK'},
			                             {display: 'Mobile', value: 'MOBILE'}]};
			$scope.authentication = {loggedIn: false};
			$scope.failoverMode = {isFailover: false};
			
			//If blank, set country code to the default
			if($scope.cart.mailingAddress.country == '' || $scope.cart.mailingAddress.country == null) {
				$scope.cart.mailingAddress.country = 'USA';
			}
			
			if($scope.cart.personType == '' || $scope.cart.personType == null) {
				$scope.cart.personType = 'Household';
			}
			
			addressService.setAddressToEdit($scope.cart.mailingAddress);
			addressService.setReadOnly($scope.personalInfo != null && $scope.personalInfo.isStaff);
		};
		
		$scope.continueToPaymentPage = function() {
			var addressToEdit = addressService.getAddressToEdit();
			addressService.removeUnusedAddressInformation(addressToEdit);
			$scope.cart.mailingAddress = addressToEdit;
			
			cartCrud.updateCart($scope.cart).then(function(data) {
				if($scope.authentication.loggedIn && $scope.personalInfo.hasPaymentMethods) {
					$location.path('/CheckoutSelectPaymentMethod/' + $scope.cart.cartId);
				}
				else {
					$location.path('/CheckoutPaymentMethod/' + $scope.cart.cartId);
				}
			});
		};
	});