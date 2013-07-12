'use strict';

angular.module('dssMiddlewareApp')
	.factory('designationService', function() {
		var designationService = {};
		
		//TODO: We need to set up a rest-client service (then these functions will just become attributes of the object)
		designationService.getDesigType = function(designationNumber) {
			if(designationNumber == null || designationNumber == '2843160') return 'Ministry';
			else if(designationNumber == '0550510') return 'Staff';
			else if(designationNumber == '2571058') return 'Fund Appeal';
		};
		
		designationService.getWebTitle = function(designationNumber) {
			if(designationNumber == null || designationNumber == '2843160') return 'Ryan T. Carlson';
			else if(designationNumber == '0550510') return 'Marc and Evangeline Vergo';
			else if(designationNumber == '2571058') return 'Africa "JESUS" Film Equipment and Teams';
		};
		
		designationService.isMinistry = function(designationNumber) {
			var desigType = designationService.getDesigType(designationNumber);
			return desigType == 'Ministry' || desigType == 'Fund Appeal';
		};
		
		return designationService;
	});