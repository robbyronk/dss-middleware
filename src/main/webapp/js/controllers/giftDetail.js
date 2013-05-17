'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftDetailCtrl', function ($scope, $routeParams, cartEndpoints, gift) {
	
		$scope.params = $routeParams;
		$scope.designationNumber = $scope.params.designationNumber;
		$scope.frequencies = ['Single','Monthly','Quarterly','Semi-Annual','Annual'];
		$scope.showDonComment = 'N';
		$scope.showStaffComment = 'N';
		$scope.designation = {externalDescription: 'Ryan T. Carlson', type: 'Ministry'};
		
		/*creates a new 'blank cart' in the database and looks for the URI to 
		 *the resource in the header 'Location'*/
		$scope.createCart = function() {
			cartEndpoints.create()
				.success(function(data, status, headers, config) {
					var createdCartLocation = headers('Location');
					
					cartEndpoints.retrieveSpecificLocation(createdCartLocation)
						.success(function(data) {
							$scope.cart = data;
						});
				});
		};
	
		/*creates a new 'blank gift' in the database and looks for the URI to 
		 *the resource in the header 'Location'*/
		$scope.createGift = function() {
			var cartAndGift = {};
			gift.create().then(function(results) {
				cartAndGift = results;
				$scope.gift = cartAndGift.gift;
				$scope.gift.designationNumber = $scope.designationNumber;
				$scope.gift.giftAmount = '50.00';
				$scope.gift.giftFrequency = 'Single';
				$scope.cart = cartAndGift.cart;
			});
		};
	
		/*update the previously saved gift with the values input by the client*/
		$scope.saveGift = function() {
			$scope.gift.cartId = $scope.cart.cartId;
			
			gift.update($scope.gift);
		};
		
		$scope.cancel = function() {
			//do something here
		};
		
		//TODO: should this be a service?
		$scope.isMaxLength = function(obj) {
			var mlength = obj.getAttribute?parseInt(obj.getAttribute("maxlength")) : "";
			if (obj.getAttribute && obj.value.length > mlength) {
				obj.value = obj.value.substring(0,mlength);
			}
		};
});