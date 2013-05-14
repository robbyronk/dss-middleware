'use strict';

angular.module('dssMiddlewareApp', [])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/GiftDetail', {
        templateUrl: 'views/GiftDetail.html',
        controller: 'GiftDetlController'
      })
      .otherwise({
        redirectTo: '/GiftDetail'
      });
  });