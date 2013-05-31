'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftCartCtrl', function ($scope, cart) {
		
		$scope.retrieveCart = function(cartId) {
			cart.retrieve(cartId).then(function(results) {
				$scope.cart = results;
			});
		};
		
		$scope.proceedToCheckout = function() {
			//do stuff
		};
});