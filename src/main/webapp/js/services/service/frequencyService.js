'use strict';

angular.module('dssMiddlewareApp')
	.factory('frequencyService', function() {
		var frequencyService = {};
		
		//NOTE: It would be better to just hard code frequencies
		frequencyService.getSortedFrequencies = function(frequencies) {
			var frequencyPriority = ['Single', 'Monthly', 'Quarterly',
			                         'Semi-Annual', 'Annual'];
			var sortedFrequencies = [];
			
			for(var i = 0; i < frequencyPriority.length; i++) {
				for(var j = 0; j < frequencies.length; j++) {
					if(frequencies[j].dropdownValue == frequencyPriority[i]) {
						sortedFrequencies.push(frequencies[j]);
					}
				}
			}
			
			return sortedFrequencies;
		};
		
		return frequencyService;
	});