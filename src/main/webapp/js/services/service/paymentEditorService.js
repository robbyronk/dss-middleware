'use strict';

angular.module('dssMiddlewareApp')
	.factory('paymentEditorService', function() {
		var paymentEditor = {};
		var selectedPayment_ = {};
		var isCheckout_ = false;
		
		paymentEditor.getSelectedPayment = function() {
			return selectedPayment_;
		};
		
		paymentEditor.setSelectedPayment = function(selectedPayment) {
			selectedPayment_ = selectedPayment;
		};
		
		paymentEditor.getIsCheckout = function() {
			return isCheckout_;
		};
		
		paymentEditor.setIsCheckout = function(isCheckout) {
			isCheckout_ = isCheckout;
		};
		
		return paymentEditor;
	});