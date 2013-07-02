'use strict';

describe('Gift detail controller tests', function() {
	var scope = null;
	var params = null;
	
	describe('isOther', function() {
		var other = null;
		var amounts = [];
		
		beforeEach(module('dssMiddlewareApp'));
		
		beforeEach(inject(function($rootScope, $controller) {
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
	
	describe('Transaction day', function() {
		var transactionDay = '';
		var transactionDays = [{value:'5th', key:'5'},
		                       {value:'10th', key:'10'},
		                       {value:'15th', key:'15'},
		                       {value:'20th', key:'20'},
		                       {value:'25th', key:'25'}];
		
		beforeEach(module('dssMiddlewareApp'));
		
		beforeEach(inject(function($rootScope, $controller) {
			scope = $rootScope.$new();
			$controller('GiftDetailCtrl', {$scope: scope, $routeParams: params});
		}));
		
		it('should use the gift draw day', function() {
			var dayOfMonth = '15';
			transactionDay = scope.setTransactionDay(dayOfMonth, transactionDays);
			expect(transactionDay).toEqual('15');
		});
		
		it('should use the first element of transactionDays', function() {
			var dayOfMonth = null;
			transactionDay = scope.setTransactionDay(dayOfMonth, transactionDays);
			expect(transactionDay).toEqual('5');
		});
	});
	
	describe('Month tests', function() {
		var transactionMonths = [{month:'5', year:'2013', display: 'May, 2013'},
		                         {month:'6', year:'2013', display: 'June, 2013'},
		                         {month:'7', year:'2013', display: 'July, 2013'},
		                         {month:'8', year:'2013', display: 'August, 2013'},
		                         {month:'9', year:'2013', display: 'September, 2013'},
		                         {month:'10', year:'2013', display: 'October, 2013'},
		                         {month:'11', year:'2013', display: 'November, 2013'},
		                         {month:'12', year:'2013', display: 'December, 2013'},
		                         {month:'1', year:'2014', display: 'January, 2014'},
		                         {month:'2', year:'2014', display: 'February, 2014'},
		                         {month:'3', year:'2014', display: 'March, 2014'},
		                         {month:'4', year:'2014', display: 'April, 2014'}];
		
		describe('Transaction month index', function() {
			var monthObject = null;
			
			it('should be 11', function() {
				monthObject = {month: 'April', year: '2014', display: 'April, 2014'};
				var index = scope.getTransactionMonthIndex(monthObject, transactionMonths);
				expect(index).toEqual(11);
			});
			
			it('should be 6', function() {
				monthObject = {month: 'November', year: '2013', display: 'November, 2013'};
				var index = scope.getTransactionMonthIndex(monthObject, transactionMonths);
				expect(index).toEqual(6);
			});
		});
		
		describe('Transaction month', function() {
			var transactionMonth = null;
			
			
			beforeEach(module('dssMiddlewareApp'));
			
			beforeEach(inject(function($rootScope, $controller) {
				scope = $rootScope.$new();
				$controller('GiftDetailCtrl', {$scope: scope, $routeParams: params});
			}));
			
			it('should be set based on gift start date', function() {
				var startDate = 1392047691000;
				transactionMonth = scope.setTransactionMonth(startDate, transactionMonths);
				expect(transactionMonth).toEqual(transactionMonths[9]);
			});
			
			it('should use the first element of transactionMonths', function() {
				var startDate = null;
				transactionMonth = scope.setTransactionMonth(startDate, transactionMonths);
				expect(transactionMonth).toEqual(transactionMonths[0]);
			});
		});
	});
});