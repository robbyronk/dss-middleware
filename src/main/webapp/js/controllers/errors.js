'use strict';

angular.module('dssMiddlewareApp')
	.controller('ErrorCtrl', function($scope) {
		$scope.errors = [];
		$scope.error = '';
		$scope.errorText = '';
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
	});