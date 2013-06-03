'use strict';

angular.module('dssMiddlewareApp')
	.controller('ErrorCtrl', function($scope, validationService) {
		$scope.errors = [];
		$scope.error = '';
		$scope.errorText = validationService.getErrorMessage();
		$scope.errorHeader = '';
		
		$scope.hasError = function() {
			if($scope.errors.length > 0 || $scope.error.length > 0 || $scope.errorText.length > 0) {
				return true;
			}
			else {
				return false;
			}
		};
		
		$scope.errorsSizeOne = function() {
			return $scope.errors.length == 1;
		};
		
		$scope.$on('updateError', function(event, message) {
			$scope.errorText = validationService.getErrorMessage();
		});
	});