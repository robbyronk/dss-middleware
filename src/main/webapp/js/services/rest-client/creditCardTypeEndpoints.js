'use strict';

angular.module('dssMiddlewareApp')
	.factory('creditCardTypeEndpoints', ['$http', function($http) {
		var creditCardTypeEndpointsObject = {};
		
		creditCardTypeEndpointsObject.retrieve = function() {
			return $http.get('rest/cards');
		};
		
		return creditCardTypeEndpointsObject;
	}]);