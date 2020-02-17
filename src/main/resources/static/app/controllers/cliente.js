(function() {
	'use strict';

	angular.module('App').controller('ClienteController', ClienteController);

	ClienteController.$inject = [ '$http', '$scope', 'AuthService', 'Upload', '$stateParams', 'AlertService' ];

	function ClienteController($http, $scope, AuthService, Upload, $stateParams, AlertService) {
		var vm = this;
		vm.submit = submit;
		vm.imageUpload = imageUpload;
		vm.imageBase64 = null;
		vm.cliente = {
			image : ''
		};

		function submit() {

			if (vm.cadastrar.$invalid) {
				angular.forEach(vm.cadastrar.$error, function(errorField) {
					for (var i = 0; i < errorField.length; i++) {
						errorField[i].$setTouched();
					}
				});
                AlertService.showError('Por favor, preencha os campos obrigatórios (*).');
				return;
			}

			if (!vm.editar && vm.id == 0) {
				$http.post('cadastrar', vm.cliente).then(function(res) {
					console.log(vm.cliente);
					vm.image = null;
					vm.cliente = null;
		            AlertService.showSuccess('Cadastrado com sucesso!');
				}, function(error) {
		            AlertService.showError(error.data.message);
				});
			} else {
				$http.put('alterar', vm.cliente).then(function(res) {
					console.log(vm.cliente);
					vm.image = null;
					vm.cliente = null;
		            AlertService.showSuccess('Alterado com sucesso');
				}, function(error) {
		            AlertService.showError(error.data.message);
				});

			}
		}
		;

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
