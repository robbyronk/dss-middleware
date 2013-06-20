'use strict';

angular.module('dssMiddlewareApp')
	.controller('CheckoutMailingAddressCtrl', function ($scope, $routeParams, $location, giftCrud, cartCrud) {
		var params = $routeParams;
		
		$scope.initPage = function() {
			
			cartCrud.retrieve(params.cartId).then(function(data) {
				$scope.cart = data;
				
				//TODO: Get these from the server
				$scope.personalInfo = {isStaff: false, hasPaymentMethods: false};
				$scope.prefixes = [{namePrefix: 'Mr.', namePrefixCode: 'Mr'},
				                   {namePrefix: 'Mrs.', namePrefixCode: 'Mrs'},
				                   {namePrefix: 'Lieutenant Commander (NAVY,CG)', namePrefixCode: 'LCDR'}];
				$scope.suffixes = [{suffix: 'Jr.', nameSuffix: 'Jr.'},
				                   {suffix: 'Sr.', nameSuffix: 'Sr.'},
				                   {suffix: 'II', nameSuffix: 'II'},
				                   {suffix: 'III', nameSuffix: 'III'},
				                   {suffix: 'IV', nameSuffix: 'IV'}];
				$scope.phoneTypes = [{display: 'Home', value: 'HOME'},
				                     {display: 'Work', value: 'WORK'},
				                     {display: 'Mobile', value: 'MOBILE'}];
				$scope.states = [{stateCode: 'AE', stateName: 'Armed Forces Europe (includes Africa, Middle East and Canada)'},
				                 {stateCode: 'IN', stateName: 'Indiana'},
				                 {stateCode: 'FL', stateName: 'Florida'},
				                 {stateCode: 'TX', stateName: 'Texas'}];
				$scope.countries = [{countryCode: 'Canada', countryName: 'Canada'},
				                    {countryCode: 'Macedonia, The Former Yugoslav', countryName: 'Macedonia, The Former Yugoslav'},
				                    {countryCode: 'USA', countryName: 'USA'}, 
				                    {countryCode: 'Zimbabwe', countryName: 'Zimbabwe'}];
				$scope.loggedIn = false;
				$scope.failoverMode = false;
				
				//If blank, set country code to the default
				if($scope.cart.mailingAddress.country == '' || $scope.cart.mailingAddress.country == null) {
					$scope.cart.mailingAddress.country = 'USA';
				}
				
				if($scope.cart.personType == '' || $scope.cart.personType == null) {
					$scope.cart.personType = 'Household';
				}
				
				$scope.addressToEdit = $scope.cart.mailingAddress;
			});
			
		};
		
		//TODO: Rename mailingAddress to address (in both of these functions)
		$scope.isUsa = function(mailingAddress) {
			if(mailingAddress == undefined) return false;
			return mailingAddress.country === 'USA';
		};
		
		$scope.isCanadianAddress = function(mailingAddress) {
			if(mailingAddress == undefined) return false;
			return mailingAddress.country === 'Canada';
		};
		
		$scope.continueToPaymentPage = function() {
			$scope.cart.mailingAddress = $scope.addressToEdit;
			
			cartCrud.updateCart($scope.cart).then(function(data) {
				if($scope.loggedIn && $scope.personalInfo.hasPaymentMethods) {
					$location.path('/CheckoutSelectPaymentMethod/' + $scope.cart.cartId);
				}
				else {
					$location.path('/CheckoutPaymentMethod/' + $scope.cart.cartId);
				}
			});
		};
	});