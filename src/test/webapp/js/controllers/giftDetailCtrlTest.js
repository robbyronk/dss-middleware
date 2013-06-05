'use strict';

describe('Gift detail controller tests', function() {
	var scope = null;
	var params = null;
	
	describe('Start date', function() {
		
		params = {designationNumber: '2843160'};
		var controlDate;
		var startDate;
		
		beforeEach(module('dssMiddlewareApp'));
		
		beforeEach(inject(function($rootScope, $controller, $httpBackend) {
			scope = $rootScope.$new();
			$controller('GiftDetailCtrl', {$scope: scope, $routeParams: params});
		}));
		
		it('should be May 5th, 2013', function() {
			controlDate = new Date();
			controlDate.setFullYear(2013, 4, 5);
			removeTime(controlDate);
			startDate = scope.createDate(2013, 5, 5);
			removeTime(startDate);
			expect(startDate).toEqual(controlDate);
		});
		
		it('should be January 20th, 2014', function() {
			controlDate = new Date();
			controlDate.setFullYear(2014, 0, 20);
			removeTime(controlDate);
			startDate = scope.createDate(2014, 1, 20);
			removeTime(startDate);
			expect(startDate).toEqual(controlDate);
		});
		
		function removeTime(date) {
			date.setHours(0);
			date.setMinutes(0);
			date.setSeconds(0);
			date.setMilliseconds(0);
		}
	});
	
	describe('isOther', function() {
		var other = null;
		var amounts = [];
		
		beforeEach(module('dssMiddlewareApp'));
		
		beforeEach(inject(function($rootScope, $controller, $httpBackend) {
			scope = $rootScope.$new();
			$controller('GiftDetailCtrl', {$scope: scope, $routeParams: params});
		}));
		
		it('should be false', function() {
			amounts = ['50','100','200','500','1000','2000','5000'];
			other = scope.isOther(50, amounts);
			expect(other).toBe(false);
		});
		
		it('should be true', function() {
			amounts = ['500','1000','2000','5000','10000','20000','50000'];
			other = scope.isOther(14.11, amounts);
			expect(other).toBe(true);
		});
	});
});