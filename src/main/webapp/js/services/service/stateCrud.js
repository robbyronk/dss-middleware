'use strict';

angular.module('dssMiddlewareApp')
	.factory('stateCrud', ['$q', 'stateEndpoints', function($q, stateEndpoints) {
		var stateCrud = {};
		
		stateCrud.retrieve = function() {
			var deferred = $q.defer();
			
			stateEndpoints.retrieve()
				.success(function(data) {
					deferred.resolve(data);
				});
			return deferred.promise;
		};
		
		return stateCrud;
	}]);