(function() {
	'use strict';

	angular.module('App').controller('ClienteController', ClienteController);

	ClienteController.$inject = [ '$http', '$scope', 'AuthService', 'Upload', '$stateParams'];

	function ClienteController($http, $scope, AuthService, Upload, $stateParams) {
		var vm = this;
		vm.imageUpload = imageUpload;
		vm.imageBase64 = null;
		vm.cliente = {
				image : ''
		};

		vm.submit = function() {
			if (!vm.editar && vm.id == 0) {
				$http.post('cadastrar', vm.cliente).success(function(res) {
					console.log(vm.cliente);
					vm.image = null;
					vm.cliente = null;
					vm.confirmCPF = null;
					$scope.cadastrar.$setPristine();
					vm.message = "Cadastrado com sucesso!";
				}).error(function(error) {
					vm.message = error.message;
				});
			} else {
				$http.put('alterar', vm.cliente).success(function(res) {
					console.log(vm.cliente);
					vm.image = null;
					vm.cliente = null;
					vm.confirmCPF = null;
					$scope.cadastrar.$setPristine();
					vm.message = "Alterado com sucesso!";
				}).error(function(error) {
					vm.message = error.message;
				});
				
			}
		};
		
		function imageUpload(file) {
			var reader = new FileReader();
		    reader.onload = _handleReaderLoaded.bind(file);
		    reader.readAsBinaryString(file);
		}
		
		function _handleReaderLoaded(readerEvt) {
		     var binaryString = readerEvt.target.result;
		     vm.imageBase64 = btoa(binaryString);
		     vm.cliente.image = vm.imageBase64; 
		}
		
		function init() {
			
			vm.id = $stateParams.id;
            var edit = $stateParams.edit
            vm.editar = edit === 'true' ? true : false;
            
            if (vm.editar) {
            	$http.get('cliente-by-id/' + vm.id).then(function(response) {
    				vm.cliente = response.data;
    				console.log(vm.cliente);
    			}, function(response) {
    				vm.message = error.message;
    			});
            } else {
				$http.get("clientes").then(function(response) {
					vm.data = response.data;
				}, function(response) {
					vm.message = error.message;
				});
            }
		}

		init();
	}

})();
