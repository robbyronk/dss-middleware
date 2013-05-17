'use strict';

angular.module('dssMiddlewareApp')
	.factory('cart', ['cartEndpoints', '$q', function(cartEndpoints, $q) {
		var cart = {};
		
		cart.create = function() {
			var deferred = $q.defer();
			
			cartEndpoints.create()
				.success(function(data, status, headers, config) {
					var createdCartLocation = headers('Location');
					var createdCart = {};
					
					cartEndpoints.retrieveSpecificLocation(createdCartLocation)
						.success(function(data) {
							createdCart = data;
							deferred.resolve(createdCart);
						});
				});
			
			return deferred.promise;
		};
		
		cart.retrieve = function(cartId) {
			return cartEndpoints.retrieve(cartId);
		};
		
		return cart;
	}]);