'use strict';

angular.module('dssMiddlewareApp')
	.factory('suffixCrud', ['$q', 'suffixEndpoints', function($q, suffixEndpoints) {
		var suffixCrud = {};
		
		suffixCrud.retrieve = function() {
			var deferred = $q.defer();
			
			suffixEndpoints.retrieve()
				.success(function(suffixes) {
					deferred.resolve(suffixes);
				});
			return deferred.promise;
		};
		
		return suffixCrud;
	}]);