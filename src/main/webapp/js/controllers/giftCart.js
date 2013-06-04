'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftCartCtrl', function ($scope, cart) {
		
		$scope.giftLines = [{webTitle: 'Ryan T. Carlson', desigType: 'Ministry', designation: '2843160', amount: '50.00'}];
		$scope.line = $scope.giftLines[0];
		
		$scope.retrieveCart = function(cartId) {
			cart.retrieve(cartId).then(function(results) {
				$scope.cart = results;
			});
		};
		
		$scope.proceedToCheckout = function() {
			//do stuff
		};
		
		$scope.edit = function() {
			//do stuff
		};
		
		$scope.remove = function() {
			//do stuff
		};
		
		$scope.addMoreGifts = function() {
			//do stuff
		};
		
		$scope.viewDesig = function(designation) {
			//do stuff
		};
});