var app = angular.module('ActorWebApps',[]);
 
 app.controller('HomeController',function ($scope,$http) {
 $scope.title = "Actors List printed below";
 
 $scope.arrActors = new Array;
 
 $http({method: 'get',
 	url:'http://localhost:8080/ActorWeb/rest/actors',
 	dataType:'json',
 	contentType:"application/json"}).then(function (response){
 	$scope.arrActors = response.data;
 	$scope.list = $scope.arrActors;
 	 console.log(response.data);
 }, function(error){
	
});
 
 })
 
