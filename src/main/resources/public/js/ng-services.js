(function () {
    'use strict';

    angular.module('app', ['ngResource','ngMaterial'])
    .controller('ViewController', ViewController);

    ViewController.$inject = ['$rootScope', '$http'];

    function ViewController($rootScope, $http) {

        var vm = this;

        $rootScope.selected = 0;

        $rootScope._csrf = "";

        $http.get("entity")
            .success(function(data) {
                $rootScope.entity = data;
            })

        $http.get("me")
            .success(function(data) {
                $rootScope.me = data;
            })

    }

} ());
