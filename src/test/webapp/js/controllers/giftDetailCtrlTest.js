'use strict';

describe('Gift detail controller tests', function() {
	describe('Toggle comments', function() {
		var scope;
		var http;
		var params = {designationNumber: '2843160'};
		
		beforeEach(module('dssMiddlewareApp'));
		
		beforeEach(inject(function($rootScope, $controller, $httpBackend) {
			scope = $rootScope.$new();
			http = $httpBackend;
			$controller('GiftDetailCtrl', {$scope: scope, $http: http, $routeParams: params});
		}));
		
		it('Should toggle from N to Y', function() {
			var showDonComment = 'N';
			var showStaffComment = 'N';
			
			showDonComment = scope.toggleShowComment('don');
			expect(showDonComment).toEqual('Y');
			
			showStaffComment = scope.toggleShowComment('staff');
			expect(showStaffComment).toEqual('Y');
		});
	});
});