'use strict';

describe('Credit card editor service tests', function() {
	describe('Compare addresses', function() {
		beforeEach(module('dssMiddlewareApp'));
		
		var mailingAddress;
		var billingAddress;
		var matching = false;
		
		it('should match', inject(function(creditCardEditorService) {
			mailingAddress = {};
			billingAddress = {};
			matching = creditCardEditorService.areAddressesEffectivelyTheSame(mailingAddress, billingAddress);
			expect(matching).toBe(true);
			
			mailingAddress = null;
			billingAddress = null;
			matching = creditCardEditorService.areAddressesEffectivelyTheSame(mailingAddress, billingAddress);
			expect(matching).toBe(true);
			
			mailingAddress = undefined;
			billingAddress = undefined;
			matching = creditCardEditorService.areAddressesEffectivelyTheSame(mailingAddress, billingAddress);
			expect(matching).toBe(true);
			
			mailingAddress = {streetAddress1: '123',
					   		  streetAddress2: 'Line2',
					   		  streetAddress3: 'Line3',
					   		  streetAddress4: 'Line4',
					   		  city: null,
					   		  state: null,
					   		  zipCode: null,
					   		  country: 'Canada'};
			billingAddress = {streetAddress1: '123',
			   		  		  streetAddress2: 'Line2',
			   		  		  streetAddress3: 'Line3',
			   		  		  streetAddress4: 'Line4',
			   		  		  city: null,
			   		  		  state: null,
			   		  		  zipCode: null,
			   		  		  country: 'Canada'};
			matching = creditCardEditorService.areAddressesEffectivelyTheSame(mailingAddress, billingAddress);
			expect(matching).toBe(true);
			
			mailingAddress.streetAddress3 = null;
			mailingAddress.streetAddress4 = null;
			
			matching = creditCardEditorService.areAddressesEffectivelyTheSame(mailingAddress, billingAddress);
			expect(matching).toBe(true);
		}));
		
		it('should not match', inject(function(creditCardEditorService) {
			mailingAddress = null;
			billingAddress = {};
			matching = creditCardEditorService.areAddressesEffectivelyTheSame(mailingAddress, billingAddress);
			expect(matching).toBe(false);
			
			mailingAddress = {};
			billingAddress = null;
			matching = creditCardEditorService.areAddressesEffectivelyTheSame(mailingAddress, billingAddress);
			expect(matching).toBe(false);
			
			mailingAddress = {streetAddress1: '123',
			   		  		  streetAddress2: 'Line2',
			   		  		  streetAddress3: null,
			   		  		  streetAddress4: null,
			   		  		  city: null,
			   		  		  state: null,
			   		  		  zipCode: null,
			   		  		  country: 'Canada'};
			billingAddress = {streetAddress1: '124',
			  		  		  streetAddress2: 'Line2',
			  		  		  streetAddress3: null,
			  		  		  streetAddress4: null,
			  		  		  city: null,
			  		  		  state: null,
			  		  		  zipCode: null,
			  		  		  country: 'Canada'};
			matching = creditCardEditorService.areAddressesEffectivelyTheSame(mailingAddress, billingAddress);
			expect(matching).toBe(false);
			
			billingAddress.streetAddress1 = '123';
			billingAddress.streetAddress2 = 'Line2b';
			matching = creditCardEditorService.areAddressesEffectivelyTheSame(mailingAddress, billingAddress);
			expect(matching).toBe(false);
			
			mailingAddress = {streetAddress1: '123',
			   		  		  streetAddress2: 'Line2',
			   		  		  streetAddress3: null,
			   		  		  streetAddress4: null,
			   		  		  city: 'Orlando',
			   		  		  state: 'FL',
			   		  		  zipCode: '32832',
			   		  		  country: 'USA'};
			billingAddress = {streetAddress1: '123',
			  		  		  streetAddress2: 'Line2',
			  		  		  streetAddress3: null,
			  		  		  streetAddress4: null,
			  		  		  city: 'Orlando',
			  		  		  state: 'FL',
			  		  		  zipCode: '32828',
			  		  		  country: 'USA'};
			matching = creditCardEditorService.areAddressesEffectivelyTheSame(mailingAddress, billingAddress);
			expect(matching).toBe(false);
		}));
	});
});