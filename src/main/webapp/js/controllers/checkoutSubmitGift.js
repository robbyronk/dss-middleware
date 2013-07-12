'use strict';

angular.module('dssMiddlewareApp')
	.controller('CheckoutSubmitGiftCtrl', function($scope, $routeParams, $location, cartResolved, checkoutSubmitService, cartCrud) {
		$scope.initSubmitGiftPage = function() {
			$scope.cart = cartResolved;
			checkoutSubmitService.setCart($scope.cart);
			$scope.showTransactionDayForSingleGifts = true;
			$scope.endOfYearTextType = {type: ''};
		};
		
		/**
		 * Determine if the user has a single frequency gift in the cart
		 */
		$scope.cartHasSingleFrequencyGift = function(cart) {
			for(var i = 0; i < cart.gifts.length; i++) {
				if(cart.gifts[i].giftFrequency == 'Single') {
					$scope.endOfYearTextType.type = 'SubmitGift';
					return true;
				}
			}
			
			//TODO: What is the EOY Text type here?
			return false;
		};
		
		$scope.backToGiftCart = function() {
			$location.path('/GiftCartPage/' + $scope.cart.cartId);
		};
		
		$scope.submitCart = function() {
			cartCrud.updateCart($scope.cart).then(function() {
				//TODO: redirect back to client thank you page
			});
		};
	});