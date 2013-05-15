'use strict';

describe('Gift CRUD', function() {
	var giftEndpoints;
	 
	beforeEach(module('dssMiddlewareApp'));
	beforeEach(inject(function( _giftEndpoints_) {
		giftEndpoints = _giftEndpoints_;
	}));
	
	describe('Gift Retrieve', function() {
		it('should be defined', function() {
			var endpoints = giftEndpoints();
			expect(endpoints).toBeDefined();
			expect(endpoints.create).toBeDefined();
			expect(endpoints.update).toBeDefined();
		});
		
		it('should call update gift with giftId = 1', function() {
			var endpoints = giftEndpoints();
			spyOn(endpoints, "update");
			endpoints.update("1");
			expect(endpoints.update).toHaveBeenCalledWith("1");
		});
	});
});