'use strict';

describe('Gift detail controller tests', function() {
	describe('Truth', function() {
		var scope;
		var http;
		var params = {designationNumber: '2843160'};
		
		beforeEach(module('dssMiddlewareApp'));
		
		beforeEach(inject(function($rootScope, $controller, $httpBackend) {
			scope = $rootScope.$new();
			http = $httpBackend;
			$controller('GiftDetailCtrl', {$scope: scope, $http: http, $routeParams: params});
		}));
		
		it('Should be true', function() {
			expect(true).toEqual(true);
		});
	});
});