'use strict';

angular.module('dssMiddlewareApp')
	.factory('gift', ['$q', 'cart', 'giftEndpoints', function($q, cart, giftEndpoints) {
		var gift = {};
		
		/*creates a new 'blank gift' in the database and looks for the URI to 
		 *the resource in the header 'Location'*/
		gift.create = function() {
			var deferred = $q.defer();
			
			giftEndpoints.create()
				.success(function(data, status, headers, config) {
					var createdGiftLocation = headers('Location');
					var createdGiftAndCart = {};
	
					giftEndpoints.retrieveSpecificLocation(createdGiftLocation)
						.success(function(data) {
							createdGiftAndCart.gift = data;
							
							/*for now we assume there is no cart and it must be created*/
							cart.create().then(function(c) {
								 createdGiftAndCart.cart = c;
								 deferred.resolve(createdGiftAndCart);
							});
							
						});
				});
			
			return deferred.promise;
		};
		
		gift.update = function(giftToUpdate) {
			return giftEndpoints.update(giftToUpdate);
		};
		
		return gift;
	}]);