'use strict';

describe('Address service tests', function() {
	describe('Removing unused address information', function() {
		beforeEach(module('dssMiddlewareApp'));
		
		it('should remove city, state, and zip', inject(function(addressService) {
			var address = {streetAddress1: '123',
						   streetAddress2: 'Line2',
						   streetAddress3: 'Line3',
						   streetAddress4: 'Line4',
						   city: 'Quebec City',
						   state: 'QC',
						   zipCode: '12345',
						   country: 'Canada'};
			addressService.removeUnusedAddressInformation(address);
			expect(address.city).toBeNull();
			expect(address.state).toBeNull();
			expect(address.zipCode).toBeNull();
		}));
		
		it('should remove address line 4', inject(function(addressService) {
			var address = {streetAddress1: '123',
					   	   streetAddress2: 'Line2',
					   	   streetAddress3: 'Line3',
					   	   streetAddress4: 'Line4',
					   	   city: 'Orlando',
					   	   state: 'FL',
					   	   zipCode: '32832',
					   	   country: 'USA'};
			addressService.removeUnusedAddressInformation(address);
			expect(address.streetAddress4).toBeNull();
		}));
	});
});
