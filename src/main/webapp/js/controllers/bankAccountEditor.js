'use strict';

angular.module('dssMiddlewareApp')
	.controller('BankAccountEditorCtrl', function($scope, paymentEditorService) {
		$scope.initBankAccountPage = function() {
			$scope.agreeToTerms = false;
			$scope.routingHelp = "Routing Number is 9 digits surrounded by the &nbsp;<img src='images/RoutingIcon.gif'/>&nbsp; symbols and may be listed left or right of the Account Number. &nbsp;If your check has an ACH/RT number, enter that as your bank routing number.";
			$scope.accountHelp = "Account Number may be up to 17 digits and is usually listed left of the &nbsp;<img src='images/AccountIcon.gif'/>&nbsp; symbol.  &nbsp;Check Number may be listed left of the Account Number, but should not be included in the Account Number.";
			$scope.retypeAccountHelp = $scope.accountHelp;
			$scope.retypeBankAccountNumber = '';
			$scope.showRoutingHelpTip = false;
			$scope.showAccountHelpTip = false;
			$scope.showRetypeAccountHelpTip = false;
			$scope.isCheckout = paymentEditorService.getIsCheckout();
		};
		
		//TODO: Perhaps turn this into a directive (the current Javascript does not work well in Chrome)
		$scope.showHelpTip = function(field, event) {
			if(field == 'routingNumber') {
				showHelpTip(event, $scope.routingHelp, false);
			}
			else if(field == 'accountNumber') {
				showHelpTip(event, $scope.accountHelp, false);
			}
			else if(field == 'retypeAccountNumber') {
				showHelpTip(event, $scope.retypeAccountHelp, false);
			}
		};
	});