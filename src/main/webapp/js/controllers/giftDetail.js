'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftDetailCtrl', function ($scope, $routeParams, cartEndpoints, gift) {
	
		$scope.params = $routeParams;
		$scope.designationNumber = $scope.params.designationNumber;
		$scope.frequencies = ['Single','Monthly','Quarterly','Semi-Annual','Annual'];
		$scope.showDonComment = 'N';
		$scope.showStaffComment = 'N';
		$scope.designation = {externalDescription: 'Ryan T. Carlson', type: 'Ministry'};
		
		/**
		 * Create a gift and set the proper gift values and defaults.
		 */
		$scope.createGift = function() {
			var cartAndGift = {};
			gift.create().then(function(results) {
				cartAndGift = results;
				$scope.gift = cartAndGift.gift;
				$scope.gift.designationNumber = $scope.designationNumber;
				$scope.gift.giftAmount = '50.00';
				$scope.gift.giftFrequency = 'Single';
				$scope.cart = cartAndGift.cart;
			});
		};
	
		/**
		 * Update the previously saved gift with the values input by the client.
		 */
		$scope.saveGift = function() {
			$scope.gift.cartId = $scope.cart.cartId;
			gift.update($scope.gift);
		};
		
		$scope.cancel = function() {
			//do something here
		};
		
		//TODO: should this be a service?
		/**
		 * Check the length of the DOM element passed in to see 
		 * if it is over its max length or not.
		 */
		$scope.isMaxLength = function(obj) {
			var mlength = obj.getAttribute?parseInt(obj.getAttribute("maxlength")) : "";
			if (obj.getAttribute && obj.value.length > mlength) {
				obj.value = obj.value.substring(0,mlength);
			}
		};
});