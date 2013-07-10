'use strict';

angular.module('dssMiddlewareApp')
	.factory('frequencyService', function() {
		var frequencyService = {};
		
		/**
		 * Sort the frequencies based on the Order_By 
		 * value.
		 * 
		 * @param frequencies - unsorted list of frequencies
		 * 
		 * @returns sorted list of frequencies
		 */
		frequencyService.getSortedFrequencies = function(frequencies) {
			frequencies.list.sort(function(freq1, freq2) {
				if(freq1.dropdownOrderBy == null && freq2.dropdownOrderBy != null) {
					return -1;
				}
				else if(freq1.dropdownOrderBy != null && freq2.dropdownOrderBy == null) {
					return 1;
				}
				else if(freq1.dropdownOrderBy > freq2.dropdownOrderBy) {
					return 1;
				}
				else if(freq1.dropdownOrderBy < freq2.dropdownOrderBy) {
					return -1;
				}
				else {
					return 0;
				}
			});
			return frequencies;
		};
		
		return frequencyService;
	});