<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
</head>
<body>

<div ng-app="myApp" ng-controller="customersCtrl" ng-model="user">

</div>

<script>
    var app = angular.module('myApp', []);
    app.controller('customersCtrl', function($scope, $http) {
        $http.get("http://localhost:8080/getJson")
                .success
                (function(data)
                        {
                            alert(data);
                        }
                )
                .error(function(e)
                {
                    alert('请求失败了');
                });
    });
</script>

</body>
</html>
