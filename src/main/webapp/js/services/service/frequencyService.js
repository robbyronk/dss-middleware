'use strict';

angular.module('dssMiddlewareApp')
	.factory('frequencyService', function() {
		var frequencyService = {};
		
		//NOTE: It would be better to just hard code frequencies
		frequencyService.getSortedFrequencies = function(frequencies) {
			var frequencyPriority = ['Single', 'Monthly', 'Quarterly',
			                         'Semi-Annual', 'Annual'];
			var sortedFrequencies = {list: []};
			
			for(var i = 0; i < frequencyPriority.length; i++) {
				for(var j = 0; j < frequencies.length; j++) {
					if(frequencies[j].dropdownValue == frequencyPriority[i]) {
						sortedFrequencies.list.push(frequencies[j]);
					}
				}
			}
			
			return sortedFrequencies;
		};
		
		frequencyService.getHardCodedFrequencies = function() {
			return {list: [{dropdownValue: 'Single', dropdownName: 'Single'},
			               {dropdownValue: 'Monthly', dropdownName: 'Monthly'},
			               {dropdownValue: 'Quarterly', dropdownName: 'Quarterly'},
			               {dropdownValue: 'Semi-Annual', dropdownName: 'Semi-Annual'},
			               {dropdownValue: 'Annual', dropdownName: 'Annual'}]};
		};
		
		return frequencyService;
	});