'use strict';

angular.module('dssMiddlewareApp')
	.factory('suffixEndpoints', ['$http', function($http) {
		var suffixEndpoints = {};
		
		suffixEndpoints.retrieve = function() {
			return $http.get('rest/suffixes');
		};
		
		return suffixEndpoints;
	}]);