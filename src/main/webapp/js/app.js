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
    	  controller: 'CheckoutMailingAddressCtrl', 
    	  resolve: {
    		  cartResolved: function($route, cartCrud) {
    			  return cartCrud.retrieve($route.current.params.cartId);
    		  }
    	  }
      })
      .when('/CheckoutSelectPaymentMethod/:cartId', {
    	  templateUrl: 'views/CheckoutSelectPaymentMethod.html',
    	  controller: 'CheckoutPaymentMethodCtrl', 
    	  resolve: {
    		  cartResolved: function($route, cartCrud) {
    			  return cartCrud.retrieve($route.current.params.cartId);
    		  },
    		  //TODO: Remove this when we get the paymentMethodList from cart
      		  paymentMethodListResolved: function(paymentCrud) {
      			  return paymentCrud.retrievePaymentMethodList('470');
      		  }
    	  }
      })
      .when('/CheckoutPaymentMethod/:cartId', {
    	  templateUrl: 'views/CheckoutPaymentMethod.html',
    	  controller: 'CheckoutPaymentMethodCtrl', 
    	  resolve: {
    		  cartResolved: function($route, cartCrud) {
    			  return cartCrud.retrieve($route.current.params.cartId);
    		  },
      		  paymentMethodListResolved: function(paymentCrud) {
      			  return paymentCrud.retrievePaymentMethodList('470');
    		  }
    	  }
      })
      .when('/CheckoutPaymentMethod/:cartId/:transType', {
    	  templateUrl: 'views/CheckoutPaymentMethod.html',
    	  controller: 'CheckoutPaymentMethodCtrl', 
    	  resolve: {
    		  cartResolved: function($route, cartCrud) {
    			  return cartCrud.retrieve($route.current.params.cartId);
    		  },
      		  paymentMethodListResolved: function(paymentCrud) {
      			  return paymentCrud.retrievePaymentMethodList('470');
    		  }
    	  }
      })
      .otherwise({
        redirectTo: '/GiftDetail/:designationNumber'
      });
  });