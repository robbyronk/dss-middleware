'use strict';

angular.module('dssMiddlewareApp')
	.controller('AddressCtrl', function($scope, addressService) {
		
		$scope.initAddresses = function() {
			$scope.states = addressService.getStates();
			$scope.countries = addressService.getCountries();
			$scope.displayAddress = addressService.getDisplayAddress();
			$scope.addressToEdit = addressService.getAddressToEdit();
		};
		
		$scope.isUsa = function(address) {
			return addressService.isUsa(address);
		};
		
		$scope.isCanadianAddress = function(address) {
			return addressService.isCanada(address);
		};
	});