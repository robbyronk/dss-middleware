'use strict';

angular.module('dssMiddlewareApp')
	.controller('ErrorCtrl', function($scope, validationService) {
		$scope.errors = {errorList: [], error: '', errorText: validationService.getErrorMessage, 
				errorHeader: ''};
		
		$scope.hasError = function() {
			if($scope.errors.errorList.length > 0 || $scope.errors.error.length > 0 || $scope.errors.errorText.length > 0) {
				return true;
			}
			else {
				return false;
			}
		};
		
		$scope.errorsSizeOne = function() {
			return $scope.errors.errorList.length === 1;
		};
		
		$scope.$on('updateError', function(event, message) {
			$scope.errors.errorText = validationService.getErrorMessage();
		});
	});