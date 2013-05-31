'use strict';

angular.module('dssMiddlewareApp')
	.factory('cart', ['$q', 'cartEndpoints', function($q, cartEndpoints) {
		var cart = {};
		
		/*creates a new 'blank cart' in the database and looks for the URI to 
		 *the resource in the header 'Location'*/
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
			var deferred = $q.defer();
			
			cartEndpoints.retrieve(cartId)
				.success(function(data, status, headers, config){
					var retrievedCart = data;
					deferred.resolve(retrievedCart);
				});
			
			return deferred.promise;
		};
		
		return cart;
	}]);