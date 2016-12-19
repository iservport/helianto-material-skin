(function () {
    'use strict';

    angular.module('app', ['ngResource','ngMaterial'])
    .controller('ViewController', ViewController);

    ViewController.$inject = ['$rootScope', '$http', '$log'];

    function ViewController($rootScope, $http, $log) {

        var view = this;

        $log.info("View Controller is active.");

        view.selected = 0;

        view._csrf = "";

        $http.get("app/entity")
            .then(function(response) {
                view.entity = response.data;
            })

        $http.get("app/me")
            .then(function(response) {
                view.me = response.data;
            })

    }

} ());
