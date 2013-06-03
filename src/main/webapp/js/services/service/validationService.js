'use strict';

angular.module('dssMiddlewareApp')
	.factory('validationService', function() {
		var validation = {};
		var error = {message: ''};
		
		validation.setErrorMessage = function(errorMessage) {
			error.message = errorMessage;
		};
		
		validation.getErrorMessage = function() {
			return error.message;
		};
		
		return validation;
	});