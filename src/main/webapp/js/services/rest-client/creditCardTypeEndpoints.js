'use strict';

angular.module('dssMiddlewareApp')
	.factory('creditCardTypeEndpoints', ['$http', function($http) {
		var creditCardTypeEndpoints = {};
		
		creditCardTypeEndpoints.retrieve = function() {
			return $http.get('rest/cards');
		};
		
		return creditCardTypeEndpoints;
	}]);