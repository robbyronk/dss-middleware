'use strict';

describe('Gift cart controller test', function() {
	var scope = null;
	
	describe('Has comments', function() {
		var gift;
		var hasComments;
		
		beforeEach(module('dssMiddlewareApp'));
		
		beforeEach(inject(function($rootScope, $controller) {
			scope = $rootScope.$new();
			$controller('GiftCartCtrl', {$scope: scope});
		}));
		
		it('should have comments to recipient', function() {
			gift = {commentsToRecipient: 'Comment'};
			hasComments = scope.hasComments('recipient', gift);
			expect(hasComments).toBe(true);
		});
		
		it('should have comments to DSG', function() {
			gift = {commentsToDonationServices: 'Comment'};
			hasComments = scope.hasComments('dsg', gift);
			expect(hasComments).toBe(true);
		});
		
		it('should not have comments to recipient', function() {
			gift = {commentsToDonationServices: 'Comment'};
			hasComments = scope.hasComments('recipient', gift);
			expect(hasComments).toBe(false);
			
			gift = {commentsToRecipient: ''};
			hasComments = scope.hasComments('recipient', gift);
			expect(hasComments).toBe(false);
		});
		
		it('should not have comments to DSG', function() {
			gift = {commentsToDonationServices: ''};
			hasComments = scope.hasComments('dsg', gift);
			expect(hasComments).toBe(false);
			
			gift = {commentsToRecipient: 'Comment'};
			hasComments = scope.hasComments('dsg', gift);
			expect(hasComments).toBe(false);
		});
	});
});