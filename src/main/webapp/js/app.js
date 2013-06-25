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
      .when('/CheckoutSelectPaymentMethod/:cartId', {
    	  templateUrl: 'views/CheckoutSelectPaymentMethod.html',
    	  controller: 'CheckoutPaymentMethodCtrl', 
    	  resolve: {
    		  cartResolved: function($route, cartCrud) {
    			  return cartCrud.retrieve($route.current.params.cartId);
    		  }
    	  }
      })
      .when('/CheckoutPaymentMethod/:cartId', {
    	  templateUrl: 'views/CheckoutPaymentMethod.html',
    	  controller: 'CheckoutPaymentMethodCtrl', 
    	  resolve: {
    		  cartResolved: function($route, cartCrud) {
    			  return cartCrud.retrieve($route.current.params.cartId);
    		  }
    	  }
      })
      .when('/CheckoutPaymentMethod/:cartId/:transType', {
    	  templateUrl: 'views/CheckoutPaymentMethod.html',
    	  controller: 'CheckoutPaymentMethodCtrl', 
    	  resolve: {
    		  cartResolved: function($route, cartCrud) {
    			  return cartCrud.retrieve($route.current.params.cartId);
    		  }
    	  }
      })
      .otherwise({
        redirectTo: '/GiftDetail/:designationNumber'
      });
  });