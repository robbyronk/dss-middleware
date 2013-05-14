'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftCartController', function ($scope, $http) {
		
		$scope.retrieveCart = function(cartId) {
			$http.get('http://localhost:8080/dss-middleware/rest/cart/' + cartId)
				.success(function(data, status, headers, config){
					$scope.cart = data;
				});
		};
		
		$scope.proceedToCheckout = function() {
			//do stuff
		};
});