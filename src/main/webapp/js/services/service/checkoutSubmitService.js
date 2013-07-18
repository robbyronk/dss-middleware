'use strict';

angular.module('dssMiddlewareApp')
	.factory('checkoutSubmitService', function() {
		var checkoutSubmitService = {};
		var cart_ = {};
		
		checkoutSubmitService.getCart = function() {
			return cart_;
		};
		
		checkoutSubmitService.setCart = function(cart) {
			cart_ = cart;
		};
		
		return checkoutSubmitService;
	});