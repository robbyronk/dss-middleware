'use strict';

angular.module('dssMiddlewareApp')
	.factory('drawDayEndpoints', ['$http', function($http) {
		var drawDays = {};
		
		drawDays.fetchDrawDays = function(datetime) {
			return $http.get('rest/draw/days/' + datetime);
		};
		
		drawDays.fetchDrawMonths = function(datetime) {
			return $http.get('rest/draw/months/' + datetime);
		};
		
		return drawDays;
	}]);