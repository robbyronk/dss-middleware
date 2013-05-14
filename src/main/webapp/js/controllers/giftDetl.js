'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftDetlController', function ($scope, $http, $routeParams) {
	
		$scope.params = $routeParams;
		$scope.designationNumber = $scope.params.designationNumber;
		$scope.frequencies = ['Single','Monthly','Quarterly','Semi-Annual','Annual'];
		$scope.showDonComment = 'N';
		$scope.showStaffComment = 'N';
		
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
		
		//TODO: should be a service
		$scope.isMaxLength = function(obj) {
			var mlength = obj.getAttribute?parseInt(obj.getAttribute("maxlength")) : "";
			if (obj.getAttribute && obj.value.length > mlength) {
				obj.value = obj.value.substring(0,mlength);
			}
		};
		
		$scope.toggleShowComment = function(type, $event) {
			$event.preventDefault();
			
			if(type == 'don') {
				$scope.showDonComment = $scope.showDonComment == 'Y'?'N': 'Y';
			}
			else if(type == 'staff') {
				$scope.showStaffComment = $scope.showStaffComment == 'Y'?'N': 'Y';
			}
		};
});