'use strict';

angular.module('dssMiddlewareApp')
	.factory('cartEndpoints', ['$http', function($http) {
		var cart = {};
		
		cart.create = function() {
			return $http.post('rest/cart');
		};
		
		cart.retrieve = function(cartId) {
			return $http.get('rest/cart/' + cartId);
		};
		
		cart.retrieveSpecificLocation = function(location) {
			return $http.get(location);
		};
		
		cart.deleteCart = function(cartId) {
			return $http({method: 'DELETE', url: 'rest/cart/' + cartId});
		};
		
		return cart;
	}]);