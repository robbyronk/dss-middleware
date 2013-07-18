'use strict';

angular.module('dssMiddlewareApp')
	.factory('stateEndpoints', ['$http', function($http) {
		var stateEndpoints = {};
		
		stateEndpoints.retrieve = function() {
			return $http.get('rest/states');
		};
		
		return stateEndpoints;
	}]);
