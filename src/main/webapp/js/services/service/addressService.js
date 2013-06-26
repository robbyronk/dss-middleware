'use strict';

angular.module('dssMiddlewareApp')
	.factory('addressService', function() {
		var addressServiceObject = {};
		var displayAddress_ = {};
		var addressToEdit_ = {};
		
		addressServiceObject.isUsa = function(address) {
			if(address == undefined) return false;
			return address.country === 'USA';
		};
		
		addressServiceObject.isCanada = function(address) {
			if(address == undefined) return false;
			return address.country == 'Canada';
		};
		
		//TODO: Get states and countries from server
		addressServiceObject.getStates = function() {
			return [{stateCode: 'AE', stateName: 'Armed Forces Europe (includes Africa, Middle East and Canada)'},
	                {stateCode: 'IN', stateName: 'Indiana'},
	                {stateCode: 'FL', stateName: 'Florida'},
	                {stateCode: 'TX', stateName: 'Texas'}];
		};
		
		addressServiceObject.getCountries = function() {
			return [{countryCode: 'Canada', countryName: 'Canada'},
                    {countryCode: 'Macedonia, The Former Yugoslav', countryName: 'Macedonia, The Former Yugoslav'},
                    {countryCode: 'USA', countryName: 'USA'}, 
                    {countryCode: 'Zimbabwe', countryName: 'Zimbabwe'}];
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