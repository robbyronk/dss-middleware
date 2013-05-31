'use strict';

angular.module('dssMiddlewareApp')
	.factory('giftDetailValidationService', [function() {
		var giftDetailValidationService = {};
		var errorArray = [];
		
		giftDetailValidationService.validateAmount = function(amount, errors) {
			if(amount < 0) {
				errors.push('Your gift amount must be at least $0.01.');
			}
			var regex = new RegExp('[A-z!"\[\]{}%^&*:@~#\';/<>\\|`]', i);
			if(amount == NaN || regex.test(amount)) {
				errors.push('Please enter a correct value for Other Amount. The value must be a number.');
			}
			if(amount > 999999999999.99) {
				errors.push('Please enter a correct value for Other Amount. The value must be a number. ' + 
						'(Please enter a value less than $999,999,999,999.99)');
			}
			
			return errors;
		};
		
		giftDetailValidationService.setErrors = function(errors) {
			if(errors != null) {
				errorArray = errors;
			}
		};
		
		giftDetailValidationService.getErrors = function() {
			return errorArray;
		};
	}]);