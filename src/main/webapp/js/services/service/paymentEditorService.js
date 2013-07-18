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
		var checkout_ = {isCheckout: false};
		var isBankAccountRequired_ = true;
		var isCreditCardRequired_ = true;
		
		paymentEditor.getSelectedPayment = function() {
			return selectedPayment_;
		};
		
		paymentEditor.setSelectedPayment = function(selectedPayment) {
			selectedPayment_ = selectedPayment;
		};
		
		paymentEditor.getIsCheckout = function() {
			return checkout_;
		};
		
		paymentEditor.setIsCheckout = function(isCheckout) {
			checkout_.isCheckout = isCheckout;
		};
		
		paymentEditor.isBankAccountRequired = function() {
			return isBankAccountRequired_;
		};
		
		paymentEditor.setBankAccountRequired = function(required) {
			isBankAccountRequired_ = required;
		};
		
		paymentEditor.isCreditCardRequired = function() {
			return isCreditCardRequired_;
		};
		
		paymentEditor.setCreditCardRequired = function(required) {
			isCreditCardRequired_ = required;
		};
		
		return paymentEditor;
	});