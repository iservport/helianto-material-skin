(function () {
    'use strict';

    angular.module('app', ['ngResource','ui.bootstrap'])
    .controller('ViewController', ViewController);

    ViewController.$inject = ['$rootScope', '$http'];

    function ViewController($rootScope, $http) {

        var vm = this;

        $rootScope.selected = 0;

        $rootScope._csrf = "";

        $http.get("me")
            .success(function(data) {
                $rootScope.me = data;
            })

    }

} ());
