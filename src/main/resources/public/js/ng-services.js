(function () {
    'use strict';

    angular.module('app').controller('ViewController', ViewController);

    ViewController.$inject = ['$rootScope', '$http', '$log'];

    function ViewController($rootScope, $http, $log) {

        var view = this;

        $log.info("View Controller is active.");

        view.csrf = function(csrf) {
            $rootScope.csrf = csrf;
        }

        $rootScope.selected = 0;

        view.select = function(value) { $rootScope.selected = value; }

        view.isSelected = function(value) { return $rootScope.selected == value; }

        view.logout = function(csrf) {
            $http.get("logout?_csrf="+csrf)
                .then(function(response) {}).catch(function(e) { $log.error("logout FAILED"); })
        }

        $rootScope.$watch('selected', function(newValue){
            $log.info("Selected: "+newValue);
            $http.get("app/me")
                .then(function(response) {
                    $rootScope.me = response.data;
                    $http.get("app/entity")
                        .then(function(response) {
                            $rootScope.entity = response.data;
                        }).catch(function(e) { $log.error("app/entity FAILED"); })
                }).catch(function(e) { $log.error("app/me FAILED"); })
        });

    }

} ());
