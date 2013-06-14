'use strict';

angular.module('dssMiddlewareApp')
	.controller('CheckoutMailingAddressCtrl', function ($scope, $routeParams, $location, giftCrud, cartCrud) {
		var params = $routeParams;
		var cart;
		
		$scope.initPage = function() {
			
			cartCrud.retrieve(params.cartId).then(function(data) {
				cart = data;
				$scope.mailingAddress = cart.mailingAddress;
				$scope.primaryName = cart.primaryName;
				$scope.spouseName = cart.spouseName;
				
				//TODO: Get these from the server
				$scope.personalInfo = {personType: 'Household', isStaff: false, hasPaymentMethods: false};
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
				if($scope.mailingAddress.country == '' || $scope.mailingAddress.country == null) {
					$scope.mailingAddress.country = 'USA';
				}
			});
			
		};
		
		$scope.isUsa = function(mailingAddress) {
			return mailingAddress.country === 'USA';
		};
		
		$scope.isCanadianAddress = function(mailingAddress) {
			return mailingAddress.country === 'Canada';
		};
		
		$scope.continueToPaymentPage = function() {
			//TODO: Do I want to do this to abstract from the direct input or do I want to use the cart attributes directly?
			cart.mailingAddress = $scope.mailingAddress;  //TODO: Add validation for things like apostraphes (or do this as directive)
			cart.primaryName = $scope.primaryName;
			cart.spouseName = $scope.spouseName;
			
			cartCrud.updateCart(cart).then(function(data) {
				//TODO: Update personal Info?
				if($scope.loggedIn && $scope.personalInfo.hasPaymentMethods) {
					$location.path('/CheckoutSelectPaymentMethod/' + cart.cartId);
				}
				else {
					$location.path('/CheckoutPaymentMethod/' + cart.cartId);
				}
			});
		};
	});