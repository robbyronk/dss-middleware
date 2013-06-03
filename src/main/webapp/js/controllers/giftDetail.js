'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftDetailCtrl', function ($scope, $routeParams, cartEndpoints, drawDayEndpoints, gift) {
	
		var params = $routeParams;
		var cart = {};
		$scope.showComment = {staff: 'N', dsg: 'N'};
		
		
		//TODO: Get these values from the server
		$scope.frequencies = ['Single','Monthly','Quarterly','Semi-Annual','Annual']; 
		$scope.designation = {externalDescription: 'Ryan T. Carlson', type: 'Ministry', 
							  designationNumber: params.designationNumber}; 
		$scope.isNew = true; 
		//can get custom amounts or defaults
		$scope.amounts = ['50','100','250','500','1000','5000', 'Other:'];

		
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
				$scope.gift.dayOfMonth = $scope.transactionDays[0].value;
				cart = cartAndGift.cart;
			});
		};
	
		$scope.initPage = function(){
			$scope.createGift();
			
			drawDayEndpoints.fetchDrawDays(new Date().toISOString()).then(function(results){
				$scope.transactionDays = results.data;
				$scope.transactionDay = $scope.transactionDays[0].key;
			});
			
			drawDayEndpoints.fetchDrawMonths(new Date().toISOString()).then(function(results){
				$scope.transactionMonths = results.data;
				$scope.transactionMonth = $scope.transactionMonths[0];
			});
		};
		
		
		$scope.refreshDrawDays = function(){
			drawDayEndpoints.fetchDrawDays($scope.createDate(
														$scope.transactionMonth.year,
														$scope.transactionMonth.month,
														1).toISOString()).then(function(results){
				$scope.transactionDays = results.data;
				$scope.transactionDay = $scope.transactionDays[0].key;
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
			
			if($scope.gift.giftFrequency != 'Single') {
				$scope.gift.startDate = $scope.createDate($scope.transactionMonth.year, $scope.transactionMonth.month, $scope.transactionDay);
			}
			gift.update($scope.gift);
		};
		
		$scope.cancel = function() {
			//TODO: Delete gift
			//TODO: Delete cart
			//TODO: Redirect to ministry/staff/fund appeal detail page
				//this requires designation number
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
		$scope.setFocusOther = function() {
			if($scope.gift.giftAmount === 'Other:') {
				$scope.otherFocus = true;
			}
		};
		
		/**
		 * Using the month, year, and day, create a date object
		 */
		$scope.createDate = function(year, month, day) {
			var startDate = new Date();
			var zeroIndexMonth = month - 1;
			startDate.setFullYear(year,zeroIndexMonth,day);
			return startDate;
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