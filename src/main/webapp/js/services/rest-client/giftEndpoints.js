'use strict';

angular.module('dssMiddlewareApp')
	.factory('giftEndpoints', ['$http', function($http) {
		var gift = {};
		
		gift.create = function() {
			return $http.post('http://localhost:8080/dss-middleware/rest/gift');
		};
		
		gift.update = function(giftToUpdate) {
			return $http.put('http://localhost:8080/dss-middleware/rest/gift', giftToUpdate);
		};
		
		gift.retrieveSpecificLocation = function(location) {
			return $http.get(location);
		};
		
		return gift;
	}]);