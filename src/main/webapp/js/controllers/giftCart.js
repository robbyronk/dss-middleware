'use strict';

//TBD below....
angular.module('dssMiddlewareApp')
	.controller('GiftCartController', function ($scope, $http){
	$scope.retrieveCart = function(){
		$http.get('http://localhost:8080/dss-middleware/rest/cart/')
			.success(function(data, status, headers, config){
				$scope.cart = data;
			});
	};
});