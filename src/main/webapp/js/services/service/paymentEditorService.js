'use strict';

/**
 * This service is designed to pass variables between the 
 * parent pages (CheckoutPaymentMethod, CheckoutSelectPaymentMethod, 
 * perhaps eventually EditPayment) and the editor components for 
 * the specific payment editors (credit card and bank account).
 */
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