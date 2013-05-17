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
			
			showDonComment = scope.toggleShowComment('don', showDonComment);
			expect(showDonComment).toEqual('Y');
			
			showStaffComment = scope.toggleShowComment('staff', showStaffComment);
			expect(showStaffComment).toEqual('Y');
		});
		
		it('Should toggle from Y to N', function() {
			var showDonComment = 'Y';
			var showStaffComment = 'Y';
			
			showDonComment = scope.toggleShowComment('don', showDonComment);
			expect(showDonComment).toEqual('N');
			
			showStaffComment = scope.toggleShowComment('staff', showStaffComment);
			expect(showStaffComment).toEqual('N');
		});
	});
});