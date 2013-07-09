'use strict';

angular.module('dssMiddlewareApp')
	.directive('otherAmountValidate', function() {
		return {
			require: 'ngModel',
			link: function(scope, element, attrs, ngModel) {
				//add function to execute upon DOM change
				ngModel.$parsers.unshift(function(viewValue) {
					var regex = new RegExp('[A-z!"\\[\\]{}%\^&\*:@~#\';/<>\\\\|`]', 'i');
					
					var amountHasNonNumeric = regex.test(viewValue) || viewValue === NaN;
					var amountIsLessThanOneCent = viewValue < 0.01;
					var amountIsTooLarge = viewValue > 999999999999.99;
					var errorMessage = '';
					
					//This is so that if the user deletes the value they had, it will not show an error message
					if(viewValue === '') {
						ngModel.$setValidity('otherAmount', true);
						errorMessage = '';
						scope.$parent.setErrorMessage(errorMessage);
						scope.$parent.$broadcast('updateError', errorMessage);
						return undefined;
					}
					else if(amountIsLessThanOneCent) {
						ngModel.$setValidity('otherAmount', false);
						errorMessage = 'Your gift amount must be at least $0.01.';
						scope.$parent.setErrorMessage(errorMessage);
						scope.$parent.$broadcast('updateError', errorMessage);
						return undefined;
					}
					else if(amountHasNonNumeric) {
						ngModel.$setValidity('otherAmount', false);
						errorMessage = 'Value must be a number.';
						scope.$parent.setErrorMessage(errorMessage);
						scope.$parent.$broadcast('updateError', errorMessage);
						return undefined;
					}
					else if(amountIsTooLarge) {
						ngModel.$setValidity('otherAmount', false);
						errorMessage = 'Please enter a value less than $999,999,999,999.99';
						scope.$parent.setErrorMessage(errorMessage);
						scope.$parent.$broadcast('updateError', errorMessage);
						return undefined;
					}
					else {
						ngModel.$setValidity('otherAmount', true);
						errorMessage = '';
						scope.$parent.setErrorMessage(errorMessage);
						scope.$parent.$broadcast('updateError', errorMessage);
						return viewValue;
					}
				});
			}
		};
	});