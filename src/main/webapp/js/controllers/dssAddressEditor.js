'use strict';

angular.module('dssMiddlewareApp')
	.controller('DssAddressEditorCtrl', function($scope, addressService) {
		$scope.states = addressService.getStates();
		$scope.countries = addressService.getCountries();
		
		$scope.isUsa = function(address) {
			return addressService.isUsa(address);
		};
	});