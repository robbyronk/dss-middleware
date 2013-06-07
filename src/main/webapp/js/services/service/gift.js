'use strict';

angular.module('dssMiddlewareApp')
	.factory('gift', ['$q', 'cartCrud', 'giftEndpoints', function($q, cartCrud, giftEndpoints) {
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
							cartCrud.create().then(function(c) {
								 createdGiftAndCart.cart = c;
								 deferred.resolve(createdGiftAndCart);
							});
							
						});
				});
			
			return deferred.promise;
		};
		
		gift.update = function(giftToUpdate) {
			var deferred = $q.defer();
			
			giftEndpoints.update(giftToUpdate)
				.success(function(data) {
					var updatedCart = data;
					deferred.resolve(updatedCart);
				});
			
			return deferred.promise;
		};
		
		gift.retrieve = function(giftId) {
			var deferred = $q.defer();
			
			giftEndpoints.retrieve(giftId)
				.success(function(data) {
					var retrievedCart = data;
					deferred.resolve(retrievedCart);
				});
			
			return deferred.promise;
		};
		
		gift.deleteGift = function(giftId) {
			var deferred = $q.defer();
			
			giftEndpoints.deleteGift(giftId)
				.success(function(data) {
					deferred.resolve(data);
				});
			
			return deferred.promise;
		};
		
		return gift;
	}]);