'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftCartCtrl', function ($scope, cart) {
		
		$scope.initPage = function() {
			$scope.giftLines = [{webTitle: 'Ryan T. Carlson', desigType: 'Ministry', designation: '2843160', amount: 50.00, giftRecurrence: 'Single', startDate: ''}, 
			                    {webTitle: 'Marc and Evangeline Vergo', desigType: 'Staff', designation: '0550510', amount: 100.00, giftRecurrence: 'Monthly', startDate: '6/10/2013'}, 
			                    {webTitle: 'Orphan Care Outreach', desigType: 'Fund Appeal', designation: '2863048', amount: 47.50, giftRecurrence: 'Monthly', startDate: '7/15/2013'}];
			
			$scope.generateFrequencyLists();
			$scope.generateListOfFrequencies();
			$scope.calculateFrequencyTotals();
		};
		
		$scope.generateFrequencyLists = function() {
			$scope.singleGifts = [];
			$scope.monthlyGifts = [];
			$scope.quarterlyGifts = [];
			$scope.semiAnnualGifts = [];
			$scope.annualGifts = [];
			
			for(var i = 0; i < $scope.giftLines.length; i++) {
				if($scope.giftLines[i].giftRecurrence == 'Single') {
					$scope.singleGifts.push($scope.giftLines[i]);
				}
				else if($scope.giftLines[i].giftRecurrence == 'Monthly') {
					$scope.monthlyGifts.push($scope.giftLines[i]);
				}
				else if($scope.giftLines[i].giftRecurrence == 'Quarterly') {
					$scope.quarterlyGifts.push($scope.giftLines[i]);
				}
				else if($scope.giftLines[i].giftRecurrence == 'Semi-Annual') {
					$scope.semiAnnualGifts.push($scope.giftLines[i]);
				}
				else if($scope.giftLines[i].giftRecurrence == 'Annual') {
					$scope.annualGifts.push($scope.giftLines[i]);
				}
			}
		};
		
		$scope.generateListOfFrequencies = function() {
			$scope.frequencies = [];
			
			if($scope.monthlyGifts.length > 0) {
				$scope.frequencies.push('Monthly');
			}
			if($scope.quarterlyGifts.length > 0) {
				$scope.frequencies.push('Quarterly');
			}
			if($scope.semiAnnualGifts.length > 0) {
				$scope.frequencies.push('Semi-Annual');
			}
			if($scope.annualGifts.length > 0) {
				$scope.frequencies.push('Annual');
			}
			if($scope.singleGifts.length > 0) {
				$scope.frequencies.push('Single');
			}
		};
		
		$scope.calculateFrequencyTotals = function() {
			$scope.singleTotal = 0;
			$scope.monthlyTotal = 0;
			$scope.quarterlyTotal = 0;
			$scope.semiAnnualTotal = 0;
			$scope.annualTotal = 0;
			var i = 0;
			
			for(i = 0; i < $scope.singleGifts.length; i++) {
				$scope.singleTotal += $scope.singleGifts[i].amount;
			}
			for(i = 0; i < $scope.monthlyGifts.length; i++) {
				$scope.monthlyTotal += $scope.monthlyGifts[i].amount;
			}
			for(i = 0; i < $scope.quarterlyGifts.length; i++) {
				$scope.quarterlyTotal += $scope.quarterlyGifts[i].amount;
			}
			for(i = 0; i < $scope.semiAnnualGifts.length; i++) {
				$scope.semiAnnualTotal += $scope.semiAnnualGifts[i].amount;
			}
			for(i = 0; i < $scope.annualGifts.length; i++) {
				$scope.annualTotal += $scope.annualGifts[i].amount;
			}
		};
		
		$scope.getFrequencyTotal = function(frequency) {
			if(frequency == 'Single') return $scope.singleTotal;
			else if(frequency == 'Monthly') return $scope.monthlyTotal;
			else if(frequency == 'Quarterly') return $scope.quarterlyTotal;
			else if(frequency == 'Semi-Annual') return $scope.semiAnnualTotal;
			else if(frequency == 'Annual') return $scope.annualTotal;
		};
		
		$scope.retrieveCart = function(cartId) {
			cart.retrieve(cartId).then(function(results) {
				$scope.cart = results;
			});
		};
		
		$scope.proceedToCheckout = function() {
			//do stuff
		};
		
		$scope.edit = function(designation) {
			//do stuff
		};
		
		$scope.remove = function(designation) {
			//do stuff
		};
		
		$scope.addMoreGifts = function() {
			//do stuff
		};
		
		$scope.viewDesig = function(designation) {
			//do stuff
		};
});