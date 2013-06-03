'use strict';

angular.module('dssMiddlewareApp')
	.directive('otherAmountValidate', function() {
		return {
			require: 'ngModel',
			link: function(scope, element, attrs, ngModel) {
				ngModel.$parsers.unshift(function(viewValue) {
					var regex = new RegExp('[A-z!"\\[\\]{}%\^&\*:@~#\';/<>\\\\|`]', 'i');
					
					var amountHasNonNumeric = regex.test(viewValue) || viewValue === NaN;
					var amountIsNegative = viewValue < 0;
					var amountIsTooLarge = viewValue > 999999999999.99;
					var errorMessage = '';
					
					if(amountIsNegative) {
						ngModel.$setValidity('otherAmount', false);
						element.addClass("error-input");
						errorMessage = 'Your gift amount must be at least $0.01.';
						scope.$parent.setErrorMessage(errorMessage);
						scope.$parent.$broadcast('updateError', errorMessage);
						return undefined;
					}
					else if(amountHasNonNumeric) {
						ngModel.$setValidity('otherAmount', false);
						element.addClass("error-input");
						errorMessage = 'Value must be a number.';
						scope.$parent.setErrorMessage(errorMessage);
						scope.$parent.$broadcast('updateError', errorMessage);
						return undefined;
					}
					else if(amountIsTooLarge) {
						ngModel.$setValidity('otherAmount', false);
						element.addClass("error-input");
						errorMessage = 'Please enter a value less than $999,999,999,999.99';
						scope.$parent.setErrorMessage(errorMessage);
						scope.$parent.$broadcast('updateError', errorMessage);
						return undefined;
					}
					else {
						ngModel.$setValidity('otherAmount', true);
						element.removeClass("error-input");
						errorMessage = '';
						scope.$parent.setErrorMessage(errorMessage);
						scope.$parent.$broadcast('updateError', errorMessage);
						return viewValue;
					}
				});
			}
		};
	});