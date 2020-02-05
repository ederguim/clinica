(function() {
	'use strict';

	angular.module('App').controller('ClienteController', ClienteController);

	ClienteController.$inject = [ '$http', '$scope', 'AuthService' ];

	function ClienteController($http, $scope, AuthService) {
		var vm = this;
		vm.upload = upload;
		
		vm.submit = function () {
            $http.post('cadastrar', vm.cliente).success(function (res) {
                vm.cliente = null;
                vm.confirmCPF = null;
                $scope.cadastrar.$setPristine();
                vm.message = "Cadastrado com sucesso!";
            }).error(function (error) {
                vm.message = error.message;
            });
        };
        
        function upload() {
        	console.log('entrou aqui')
        }
	}

})();
