'use strict';

angular.module('dssMiddlewareApp')
	.factory('addressService', function() {
		var addressServiceObject = {};
		
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
		
		return addressServiceObject;
	});