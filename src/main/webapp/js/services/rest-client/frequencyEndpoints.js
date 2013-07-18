'use strict';

angular.module('dssMiddlewareApp')
	.factory('frequencyEndpoints', ['$http', function($http) {
		var frequencyEndpoints = {};
		
		frequencyEndpoints.retrieve = function() {
			return $http.get('rest/frequencies');
		};
		
		return frequencyEndpoints;
	}]);
