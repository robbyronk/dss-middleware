'use strict';

angular.module('dssMiddlewareApp')
	.factory('countryCrud', ['$q', 'countryEndpoints', function($q, countryEndpoints) {
		var countryCrud = {};
		
		countryCrud.retrieve = function() {
			var deferred = $q.defer();
			
			countryEndpoints.retrieve()
				.success(function(data) {
					deferred.resolve(data);
				});
			return deferred.promise;
		};
		
		return countryCrud;
	}]);