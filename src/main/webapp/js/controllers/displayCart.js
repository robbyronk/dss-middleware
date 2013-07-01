'use strict';

angular.module('dssMiddlewareApp')
	.controller('DisplayCartCtrl', function($scope, designationService, checkoutSubmitService) {
		$scope.initDisplayCart = function(isBrandedCheckout) {
			$scope.cart = checkoutSubmitService.getCart();
			$scope.isBrandedCheckout = isBrandedCheckout;
			$scope.descrHeader = 'I would like my gift to benefit the ministry of:';
			$scope.generateListOfFrequencies();
		};
		
		$scope.getDescription = function(designationNumber) {
			return $scope.getWebTitle(designationNumber);
		};
		
		$scope.getTypeDescription = function(designationNumber) {
			return $scope.getDesigType(designationNumber);
		};
		
		$scope.getWebTitle = function(designationNumber) {
			return designationService.getWebTitle(designationNumber);
		};
		
		$scope.getDesigType = function(designationNumber) {
			return designationService.getDesigType(designationNumber);
		};
		
		/**
		 * Create a list of the frequencies that are being utilized
		 */
		$scope.generateListOfFrequencies = function() {
			$scope.usedFrequencies = [];
			
			if($scope.getListForFrequency('Monthly', $scope.cart.gifts).length > 0) {
				$scope.usedFrequencies.push('Monthly');
			}
			if($scope.getListForFrequency('Quarterly', $scope.cart.gifts).length > 0) {
				$scope.usedFrequencies.push('Quarterly');
			}
			if($scope.getListForFrequency('Semi-Annual', $scope.cart.gifts).length > 0) {
				$scope.usedFrequencies.push('Semi-Annual');
			}
			if($scope.getListForFrequency('Annual', $scope.cart.gifts).length > 0) {
				$scope.usedFrequencies.push('Annual');
			}
			if($scope.getListForFrequency('Single', $scope.cart.gifts).length > 0) {
				$scope.usedFrequencies.push('Single');
			}
		};
		
		$scope.getTotalForFrequency = function(frequency, gifts) {
			var frequencyTotal = 0;
			var frequencyGifts = $scope.getListForFrequency(frequency, gifts);
			
			for(var i = 0; i < frequencyGifts.length; i++) {
				frequencyTotal += frequencyGifts[i].giftAmount;
			}
			
			return frequencyTotal;
		};
		
		$scope.getListForFrequency = function(frequency, gifts) {
			var frequencyGifts = [];
			for(var i = 0; i < gifts.length; i++) {
				if(gifts[i].giftFrequency == frequency) {
					frequencyGifts.push(gifts[i]);
				}
			}
			return frequencyGifts;
		};
	});