'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftDetailCtrl', function ($scope, $routeParams, cartEndpoints, gift) {
	
		var params = $routeParams;
		var cart = {};
		$scope.frequencies = ['Single','Monthly','Quarterly','Semi-Annual','Annual']; //TODO: Get this from server
		$scope.showComment = {staff: 'N', dsg: 'N'};
		$scope.designation = {externalDescription: 'Ryan T. Carlson', type: 'Ministry', designationNumber: params.designationNumber}; //TODO: Get this from server
		
		/**
		 * Create a gift and set the proper gift values and defaults.
		 */
		$scope.createGift = function() {
			var cartAndGift = {};
			gift.create().then(function(results) {
				cartAndGift = results;
				$scope.gift = cartAndGift.gift;
				$scope.gift.designationNumber = $scope.designation.designationNumber;
				$scope.gift.giftAmount = '50.00';
				$scope.gift.giftFrequency = 'Single';
				cart = cartAndGift.cart;
			});
		};
	
		/**
		 * Update the previously saved gift with the values input by the client.
		 */
		$scope.saveGift = function() {
			$scope.gift.cartId = cart.cartId;
			gift.update($scope.gift);
		};
		
		$scope.cancel = function() {
			//do something here
		};
		
		
		/***********************************************
		* Textarea Maxlength script- © Dynamic Drive (www.dynamicdrive.com)
		* This notice must stay intact for legal use.
		* Visit http://www.dynamicdrive.com/ for full source code
		***********************************************/
		$scope.isMaxLength = function(obj) {
			var mlength = obj.getAttribute?parseInt(obj.getAttribute("maxlength")) : "";
			if (obj.getAttribute && obj.value.length > mlength) {
				obj.value = obj.value.substring(0,mlength);
			}
		};
});