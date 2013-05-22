/**
 * Modified from http://plnkr.co/edit/gmaQCl?p=preview.
 * Taken from http://stackoverflow.com/a/14837021.
 */

angular.module('dssMiddlewareApp')
	.directive('focusMe', function($timeout) {
		return {
			scope: { trigger: '=focusMe' },
			link: function(scope, element) {
				scope.$watch('trigger', function(value) {
					if(value === true) { 
						$timeout(function() {
							element[0].focus();
							scope.trigger = false;
						});
					}
				});
			}
		};
	});