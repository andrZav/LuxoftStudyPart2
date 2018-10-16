// angular settings
var filesApp = angular.module('filesApp', []);
filesApp.controller('filesCtrl', function ($scope, $http) {
    $scope.lastFileName = '';
    $scope.response = '';
    $scope.cssResponse = '';
    $scope.getFiles = function(){
        $http.get("files/getFiles")
            .then(function (response) {
                if (response.data === "") {
                    location.href = "/";
                    return;
                }
                $scope.files = response.data;
            });
    };
    $scope.getStatistic = function(fileName){
        $scope.lastFileName = fileName;
        var length = parseInt($("#lineWidth").val(), 10);
        var filters = {
            fileName: fileName,
            lineWidth: length === null ? 0 : length
        };
        var jData = JSON.stringify(filters);
        $http.post("files/getStatistic", jData)
            .then(function (response) {
                if (response.data === "") {
                    location.href = "/";
                    return;
                }
                $scope.statistics = response.data;
            });
    };
    $scope.clear = function(){
        $("#lineWidth").val('');
        var filters = {
            fileName: $scope.lastFileName,
            lineWidth: 0
        };
        var jData = JSON.stringify(filters);
        $http.post("files/getStatistic", jData)
            .then(function (response) {
                if (response.data === "") {
                    location.href = "/";
                    return;
                }
                $scope.statistics = response.data;
            });
    };
    $scope.deleteFile = function(fileName){
        var filters = {
            fileName: fileName
        };
        var jData = JSON.stringify(filters);
        $http.post("files/deleteFile", jData)
            .then(function (response) {
                $('body').removeClass('modal-open');
                $('.modal-backdrop').remove();
                $scope.files = response.data;
            });
    };
});
