'use strict';

angular.module('dssMiddlewareApp')
	.controller('AddressCtrl', function($scope, addressService, stateCrud, countryCrud) {
		
		$scope.initAddresses = function() {
			stateCrud.retrieve().then(function(data) {
				$scope.states = data.list;
			});
			
			countryCrud.retrieve().then(function(data) {
				$scope.countries = data.list;
			});
			
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