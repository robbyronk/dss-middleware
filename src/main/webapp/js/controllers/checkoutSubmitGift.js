'use strict';

angular.module('dssMiddlewareApp')
	.controller('CheckoutSubmitGiftCtrl', function($scope, $routeParams, $location, $window, cartResolved, checkoutSubmitService, cartCrud) {
		$scope.initSubmitGiftPage = function() {
			$scope.cart = cartResolved;
			checkoutSubmitService.setCart($scope.cart);
			$scope.cartHasSingleGift = $scope.cartHasSingleFrequencyGift($scope.cart);
			$scope.showTransactionDayForSingleGifts = true;
			
			//TODO: Put these 3 variables into the cart
			$scope.operatingSystem = navigator.platform;
			$scope.screenWidth = $window.screen.width;
			$scope.screenHeight = $window.screen.height;
		};
		
		/**
		 * Determine if the user has a single frequency gift in the cart
		 */
		$scope.cartHasSingleFrequencyGift = function(cart) {
			for(var i = 0; i < cart.gifts.length; i++) {
				if(cart.gifts[i].giftFrequency == 'Single') {
					$scope.endOfYearTextType = 'SubmitGift';
					return true;
				}
			}
			
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