function GiftDetlController($scope, $http){
	
	/*creates a new 'blank gift' in the database and looks for the URI to 
	 *the resource in the header 'X-Created-Gift'*/
	$scope.createGift = function(){
		$http.post('http://localhost:8080/dss-middleware/rest/gift')
			.success(function(data, status, headers, config){
				var createdGiftLocation = headers('X-Created-Gift');

				$http.get('http://localhost:8080' + createdGiftLocation)
					.success(function(data){
						$scope.gift = data;
					});
			});
	};
	
	/*update the previously saved gift with the values input by the client*/
	$scope.saveGift = function(){
		$scope.gift.cartId = $scope.cart.cartId;
		
		$http.put('http://localhost:8080/dss-middleware/rest/gift', $scope.gift);
	};
	
	/*creates a new 'blank cart' in the database and looks for the URI to 
	 *the resource in the header 'X-Created-Cart'*/
	$scope.createCart = function(){
		$http.post('http://localhost:8080/dss-middleware/rest/cart')
			.success(function(data, status, headers, config){
				var createdCartLocation = headers('X-Created-Cart');
			
				$http.get('http://localhost:8080' + createdCartLocation)
					.success(function(data){
						$scope.cart = data;
					});
			});
	};
	
	/*note, this setup method triggers a race condition in jBoss AS7 when two entity
	 * managers are injected at about the same time.*/
	$scope.initPage = function(){
		$scope.createGift();
		$scope.createCart();
	};
};

//TBD below....
function GiftCartController($scope, $http){
	$scope.retrieveCart = function(){
		$http.get('http://localhost:8080/dss-middleware/rest/cart/')
			.success(function(data, status, headers, config){
				$scope.cart = data;
			});
	}
}