'use strict';

angular.module('dssMiddlewareApp')
	.controller('AddressCtrl', function($scope, addressService, stateCrud) {
		
		$scope.initAddresses = function() {
			stateCrud.retrieve().then(function(data) {
				$scope.states = data;
			});
			$scope.countries = addressService.getCountries();
			$scope.displayAddress = addressService.getDisplayAddress();
			$scope.addressToEdit = addressService.getAddressToEdit();
			$scope.readOnly = addressService.getReadOnly();
		};
		
		$scope.initDisplayAddress = function(address) {
			$scope.displayAddress = address;
		};
		
		$scope.isUsa = function(address) {
			return addressService.isUsa(address);
		};
		
		$scope.isCanadianAddress = function(address) {
			return addressService.isCanada(address);
		};
	});