'use strict';

describe('DSS address editor controller tests', function() {
	var scope = null;
	
	describe('Is USA', function() {
		var mailingAddress;
		var isUsa;

		beforeEach(module('dssMiddlewareApp'));

		beforeEach(inject(function($rootScope, $controller) {
			scope = $rootScope.$new();
			$controller('DssAddressEditorCtrl', {$scope: scope});
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
});