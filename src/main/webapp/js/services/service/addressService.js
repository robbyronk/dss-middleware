'use strict';

angular.module('dssMiddlewareApp')
	.factory('addressService', function() {
		var addressServiceObject = {};
		var displayAddress_ = {};
		var addressToEdit_ = {};
		var readOnly_ = false;
		
		addressServiceObject.isUsa = function(address) {
			if(address == undefined) return false;
			return address.country === 'USA';
		};
		
		addressServiceObject.isCanada = function(address) {
			if(address == undefined) return false;
			return address.country == 'Canada';
		};
		
		addressServiceObject.getDisplayAddress = function() {
			return displayAddress_;
		};
		
		addressServiceObject.setDisplayAddress = function(displayAddress) {
			displayAddress_ = displayAddress;
		};
		
		addressServiceObject.getAddressToEdit = function() {
			return addressToEdit_;
		};
		
		addressServiceObject.setAddressToEdit = function(addressToEdit) {
			addressToEdit_ = addressToEdit;
		};
		
		addressServiceObject.getReadOnly = function() {
			return readOnly_;
		};
		
		addressServiceObject.setReadOnly = function(readOnly) {
			readOnly_ = readOnly;
		};
		
		addressServiceObject.removeUnusedAddressInformation = function(address) {
			//If USA, remove address line 4
			if(address.country == 'USA') {
				address.streetAddress4 = null;
			}
			else {
				//Otherwise remove City, State, Zip
				address.city = null;
				address.state = null;
				address.zipCode = null;
			}
		};
		
		return addressServiceObject;
	});