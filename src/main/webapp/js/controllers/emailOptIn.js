'use strict';

angular.module('dssMiddlewareApp')
	.controller('EmailOptInCtrl', function($scope) {
		//TODO: Get this from the server
		$scope.webTitleList = {list: [{title: 'Campus Ministry', checked: true},
		                       {title: 'JESUS Film Project', checked: false}]};
	});