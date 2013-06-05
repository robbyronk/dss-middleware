'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftDetailCtrl', function ($scope, $routeParams, $location, cartEndpoints, drawDayEndpoints, gift, validationService) {
		var params = $routeParams;
		var cart = null;
		$scope.showComment = {staff: 'N', dsg: 'N'};
		$scope.clientSideError = {message: ''};
		
		
		//TODO: Get these values from the server
		$scope.frequencies = ['Single','Monthly','Quarterly','Semi-Annual','Annual']; 
		 
		//can get custom amounts or defaults
		$scope.amounts = ['50','100','250','500','1000','5000'];
		$scope.amounts.push('Other:');

		
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
		
		$scope.initPage = function(){
			drawDayEndpoints.fetchDrawDays(new Date().toISOString()).then(function(results){
				$scope.transactionDays = results.data;
				$scope.transactionDay = $scope.transactionDays[0].key;
			});
			
			drawDayEndpoints.fetchDrawMonths(new Date().toISOString()).then(function(results){
				$scope.transactionMonths = results.data;
				$scope.transactionMonth = $scope.transactionMonths[0];
			});
			
			var designationNumber = '';
			
			if(params.edit == 'Y') {
				$scope.isNew = false;
				gift.retrieve(params.giftId).then(function(results) {
					$scope.gift = results;
					designationNumber = $scope.gift.designationNumber;
					
					//TODO: Remove this once we can load designation numbers properly
					if(designationNumber == null) {
						designationNumber = '2843160';
					}
					$scope.designation = {externalDescription: 'Ryan T. Carlson', type: 'Ministry', 
							  designationNumber: designationNumber};
					$scope.gift.designationNumber = $scope.designation.designationNumber;
					
					if($scope.isOther($scope.gift.giftAmount, $scope.amounts)) {
						$scope.otherValue = $scope.gift.giftAmount;
						$scope.setGiftToOther();
					}
				});
			}
			else {
				$scope.isNew = true;
				$scope.createGift();
				designationNumber = params.designationNumber;
				
				$scope.designation = {externalDescription: 'Ryan T. Carlson', type: 'Ministry', 
						  designationNumber: designationNumber};
			}
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
			/* Only set the cart id here if the cart is not null 
			 * because if they are coming back to the page, the 
			 * cart will be null and the gift.cartId will already 
			 * be set from the retrieve()
			*/
			if(cart != null) {
				$scope.gift.cartId = cart.cartId;
			}
			
			//make sure we have a positive value in the Other box and Other is selected
			if($scope.otherValue != null && $scope.otherValue > 0 
					&& $scope.gift.giftAmount === 'Other:') {
				$scope.gift.giftAmount = $scope.otherValue;
			}
			
			if($scope.gift.giftFrequency != 'Single') {
				$scope.gift.dayOfMonth = $scope.transactionDay;
				$scope.gift.startDate = $scope.createDate($scope.transactionMonth.year, $scope.transactionMonth.month, $scope.transactionDay);
			}
			gift.update($scope.gift).then(function(results) {
				//TODO: Need some sort of way to tell the user that the server is working
				$location.path('/GiftCartPage/' + $scope.gift.cartId);
			});
		};
		
		$scope.cancel = function() {
			//TODO: if new: delete gift else go back to GiftCartPage with no edits
			//TODO: if new: delete cart
			//TODO: if new: redirect to ministry/staff/fund appeal detail page
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
		
		$scope.setErrorMessage = function(errorMessage) {
			validationService.setErrorMessage(errorMessage);
		};
		
		
		/**
		 * Determine whether the user picked a default radio 
		 * option or if they entered a custom amount.
		 */
		$scope.isOther = function(amount, amounts) {
			for(var i = 0; i < amounts.length; i++) {
				if(amounts[i] == amount) {
					return false;
				}
			}
			
			return true;
		};
});