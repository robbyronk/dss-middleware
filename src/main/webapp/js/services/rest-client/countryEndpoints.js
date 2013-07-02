'use strict';

angular.module('dssMiddlewareApp')
	.factory('countryEndpoints', ['$http', function($http) {
		var countryEndpoints = {};
		
		countryEndpoints.retrieve = function() {
			return $http.get('rest/countries');
		};
		
		return countryEndpoints;
	}]);
