'use strict';

describe('Address controller tests', function() {
	var scope = null;
	
	describe('Is USA', function() {
		var mailingAddress;
		var isUsa;

		beforeEach(module('dssMiddlewareApp'));

		beforeEach(inject(function($rootScope, $controller) {
			scope = $rootScope.$new();
			$controller('AddressCtrl', {$scope: scope});
		}));

		it('should be true', function() {
			mailingAddress = {country: 'USA'};
			isUsa = scope.isUsa(mailingAddress);
			expect(isUsa).toBe(true);
		});

		it('should be false', function() {
			mailingAddress = {country: 'Canada'};
			isUsa = scope.isUsa(mailingAddress);
			expect(isUsa).toBe(false);
		});
	});
	
	describe('Is Canadian address', function() {
		var mailingAddress;
		var isCanadianAddress;
		
		beforeEach(module('dssMiddlewareApp'));
		
		beforeEach(inject(function($rootScope, $controller) {
			scope = $rootScope.$new();
			$controller('AddressCtrl', {$scope: scope});
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