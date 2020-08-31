var app = angular.module('ActorWebApps',[]);
 
 app.factory("actors", function($resource) {
    return $resource("http://localhost:8080/ActorWeb/rest/actors");
});
 
 
 app.controller('HomeController', ['$scope', function ($scope, actors) {
 	actors.query(function(data) {
        $scope.actors = data;
    }, function(err) {
        console.error("Error occured: ", err);
    });
}]);