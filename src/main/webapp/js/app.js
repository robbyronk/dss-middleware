'use strict';

angular.module('dssMiddlewareApp', [])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/GiftDetail', {
        templateUrl: 'views/GiftDetail.html',
        controller: 'GiftDetlController'
      })
      .when('/GiftCartPage', {
    	  templateUrl: 'views/GiftCartPage.html',
    	  controller: 'GiftCartController'
      })
      .otherwise({
        redirectTo: '/GiftDetail'
      });
  });