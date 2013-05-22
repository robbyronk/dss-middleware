'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftDetailCtrl', function ($scope, $routeParams, cartEndpoints, gift) {
	
		var params = $routeParams;
		var cart = {};
		$scope.frequencies = ['Single','Monthly','Quarterly','Semi-Annual','Annual']; //TODO: Get this from server
		$scope.showComment = {staff: 'N', dsg: 'N'};
		$scope.designation = {externalDescription: 'Ryan T. Carlson', type: 'Ministry', designationNumber: params.designationNumber}; //TODO: Get this from server
		$scope.isNew = true; //TODO: Get this from server
		$scope.amounts = ['50','100','250','500','1000','5000', 'Other:']; //TODO: Get this from server (can get custom amounts or defaults)
		
		/**
		 * Create a gift and set the proper gift values and defaults.
		 */
		$scope.createGift = function() {
			var cartAndGift = {};
			gift.create().then(function(results) {
				cartAndGift = results;
				$scope.gift = cartAndGift.gift;
				$scope.gift.designationNumber = $scope.designation.designationNumber;
				$scope.gift.giftAmount = $scope.amounts[0];
				$scope.gift.giftFrequency = $scope.frequencies[0];
				cart = cartAndGift.cart;
			});
		};
	
		/**
		 * Update the previously saved gift with the values input by the client.
		 */
		$scope.saveGift = function() {
			$scope.gift.cartId = cart.cartId;
			
			//make sure we have a positive value in the Other box and Other is selected
			if($scope.otherValue != null && $scope.otherValue > 0 
					&& $scope.gift.giftAmount === 'Other:') {
				$scope.gift.giftAmount = $scope.otherValue;
			}
			gift.update($scope.gift);
		};
		
		$scope.cancel = function() {
			//do something here
		};
		
		/**
		 * Set the gift amount selection to "Other"
		 */
		$scope.setGiftToOther = function() {
			$scope.gift.giftAmount = 'Other:';
		};
		
		/**
		 * Set the focus to the "Other" textbox
		 */
		$scope.setFocusOther = function(last) {
			/*
			 * A little bit fragile.  If we move "Other" to another position other 
			 * than last in the repeat, this will break.
			 */
			if(last === true) {
				$scope.otherFocus = true;
			}
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