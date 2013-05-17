'use strict';

/**
 * This directive can possibly go away when we redo the html to not use 
 * a click event on an <a> tag.
 */
angular.module('dssMiddlewareApp')
	.directive('preventEvent', function() {
		return function(scope, element, attrs) {
			$(element).click(function(event) {
				event.preventDefault();
			});
		};
	});