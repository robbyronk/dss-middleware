'use strict';

angular.module('dssMiddlewareApp')
	.factory('giftEndpoints', ['$http', function($http) {
		var gift = {};
		
		gift.create = function() {
			return $http.post('rest/gift');
		};
		
		gift.update = function(giftToUpdate) {
			return $http.put('rest/gift', giftToUpdate);
		};
		
		gift.retrieveSpecificLocation = function(location) {
			return $http.get(location);
		};
		
		gift.retrieve = function(giftId) {
			return $http.get('rest/gift/' + giftId);
		};
		
		return gift;
	}]);