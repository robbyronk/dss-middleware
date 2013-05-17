'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftCartCtrl', function ($scope, cartEndpoints) {
		
		$scope.retrieveCart = function(cartId) {
			cartEndpoints.retrieve(cartId)
				.success(function(data, status, headers, config){
					$scope.cart = data;
				});
		};
		
		$scope.proceedToCheckout = function() {
			//do stuff
		};
});