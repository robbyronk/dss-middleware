'use strict';

angular.module('dssMiddlewareApp')
	.controller('EndOfYearEftTextCtrl', function($scope) {
		$scope.initEndOfYearEftText = function() {
			$scope.receiptYear = $scope.determineReceiptYear(new Date());
			$scope.showEftText = $scope.determineShowEftText(new Date()); 
		};
		
		$scope.determineReceiptYear = function(today) {
			var year = today.getFullYear();
			
			//Only check if we are in the proper date range
			if((today.getMonth() == 0 && today.getDate() == 1 && today.getHours() < 3) || 
					(today.getMonth() == 11 && today.getDate() > 10)) {
				var latestDraw = $scope.getLatestDrawRunDate(today);
				var latestDay = latestDraw.getDate();
				var newDay = $scope.getNextValidDrawDay(today);
				
				if(newDay <= latestDay || newDay == 31) { 
					year = latestDraw.getFullYear(); 
				}
			}
			
			return year;
		};
		
		$scope.determineShowEftText = function(today) {
			if((today.getMonth() == 0 && today.getDate() == 1 && today.getHours() < 3) || 
					(today.getMonth() == 11 && today.getDate() > 10)) {
				var latestDraw = $scope.getLatestDrawRunDate(today);
				var latestDay = latestDraw.getDate();
				var newDay = $scope.getNextValidDrawDay(today);
				
				if(newDay <= latestDay || newDay == 31) { 
					return true; 
				}
			}
			
			return false;
		};
		
		$scope.getLatestDrawRunDate = function(today) {
			//TODO: implement
		};
		
		$scope.getNextValidDrawDay = function(today) {
			//TODO: implement
		};
	});