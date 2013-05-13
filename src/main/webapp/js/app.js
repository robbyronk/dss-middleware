'use strict';

angular.module('dssMiddlewareApp', [])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/GiftDetail.html',
        controller: 'GiftDetlController'
      })
      .otherwise({
        redirectTo: '/'
      });
  });