;
(function () {
  'use strict';

  angular.module('relay-gaps', [])
    .controller('RelayGapsController',
      ['$scope', '$http',
        function($scope, $http) {
          $scope.usernames = [{}];

          $scope.domains = $http.get('rest/domains');

          $scope.updateUsernames = function () {
            $http.put('rest/users', _.pluck($scope.usernames, 'name'));
            $scope.usernames = [{}];
          };

          $scope.updateDomain = function (domain) {
            $http.put('rest/domain/' + domain)
          };

          $scope.updateAllDomains = function(enabled) {
            if(enabled)
              $http.put('rest/domains')
          }
        }
      ])
})();