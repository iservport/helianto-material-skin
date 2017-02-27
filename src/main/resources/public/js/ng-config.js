(function () {
    'use strict';

    function config($mdThemingProvider, $mdIconProvider, $mdAriaProvider, $mdDateLocaleProvider, moment) {

        $mdAriaProvider.disableWarnings();

        $mdDateLocaleProvider.formatDate = function(date) {
           return date ? moment(date).format('L') : '';
        };

        $mdDateLocaleProvider.parseDate = function(dateString) {
            var m = moment(dateString, 'L', true);
            return m.isValid() ? m.toDate() : new Date(NaN);
        };

    }

    config.$inject = ['$mdThemingProvider', '$mdIconProvider', '$mdAriaProvider', '$mdDateLocaleProvider', 'moment'];

    angular
    .module('app')
    .config(config)
    .config(function($compileProvider) {
         $compileProvider.preAssignBindingsEnabled(true);
    }).run(function(amMoment) {
         amMoment.changeLocale('pt_BR');
    });

} ());