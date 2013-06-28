'use strict';

angular.module('dssMiddlewareApp')
	.factory('creditCardEditorService', function() {
		var creditCardEditor = {};
		var pointToMailAddr_ = false;
		var limitedEdit_ = false;
		
		creditCardEditor.getPointToMailAddr = function() {
			return pointToMailAddr_;
		};
		
		creditCardEditor.setPointToMailAddr = function(pointToMailAddr) {
			pointToMailAddr_ = pointToMailAddr;
		};
		
		creditCardEditor.getLimitedEdit = function() {
			return limitedEdit_;
		};
		
		creditCardEditor.setLimitedEdit = function(limitedEdit) {
			limitedEdit_ = limitedEdit;
		};
		
		/**
		 * Determine whether the mailing address and billing address are the same place.
		 */
		creditCardEditor.areAddressesEffectivelyTheSame = function(mailingAddress, billingAddress) {
			if(billingAddress == undefined && mailingAddress == undefined) {
				return true;
			}
			else if(billingAddress == null && mailingAddress == null) {
				return true;
			}
			else if(billingAddress == {} && mailingAddress == {}) {
				return true;
			}
			else if((billingAddress.streetAddress1 == mailingAddress.streetAddress1 && 
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