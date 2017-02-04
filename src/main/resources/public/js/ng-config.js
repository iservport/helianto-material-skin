(function () {
    'use strict';

    function config($mdThemingProvider, $mdIconProvider, $mdAriaProvider) {
        $mdAriaProvider.disableWarnings();
    }

    config.$inject = ['$mdThemingProvider', '$mdIconProvider', '$mdAriaProvider'];

    angular.module('app').config(config);

} ());