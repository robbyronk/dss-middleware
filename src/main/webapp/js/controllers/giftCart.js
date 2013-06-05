'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftCartCtrl', function ($scope, $routeParams, $location, cart) {
		var params = $routeParams;
		
		$scope.initPage = function() {
			$scope.retrieveCart(params.cartId);
			
//			$scope.giftLines = [{designationNumber: '2843160', giftAmount: 50.00, giftFrequency: 'Single', startDate: ''}, 
//			                    {designationNumber: '0550510', giftAmount: 100.00, giftFrequency: 'Monthly', startDate: '6/10/2013'}, 
//			                    {designationNumber: '2863048', giftAmount: 47.50, giftFrequency: 'Monthly', startDate: '7/15/2013'}];
			
			
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
				if($scope.giftLines[i].giftFrequency == 'Single') {
					$scope.singleGifts.push($scope.giftLines[i]);
				}
				else if($scope.giftLines[i].giftFrequency == 'Monthly') {
					$scope.monthlyGifts.push($scope.giftLines[i]);
				}
				else if($scope.giftLines[i].giftFrequency == 'Quarterly') {
					$scope.quarterlyGifts.push($scope.giftLines[i]);
				}
				else if($scope.giftLines[i].giftFrequency == 'Semi-Annual') {
					$scope.semiAnnualGifts.push($scope.giftLines[i]);
				}
				else if($scope.giftLines[i].giftFrequency == 'Annual') {
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
				$scope.singleTotal += $scope.singleGifts[i].giftAmount;
			}
			for(i = 0; i < $scope.monthlyGifts.length; i++) {
				$scope.monthlyTotal += $scope.monthlyGifts[i].giftAmount;
			}
			for(i = 0; i < $scope.quarterlyGifts.length; i++) {
				$scope.quarterlyTotal += $scope.quarterlyGifts[i].giftAmount;
			}
			for(i = 0; i < $scope.semiAnnualGifts.length; i++) {
				$scope.semiAnnualTotal += $scope.semiAnnualGifts[i].giftAmount;
			}
			for(i = 0; i < $scope.annualGifts.length; i++) {
				$scope.annualTotal += $scope.annualGifts[i].giftAmount;
			}
		};
		
		$scope.getFrequencyTotal = function(frequency) {
			if(frequency == 'Single') return $scope.singleTotal;
			else if(frequency == 'Monthly') return $scope.monthlyTotal;
			else if(frequency == 'Quarterly') return $scope.quarterlyTotal;
			else if(frequency == 'Semi-Annual') return $scope.semiAnnualTotal;
			else if(frequency == 'Annual') return $scope.annualTotal;
		};
		
		$scope.getWebTitle = function(designationNumber) {
			//TODO: REST call
			if(designationNumber == null || designationNumber == '2843160') return 'Ryan T. Carlson';
			else if(designationNumber == '0550510') return 'Marc and Evangeline Vergo';
			else if(designationNumber == '2863048') return 'Orphan Care Outreach';
		};
		
		$scope.getDesigType = function(designationNumber) {
			//TODO: REST call
			if(designationNumber == null || designationNumber == '2843160') return 'Ministry';
			else if(designationNumber == '0550510') return 'Staff';
			else if(designationNumber == '2863048') return 'Fund Appeal';
		};
		
		$scope.retrieveCart = function(cartId) {
			cart.retrieve(cartId).then(function(results) {
				$scope.cart = results;
				$scope.giftLines = $scope.cart.gifts;
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