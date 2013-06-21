'use strict';

describe('Checkout mailing address controller tests', function() {
	var scope = null;
	
	describe('Is Canadian address', function() {
		var mailingAddress;
		var isCanadianAddress;
		
		beforeEach(module('dssMiddlewareApp'));
		
		beforeEach(inject(function($rootScope, $controller) {
			scope = $rootScope.$new();
			$controller('CheckoutMailingAddressCtrl', {$scope: scope});
		}));
		
		it('should be true', function() {
			mailingAddress = {country: 'Canada'};
			isCanadianAddress = scope.isCanadianAddress(mailingAddress);
			expect(isCanadianAddress).toBe(true);
		});
		
		it('should be false', function() {
			mailingAddress = {country: 'USA'};
			isCanadianAddress = scope.isCanadianAddress(mailingAddress);
			expect(isCanadianAddress).toBe(false);
		});
	});
});