(function () {
    'use strict';

    angular
        .module('App')
        .service('AlertService', AlertService);

    AlertService.$inject = ['toastr'];

    function AlertService(toastr) {
        var vm = this;
        vm.showError = showError;
        vm.showSuccess = showSuccess;

        function showSuccess(message, title) {
            title = title || 'Sucesso';
            toastr.info(message, title);
        }

        function showError(message, title) {
            title = title || 'Error';
            toastr.error(message, title);
        }
    }

})();