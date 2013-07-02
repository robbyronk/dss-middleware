'use strict';

angular.module('dssMiddlewareApp')
	.factory('frequencyCrud', ['$q', 'frequencyEndpoints', function($q, frequencyEndpoints) {
		var frequencyCrud = {};
		
		frequencyCrud.retrieve = function() {
			var deferred = $q.defer();
			
			frequencyEndpoints.retrieve()
				.success(function(data) {
					deferred.resolve(data);
				});
			return deferred.promise;
		};
		
		return frequencyCrud;
	}]);