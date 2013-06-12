'use strict';

angular.module('dssMiddlewareApp', ['ui'])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/GiftDetail/:designationNumber', {
        templateUrl: 'views/GiftDetail.html',
        controller: 'GiftDetailCtrl'
      })
      .when('/GiftDetail/:giftId/:edit', {
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
      .when('/CheckoutMailingAddress/:cartId', {
    	  templateUrl: 'views/CheckoutMailingAddress.html',
    	  controller: 'CheckoutMailingAddressCtrl'
      })
      .otherwise({
        redirectTo: '/GiftDetail/:designationNumber'
      });
  });