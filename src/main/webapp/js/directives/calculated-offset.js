'use strict';

angular.module('dssMiddlewareApp')
	.directive('calculatedOffset', function() {
		function calculateOffset(element) {
			var parent = element.parent();
			var nav = parent.parent().parent();
			
			var navWidth = nav.width();
			var subnavWidth = element.css({marginLeft:0}).width();
			var availOffset = navWidth - subnavWidth - 30;
			var parentPosition = parent.position();
			var offsetLeft = (parentPosition.left + parent.width() / 2) - (subnavWidth / 2);
			
			if (parentPosition.left > availOffset) {
				offsetLeft = availOffset;
			} else if (offsetLeft < 0) {
				offsetLeft = 0;
			}

			return offsetLeft;
		}
		
		return function(scope, element) {
			element.css('marginLeft', calculateOffset(element));
		};
	});