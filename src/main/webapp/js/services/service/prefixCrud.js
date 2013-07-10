'use strict';

angular.module('dssMiddlewareApp')
	.factory('prefixCrud', ['$q', 'prefixEndpoints', function($q, prefixEndpoints) {
		var prefixCrud = {};
		
		prefixCrud.retrieve = function() {
			var deferred = $q.defer();
			
			prefixEndpoints.retrieve()
				.success(function(prefixes) {
					deferred.resolve(prefixes);
				});
			return deferred.promise;
		};
		
		return prefixCrud;
	}]);