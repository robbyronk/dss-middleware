'use strict';

angular.module('dssMiddlewareApp', ['ui'])
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
      .when('/GiftCartPage/:cartId', {
    	  templateUrl: 'views/GiftCartPage.html',
    	  controller: 'GiftCartCtrl'
      })
      .otherwise({
        redirectTo: '/GiftDetail/:designationNumber'
      });
  });