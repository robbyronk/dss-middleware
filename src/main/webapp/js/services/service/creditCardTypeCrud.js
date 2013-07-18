'use strict';

angular.module('dssMiddlewareApp')
	.factory('creditCardTypeCrud', ['$q', 'creditCardTypeEndpoints', function($q, creditCardTypeEndpoints) {
		var creditCardTypeCrud = {};
		
		creditCardTypeCrud.retrieve = function() {
			var deferred = $q.defer();
			
			creditCardTypeEndpoints.retrieve()
				.success(function(creditCardTypees) {
					deferred.resolve(creditCardTypees);
				});
			return deferred.promise;
		};
		
		return creditCardTypeCrud;
	}]);