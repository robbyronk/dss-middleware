'use strict';

angular.module('dssMiddlewareApp', [])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/GiftDetail/:designationNumber', {
        templateUrl: 'views/GiftDetail.html',
        controller: 'GiftDetailCtrl'
      })
      .when('/GiftCartPage', {
    	  templateUrl: 'views/GiftCartPage.html',
    	  controller: 'GiftCartCtrl'
      })
      .otherwise({
        redirectTo: '/GiftDetail/:designationNumber'
      });
  });