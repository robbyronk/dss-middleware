'use strict';

angular.module('dssMiddlewareApp')
	.controller('GiftCartCtrl', function ($scope, $routeParams, $location, cartCrud, giftCrud, designationService) {
		var params = $routeParams;
		
		$scope.initPage = function() {
			$scope.successMessage = '';
			
			if(params.cartId == undefined) {
				$scope.emptyCart = true;
			}
			else {
				cartCrud.retrieve(params.cartId).then(function(results) {
					$scope.cart = results;
					$scope.giftLines = $scope.cart.gifts;
					
					//This is the case where a user deletes a line and the cart becomes empty
					if($scope.giftLines.length == 0) {
						var cartId = $scope.cart.cartId;
						/* Delete cart to prevent empty carts sitting in the database
						 * This is okay because a new cart will be created when 
						 * the user comes back to add a gift.
						 */
						cartCrud.deleteCart(cartId).then(function() {
							$scope.emptyCart = true;
						});
					}
					else {
						$scope.generateFrequencyLists();
						$scope.generateListOfFrequencies();
						$scope.calculateFrequencyTotals();
					}
				});
				
//				$scope.giftLines = [{designationNumber: '2843160', giftAmount: 50.00, giftFrequency: 'Single', startDate: ''}, 
//				                    {designationNumber: '0550510', giftAmount: 100.00, giftFrequency: 'Monthly', startDate: '6/10/2013'}, 
//				                    {designationNumber: '2863048', giftAmount: 47.50, giftFrequency: 'Monthly', startDate: '7/15/2013'}];
			}
		};
		
		/**
		 * Separate out each type of gift into specified arrays
		 */
		$scope.generateFrequencyLists = function() {
			$scope.singleGifts = [];
			$scope.monthlyGifts = [];
			$scope.quarterlyGifts = [];
			$scope.semiAnnualGifts = [];
			$scope.annualGifts = [];
			
			for(var i = 0; i < $scope.giftLines.length; i++) {
				if($scope.giftLines[i].giftFrequency == 'Single') {
					$scope.singleGifts.push($scope.giftLines[i]);
				}
				else if($scope.giftLines[i].giftFrequency == 'Monthly') {
					$scope.monthlyGifts.push($scope.giftLines[i]);
				}
				else if($scope.giftLines[i].giftFrequency == 'Quarterly') {
					$scope.quarterlyGifts.push($scope.giftLines[i]);
				}
				else if($scope.giftLines[i].giftFrequency == 'Semi-Annual') {
					$scope.semiAnnualGifts.push($scope.giftLines[i]);
				}
				else if($scope.giftLines[i].giftFrequency == 'Annual') {
					$scope.annualGifts.push($scope.giftLines[i]);
				}
			}
		};
		
		/**
		 * Create a list of the frequencies that are being utilized
		 */
		$scope.generateListOfFrequencies = function() {
			$scope.frequencies = [];
			
			if($scope.monthlyGifts.length > 0) {
				$scope.frequencies.push('Monthly');
			}
			if($scope.quarterlyGifts.length > 0) {
				$scope.frequencies.push('Quarterly');
			}
			if($scope.semiAnnualGifts.length > 0) {
				$scope.frequencies.push('Semi-Annual');
			}
			if($scope.annualGifts.length > 0) {
				$scope.frequencies.push('Annual');
			}
			if($scope.singleGifts.length > 0) {
				$scope.frequencies.push('Single');
			}
		};
		
		/**
		 * Calculate the total amounts based on frequency
		 */
		$scope.calculateFrequencyTotals = function() {
			$scope.singleTotal = 0;
			$scope.monthlyTotal = 0;
			$scope.quarterlyTotal = 0;
			$scope.semiAnnualTotal = 0;
			$scope.annualTotal = 0;
			var i = 0;
			
			for(i = 0; i < $scope.singleGifts.length; i++) {
				$scope.singleTotal += $scope.singleGifts[i].giftAmount;
			}
			for(i = 0; i < $scope.monthlyGifts.length; i++) {
				$scope.monthlyTotal += $scope.monthlyGifts[i].giftAmount;
			}
			for(i = 0; i < $scope.quarterlyGifts.length; i++) {
				$scope.quarterlyTotal += $scope.quarterlyGifts[i].giftAmount;
			}
			for(i = 0; i < $scope.semiAnnualGifts.length; i++) {
				$scope.semiAnnualTotal += $scope.semiAnnualGifts[i].giftAmount;
			}
			for(i = 0; i < $scope.annualGifts.length; i++) {
				$scope.annualTotal += $scope.annualGifts[i].giftAmount;
			}
		};
		
		/**
		 * Get the total amount of all the gifts for a specific 
		 * frequency.
		 */
		$scope.getFrequencyTotal = function(frequency) {
			if(frequency == 'Single') return $scope.singleTotal;
			else if(frequency == 'Monthly') return $scope.monthlyTotal;
			else if(frequency == 'Quarterly') return $scope.quarterlyTotal;
			else if(frequency == 'Semi-Annual') return $scope.semiAnnualTotal;
			else if(frequency == 'Annual') return $scope.annualTotal;
		};
		
		$scope.getWebTitle = function(designationNumber) {
			return designationService.getWebTitle();
		};
		
		$scope.getDesigType = function(designationNumber) {
			return designationService.getDesigType();
		};
		
		$scope.isStaff = function(designationNumber) {
			return !designationService.isMinistry();
		};
		
		$scope.edit = function(giftId) {
			$location.path('/GiftDetail/' + giftId + '/Y');
		};
		
		$scope.remove = function(giftId) {
			giftCrud.deleteGift(giftId).then(function() {
				$scope.initPage();
				$scope.successMessage = 'Your gift was successfully removed. Your updated gift cart is displayed below.';
			});
		};
		
		$scope.addMoreGifts = function() {
			/* current logic:
			 *  if type == ministry, go back to that ministry's page
			 *  if type == staff, go back to home page
			 *  if type == fund appeal, go back to that fund appeal's page
			 *  this is based on the most recent gift given
			 */
			//TODO: Redirect back to the client
			window.href = 'https://give-stage.cru.org/';
		};
		
		$scope.continueBrowsing = function() {
			//TODO: Redirect back to the client
			window.href = 'https://give-stage.cru.org/';
		};
		
		$scope.viewDesig = function(designation) {
			//TODO: Redirect to give.cru.org/designation
		};
		
		$scope.proceedToCheckout = function() {
			$location.path('/CheckoutMailingAddress/' + $scope.cart.cartId);
		};
		
		/**
		 * Determine whether or not there is a comment to 
		 * the specified recipient.
		 */
		$scope.hasComments = function(commentTo, gift) {
			if(commentTo == 'recipient') {
				if(gift.commentsToRecipient == null || 
						gift.commentsToRecipient.length == 0) {
					return false;
				}
			}
			else {
				if(gift.commentsToDonationServices == null || 
						gift.commentsToDonationServices.length == 0) {
					return false;
				}
			}
			
			return true;
		};
});