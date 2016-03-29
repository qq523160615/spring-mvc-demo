//var app = angular.module('myApp', [])
//app.contorller('myCtrl', function ($scope, $http) {
//    $scope.getjson = function () {
//        $http.get("/getJson").success(function (data) {
//                $scope.result = data.name;
//                alert("请求成功");
//            }
//        ).error(function (e) {
//            alert("请求失败");
//        });
//    }
//});
var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http) {
    $scope.getJson = function () {
        $http.get("http://localhost:8080/getJson").success(function (data) {
            $scope.result = data;
        });
    };

    $scope.postJson = function () {
        $http({
            url: 'http://localhost:8080/postJson',
            method: 'POST',
            data: '{"name":"' + $scope.name + '","age":' + $scope.age + '}'
        }).success(function (data) {
            alert(data);
            $scope.result = data;
        });
    }
});
