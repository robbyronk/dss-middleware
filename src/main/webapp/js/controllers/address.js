'use strict';

angular.module('dssMiddlewareApp')
	.controller('AddressCtrl', function($scope, addressService) {
		$scope.states = addressService.getStates();
		$scope.countries = addressService.getCountries();
		
		$scope.isUsa = function(address) {
			return addressService.isUsa(address);
		};
		
		$scope.isCanadianAddress = function(address) {
			return addressService.isCanada(address);
		};
	});