'use strict';

describe('Cart CRUD', function() {
	var cartEndpoints;
	 
	beforeEach(module('dssMiddlewareApp'));
	beforeEach(inject(function( _cartEndpoints_) {
		cartEndpoints = _cartEndpoints_;
	}));
	
	describe('Cart Retrieve', function() {
		it('should be defined', function() {
			var endpoints = cartEndpoints();
			expect(endpoints).toBeDefined();
			expect(endpoints.create).toBeDefined();
			expect(endpoints.retrieve).toBeDefined();
		});
		
		it('should call retrieve cart with cartId = 1', function() {
			var endpoints = cartEndpoints();
			spyOn(endpoints, "retrieve");
			endpoints.retrieve("1");
			expect(endpoints.retrieve).toHaveBeenCalledWith("1");
		});
	});
});