'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftDetailCtrl', function ($scope, $routeParams, $location, $window, drawDayEndpoints, 
			giftCrud, cartCrud, validationService, dateService, giftResolved, frequencyCrud, 
			frequencyService, frequenciesResolved) {
		var params = $routeParams;
		var cart = null;
		var designationNumber = '';
		
		$scope.initGiftDetail = function() {
			$scope.frequencies = frequencyService.getSortedFrequencies(frequenciesResolved);
			$scope.showComment = {staff: 'N', dsg: 'N'};
			$scope.clientSideError = {message: ''};
			$scope.hasError = {value: false};
			$scope.otherValue = {value: ''};
			
			//TODO: Get amounts from server
			//can get custom amounts or defaults
			$scope.amounts = {list: ['50','100','250','500','1000','5000']};
			$scope.amounts.list.push('Other:');
			
			if(params.giftId != null) {
				$scope.setupForEditGift();
			}
			else {
				$scope.isNew = {value: true};
				$scope.createGift();
			}
		};
		
		/**
		 * Set up the variables needed for editing an existing gift
		 */
		$scope.setupForEditGift = function() {
			$scope.isNew = {value: false};
			$scope.gift = giftResolved;
			designationNumber = $scope.gift.designationNumber;
			$scope.initTransactionDate($scope.gift.startDate);
			
			//TODO: Remove this once we can load designation numbers properly
			if(designationNumber == null) {
				designationNumber = '2843160';
			}
			$scope.designation = {externalDescription: 'Ryan T. Carlson', type: 'Ministry', 
					  designationNumber: designationNumber};
			//////////////////////////////////////////////////////////////////
			
			$scope.gift.designationNumber = $scope.designation.designationNumber;
			
			if($scope.isOther($scope.gift.giftAmount, $scope.amounts.list)) {
				$scope.otherValue.value = $scope.gift.giftAmount;
				$scope.setGiftToOther();
			}
			
			if($scope.gift.commentsToDonationServices != null && 
					$scope.gift.commentsToDonationServices.length > 0) {
				$scope.showComment.dsg = 'Y';
			}
			if($scope.gift.commentsToRecipient != null && 
					$scope.gift.commentsToRecipient.length > 0) {
				$scope.showComment.staff = 'Y';
			}
		};
		
		/**
		 * Create a gift and set the proper gift values and defaults.
		 */
		$scope.createGift = function() {
			var cartAndGift = {};
			giftCrud.create().then(function(results) {
				cartAndGift = results;
				$scope.gift = cartAndGift.gift;
				designationNumber = params.designationNumber;
				//TODO: Get this from the server
				$scope.designation = {externalDescription: 'Ryan T. Carlson', type: 'Ministry', 
						  designationNumber: designationNumber};
				$scope.gift.designationNumber = $scope.designation.designationNumber;
				$scope.gift.giftAmount = $scope.amounts.list[0];
				$scope.gift.giftFrequency = $scope.frequencies.list[0].dropdownValue;
				cart = cartAndGift.cart;
				cart.checkoutType = 'STANDARD_CHECKOUT';  //TODO: Are we going to reuse this controller for branded checkout?
				cart.operatingSystem = navigator.platform;
				cart.screenWidth = $window.screen.width;
				cart.screenHeight = $window.screen.height;
				$scope.initTransactionDate(null);
			});
		};
		
		/**
		 * Retrieve the list of transaction days and months.
		 */
		$scope.initTransactionDate = function(startDate) {
			var fetchDate = null;
			if($scope.isNew.value) {
				fetchDate = new Date();
			}
			else {
				fetchDate = new Date(startDate);
			}
			
			drawDayEndpoints.fetchDrawDays(fetchDate.toISOString()).then(function(results){
				$scope.transactionDays = results.data;
				$scope.transactionDay = {day: 
					$scope.setTransactionDay($scope.gift.dayOfMonth, $scope.transactionDays)};
			});
			
			drawDayEndpoints.fetchDrawMonths(new Date().toISOString()).then(function(results){
				$scope.transactionMonths = {months: results.data};
				$scope.transactionMonth = 
					$scope.setTransactionMonth(startDate, $scope.transactionMonths.months);
			});
		};
		
		/**
		 * Initialize the transaction month select box with the proper 
		 * month option selected.
		 */
		$scope.setTransactionMonth = function(startDate, transactionMonths) {
			if(startDate != null) {
				var monthObject = $scope.generateMonthObject(startDate);
				return transactionMonths[$scope.getTransactionMonthIndex(monthObject, transactionMonths)];
			}
			else {
				return transactionMonths[0];
			}
		};
		
		/**
		 * Initialize the transaction day select box with the proper 
		 * day option selected.
		 */
		$scope.setTransactionDay = function(dayOfMonth, transactionDays) {
			if(dayOfMonth != null) {
				return dayOfMonth;
			}
			else {
				return transactionDays[0].key;
			}
		};
		
		/**
		 * When the user selects a different transaction month, 
		 * refresh the available transaction days based on that 
		 * new month.
		 */
		$scope.refreshDrawDays = function(){
			drawDayEndpoints.fetchDrawDays(dateService.createDate(
														$scope.transactionMonth.year,
														$scope.transactionMonth.month,
														1).toISOString()).then(function(results){
				$scope.transactionDays = results.data;
				$scope.transactionDay = {day: $scope.transactionDays[0].key};
			});
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
			else {
				//Remove error message when user selects a different amount
				$scope.setErrorMessage('');
				$scope.otherValue.value = '';
				$scope.$broadcast('updateError', '');
			}
		};
		
		/**
		 * Create an object with the transaction month information 
		 * included.
		 */
		$scope.generateMonthObject = function(millisDate) {
			var monthObject = {};
			monthObject.month = '' + dateService.parseMonth(millisDate);
			monthObject.year = '' + dateService.parseYear(millisDate);
			monthObject.display = dateService.getMonthAsString(monthObject.month) 
				+ ', ' + monthObject.year;
			return monthObject;
		};
		
		$scope.getTransactionMonthIndex = function(monthObject, transactionMonths) {
			for(var i = 0; i < transactionMonths.length; i++) {
				if(transactionMonths[i].display === monthObject.display) {
					return i;
				}
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
				obj.value = obj.value.substring(0, mlength);
			}
		};
		
		$scope.setErrorMessage = function(errorMessage) {
			validationService.setErrorMessage(errorMessage);
			$scope.clientSideError.message = errorMessage;
			if(errorMessage.length > 0) {
				$scope.hasError.value = true;
			}
			else {
				$scope.hasError.value = false;
			}
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
			
			//see if we have a positive value in the Other box and Other is selected
			if($scope.otherValue != undefined && $scope.otherValue != null 
					&& ($scope.otherValue.value.length > 0 || $scope.otherValue.value >= 0.01) //numbers don't have the .length property
					&& $scope.gift.giftAmount === 'Other:') {
				$scope.gift.giftAmount = $scope.otherValue.value;
			}
			
			if($scope.gift.giftFrequency !== 'Single') {
				$scope.gift.dayOfMonth = $scope.transactionDay.day;
				$scope.gift.startDate = dateService.createDate($scope.transactionMonth.year, $scope.transactionMonth.month, $scope.transactionDay.day);
			}
			giftCrud.update($scope.gift).then(function(results) {
				//TODO: Need some sort of way to tell the user that the server is working
				
				//if this is a new gift, we want to save the metadata on the cart
				if(cart != null) { 
					cartCrud.updateCart(cart).then(function () {
						$location.path('/GiftCartPage/' + $scope.gift.cartId);
					});
				}
				else {
					$location.path('/GiftCartPage/' + $scope.gift.cartId);
				}
			});
		};
		
		/**
		 * Either go back instead of editing the gift or 
		 * remove the newly created gift and cart then take the 
		 * user back to a detail page.
		 */
		$scope.cancel = function() {
			if(params.giftId != null) {
				$location.path('/GiftCartPage/' + $scope.gift.cartId);
			}
			else {
				var giftId = $scope.gift.giftId;
				var cartId = cart.cartId;
				giftCrud.deleteGift(giftId).then(function() {
					cartCrud.deleteCart(cartId).then(function() {
						//TODO: redirect to ministry/staff/fund appeal detail page
						//this requires designation number
					});
				});
				
				
			}
		};
	});