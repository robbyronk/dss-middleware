'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftDetailCtrl', function ($scope, $routeParams, cartEndpoints, gift) {
	
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
		$scope.transactionDays = [{display: '5th', value: '5'},
		                          {display: '10th', value: '10'},
		                          {display: '15th', value: '15'},
		                          {display: '20th', value: '20'},
		                          {display: '25th', value: '25'}];  
		$scope.transactionMonths = [{display: 'May, 2013', month: '5', year: '2013', value: '5/2013'},
		                            {display: 'June, 2013', month: '6', year: '2013', value: '6/2013'},
		                            {display: 'July, 2013', month: '7', year: '2013', value: '7/2013'},
		                            {display: 'August, 2013', month: '8', year: '2013', value: '8/2013'},
		                            {display: 'September, 2013', month: '9', year: '2013', value: '9/2013'},
		                            {display: 'October, 2013', month: '10', year: '2013', value: '10/2013'},
		                            {display: 'November, 2013', month: '11', year: '2013', value: '11/2013'},
		                            {display: 'December, 2013', month: '12', year: '2013', value: '12/2013'},
		                            {display: 'January, 2014', month: '1', year: '2014', value: '1/2014'},
		                            {display: 'February, 2014', month: '2', year: '2014', value: '2/2014'},
		                            {display: 'March, 2014', month: '3', year: '2014', value: '3/2014'},
		                            {display: 'April, 2014', month: '4', year: '2014', value: '4/2014'}]; 
		
		$scope.transactionMonth = $scope.transactionMonths[0];
		
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
				$scope.gift.startDate = $scope.createStartDate($scope.transactionMonth.month, 
						$scope.transactionMonth.year, $scope.gift.dayOfMonth);
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
		$scope.createStartDate = function(month, year, day) {
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