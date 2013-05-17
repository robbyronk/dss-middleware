'use strict';

angular.module('dssMiddlewareApp')
	.factory('gift', ['cart', 'giftEndpoints', '$q', function(cart, giftEndpoints, $q) {
		var gift = {};
		
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