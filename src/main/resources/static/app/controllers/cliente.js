(function() {
	'use strict';

	angular.module('App').controller('ClienteController', ClienteController);

	ClienteController.$inject = [ '$http', '$scope', 'AuthService', 'Upload'];

	function ClienteController($http, $scope, AuthService, Upload) {
		var vm = this;
		vm.imageUpload = imageUpload;

		vm.submit = function() {
			$http.post('cadastrar', vm.cliente).success(function(res) {
				console.log(vm.cliente);
				vm.cliente = null;
				vm.confirmCPF = null;
				$scope.cadastrar.$setPristine();
				vm.message = "Cadastrado com sucesso!";
			}).error(function(error) {
				vm.message = error.message;
			});
		};
		
		function imageUpload(file) {
			console.log(file)
			console.log(vm.image)
		}
		
		function init() {
			$http.get("clientes").then(function(response) {
				vm.data = response.data;
			}, function(response) {
				vm.message = error.message;
			});
		}

		init();
	}

})();
