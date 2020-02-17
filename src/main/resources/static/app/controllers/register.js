(function() {
	'use strict';

	angular.module('App').controller('RegisterController', RegisterController);

	RegisterController.$inject = [ '$http', '$scope', 'AuthService', 'AlertService' ];

	function RegisterController($http, $scope, AuthService, AlertService) {
		var vm = this;
		
		vm.submit = function () {
            $http.post('register', vm.usuario).then(function(res) {
                vm.usuario = null;
                vm.confirmPassword = null;
                $scope.register.$setPristine();
	            AlertService.showSuccess('Registrado com sucesso!');
            }, function (error) {
                vm.message = error.message;
	            AlertService.showError('Paciente já cadastrado!');

            });
        };
	}

})();
