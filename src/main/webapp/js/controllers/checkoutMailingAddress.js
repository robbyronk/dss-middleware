'use strict';

angular.module('dssMiddlewareApp')
	.controller('CheckoutMailingAddressCtrl', function ($scope, $routeParams, $location, giftCrud, cartCrud) {
		$scope.initPage = function() {
			$scope.personalInfo = {personType: 'Household', isStaff: false,
									mailingAddress: {countryCode: ''}};
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
			$scope.countries = [{countryCode: 'Macedonia, The Former Yugoslav', countryName: 'Macedonia, The Former Yugoslav'},
			                    {countryCode: 'USA', countryName: 'USA'}, 
			                    {countryCode: 'Zimbabwe', countryName: 'Zimbabwe'}];
			$scope.loggedIn = false;
			$scope.failoverMode = false;
			
			if($scope.personalInfo.mailingAddress.countryCode == '') {
				$scope.personalInfo.mailingAddress.countryCode = 'USA';
			}
		};
		
		$scope.isUsa = function(personalInfo) {
			return personalInfo.mailingAddress.countryCode === 'USA';
		};
	});