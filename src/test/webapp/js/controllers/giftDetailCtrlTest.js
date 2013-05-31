'use strict';

describe('Gift detail controller tests', function() {
	describe('Start date', function() {
		var scope;
		var params = {designationNumber: '2843160'};
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
			startDate = scope.createStartDate(5, 2013, 5);
			removeTime(startDate);
			expect(startDate).toEqual(controlDate);
		});
		
		it('should be January 20th, 2014', function() {
			controlDate = new Date();
			controlDate.setFullYear(2014, 0, 20);
			removeTime(controlDate);
			startDate = scope.createStartDate(1, 2014, 20);
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
});