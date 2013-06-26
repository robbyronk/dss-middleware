'use strict';

angular.module('dssMiddlewareApp')
	.factory('creditCardEditorService', function() {
		var creditCardEditor = {};
		var pointToMailAddr_ = false;
		var selectedPayment_ = {};
		
		creditCardEditor.getPointToMailAddr = function() {
			return pointToMailAddr_;
		};
		
		creditCardEditor.setPointToMailAddr = function(pointToMailAddr) {
			pointToMailAddr_ = pointToMailAddr;
		};
		
		creditCardEditor.getSelectedPayment = function() {
			return selectedPayment_;
		};
		
		creditCardEditor.setSelectedPayment = function(selectedPayment) {
			selectedPayment_ = selectedPayment;
		};
		
		/**
		 * Determine whether the mailing address and billing address are the same place.
		 */
		creditCardEditor.areAddressesEffectivelyTheSame = function(mailingAddress, billingAddress) {
			if(billingAddress == null || billingAddress.streetAddress1 == '' || 
					(billingAddress.streetAddress1 == mailingAddress.streetAddress1 && 
					 billingAddress.streetAddress2 == mailingAddress.streetAddress2 && 
					 billingAddress.city == mailingAddress.city && 
					 billingAddress.state == mailingAddress.state && 
					 billingAddress.country == mailingAddress.country)) {
				return true;
			}
			else {
				return false;
			}
		};
		
		return creditCardEditor;
	});