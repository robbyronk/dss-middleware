'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftDetlController', function ($scope, $http, $routeParams) {
	
		$scope.params = $routeParams;
		$scope.designationNumber = $scope.params.designationNumber;
		
		/*creates a new 'blank cart' in the database and looks for the URI to 
		 *the resource in the header 'Location'*/
		$scope.createCart = function() {
			$http.post('http://localhost:8080/dss-middleware/rest/cart')
				.success(function(data, status, headers, config) {
					var createdCartLocation = headers('Location');
				
					$http.get(createdCartLocation)
						.success(function(data) {
							$scope.cart = data;
						});
				});
		};
	
		/*creates a new 'blank gift' in the database and looks for the URI to 
		 *the resource in the header 'Location'*/
		$scope.createGift = function() {
			$http.post('http://localhost:8080/dss-middleware/rest/gift')
				.success(function(data, status, headers, config) {
					var createdGiftLocation = headers('Location');
	
					$http.get(createdGiftLocation)
						.success(function(data) {
							$scope.gift = data;
							$scope.gift.designationNumber = $scope.designationNumber;
							$scope.gift.giftAmount = '50.00';
							$scope.gift.giftFrequency = 'Single';
							
							/*for now we assume there is no cart and it must be created*/
							$scope.createCart();
						});
				});
		};
	
		/*update the previously saved gift with the values input by the client*/
		$scope.saveGift = function() {
			$scope.gift.cartId = $scope.cart.cartId;
			
			$http.put('http://localhost:8080/dss-middleware/rest/gift', $scope.gift);
		};
});