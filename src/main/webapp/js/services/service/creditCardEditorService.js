'use strict';

angular.module('dssMiddlewareApp')
	.factory('creditCardEditorService', function() {
		var creditCardEditor = {};
		var pointToMailAddr_ = false;
		var cart_ = {};
		var selectedPayment_ = {};
		var addressToEdit_ = {};
		
		creditCardEditor.getPointToMailAddr = function() {
			return pointToMailAddr_;
		};
		
		creditCardEditor.setPointToMailAddr = function(pointToMailAddr) {
			pointToMailAddr_ = pointToMailAddr;
		};
		
		creditCardEditor.getCart = function() {
			return cart_;
		};
		
		creditCardEditor.setCart = function(cart) {
			cart_ = cart;
		};
		
		creditCardEditor.getSelectedPayment = function() {
			return selectedPayment_;
		};
		
		creditCardEditor.setSelectedPayment = function(selectedPayment) {
			selectedPayment_ = selectedPayment;
		};
		
		creditCardEditor.getAddressToEdit = function() {
			return addressToEdit_;
		};
		
		creditCardEditor.setAddressToEdit = function(addressToEdit) {
			addressToEdit_ = addressToEdit;
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