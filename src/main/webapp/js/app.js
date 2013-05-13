'use strict';

angular.module('dssMiddlewareApp', [])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/GiftCartPage.html'
      })
      .otherwise({
        redirectTo: '/'
      });
  });