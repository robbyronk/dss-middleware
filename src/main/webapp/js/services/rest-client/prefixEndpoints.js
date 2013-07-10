'use strict';

angular.module('dssMiddlewareApp')
	.factory('prefixEndpoints', ['$http', function($http) {
		var prefixEndpoints = {};
		
		prefixEndpoints.retrieve = function() {
			return $http.get('rest/prefixes');
		};
		
		return prefixEndpoints;
	}]);