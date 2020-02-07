(function() {
	'use strict';

	angular.module('App').controller('RegisterController', RegisterController);

	RegisterController.$inject = [ '$http', '$scope', 'AuthService' ];

	function RegisterController($http, $scope, AuthService) {
		var vm = this;
		
		vm.submit = function () {
            $http.post('register', vm.usuario).success(function (res) {
                vm.usuario = null;
                vm.confirmPassword = null;
                $scope.register.$setPristine();
                vm.message = "Cadastrado com sucesso!";
            }).error(function (error) {
                vm.message = error.message;
            });
        };
	}

})();
