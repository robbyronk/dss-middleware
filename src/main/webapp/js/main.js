function GiftCartController($scope, $http){

	$scope.saveGift = function(){
		alert('Gift Saved');
		$scope.gift.giftId = 1;
		$http.put('http://localhost:8080/dss-middleware/rest/gift', $scope.gift);
	};
	
};