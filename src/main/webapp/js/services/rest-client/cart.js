'use strict';

angular.module('dssMiddlewareApp')
	.factory('cartEndpoints', ['$http', function($http) {
		var cart = {};
		
		cart.create = function() {
			return $http.post('http://localhost:8080/dss-middleware/rest/cart');
		};
		
		cart.retrieve = function(cartId) {
			return $http.get('http://localhost:8080/dss-middleware/rest/cart/' + cartId);
		};
		
		return cart;
	}]);