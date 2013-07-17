'use strict';

angular.module('dssMiddlewareApp')
	.factory('prefixEndpoints', ['$http', function($http) {
		var prefixEndpointsObject = {};
		
		prefixEndpointsObject.retrieve = function() {
			return $http.get('rest/prefixes');
		};
		
		return prefixEndpointsObject;
	}]);