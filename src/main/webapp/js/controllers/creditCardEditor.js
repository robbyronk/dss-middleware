'use strict';

angular.module('dssMiddlewareApp')
	.controller('CreditCardEditorCtrl', function($scope, $routeParams, creditCardEditorService, cartCrud) {
		$scope.initPage = function() {
			$scope.creditCardTypes = ['American Express', 'Diners Club', 'Discover', 'MasterCard', 'Visa'];
			$scope.availableExpirationMonths = ['01', '02', '03', '04', '05', '06', 
			                                    '07', '08', '09', '10', '11', '12'];
			$scope.availableExpirationYears = ['2013','2014','2015','2016','2017','2018','2019','2020','2021',
			                                   '2022','2023','2024','2025','2026','2027','2028','2029','2030'];
			
			$scope.addressToEdit = creditCardEditorService.getAddressToEdit();
			$scope.pointToMailAddr = creditCardEditorService.getPointToMailAddr();
			$scope.selectedPayment = creditCardEditorService.getSelectedPayment();
		};
		
		/**
		 * Deal with the more complex logic involved with 
		 * switching between the mailing address on file and a 
		 * separate, specific billing address for this credit card.
		 */
		$scope.changePointToMailAddr = function() {
			creditCardEditorService.setPointToMailAddr($scope.pointToMailAddr);
			if($scope.pointToMailAddr) {
				/* If we are using the mailing address, we do not need the ability to
				 * edit the fields, so we want to make it read only (so the required 
				 * is taken off and we can submit the form).
				 */ 
				$scope.displayAddress = $scope.cart.mailingAddress;
				$scope.readOnly = true;
			}
			else {
				/* If we are using a separate billing address, we need to be able to 
				 * edit the address fields.
				 */
				$scope.readOnly = false;
				
				/* If the user has already created this payment method, it may have the 
				 * billing address filled in as the mailing address, in this case, we do 
				 * not want to show the mailing address in the editable fields, instead we 
				 * want to have blank fields.  However, if the billing address is different, 
				 * we want to show that address (because they would have started with the 
				 * pointToMailAddr == false and it would be inconvenient if they accidentally 
				 * checked the checkbox and came back to empty fields).
				 */
				if(creditCardEditorService.areAddressesEffectivelyTheSame($scope.cart.mailingAddress, $scope.selectedPayment.billingAddress)) {
					$scope.addressToEdit = {country: ''};
				}
				else {
					$scope.addressToEdit = $scope.selectedPayment.billingAddress;
				}
				
				//If blank, set country to the current mailing address country or USA if that is blank
				if($scope.addressToEdit.country == '' || $scope.addressToEdit.country == null) {
					if($scope.cart.mailingAddress != null && $scope.cart.mailingAddress.country != '') {
						$scope.addressToEdit.country = $scope.cart.mailingAddress.country;
					}
					else {
						$scope.addressToEdit.country = 'USA';
					}
				}
				
				creditCardEditorService.setAddressToEdit($scope.addressToEdit);
			}
		};
	});