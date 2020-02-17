(function() {
	'use strict';

	angular.module('App').controller('AvaliarClienteController',
			AvaliarClienteController);

	AvaliarClienteController.$inject = [ '$http', '$scope', 'AuthService',
			'$stateParams', 'AlertService' ];

	function AvaliarClienteController($http, $scope, AuthService, $stateParams, AlertService) {
		var vm = this;
		vm.hideImage = true;
		vm.submit_bioimpedancia = submit_bioimpedancia;
		vm.submit_questionario = submit_questionario;
		vm.submit_plano_terapeutico = submit_plano_terapeutico;
		vm.submit_anamnese = submit_anamnese;
		vm.clearMessage = clearMessage;

		vm.bioimpedancia = {
			cliente : ''
		}
		vm.questionario = {
			cliente : ''
		}
		vm.planto_terapeutico = {
			cliente : ''
		}
		vm.anamnese = {
			cliente : ''
		}

		function clearMessage() {
			vm.message = null;
			vm.questionario.tipo_pele = null;
		}

		function submit_bioimpedancia() {
			
			if (vm.cadastrar_bioimpedancia.$invalid) {
				angular.forEach(vm.cadastrar_bioimpedancia.$error, function(errorField) {
					for (var i = 0; i < errorField.length; i++) {
						errorField[i].$setTouched();
					}
				});
                AlertService.showError('Por favor, preencha os campos obrigatórios (*).');
				return;
			}

			vm.bioimpedancia.data_cadastro = new Date();
			vm.bioimpedancia.cliente = vm.cliente;
			$http.post('cadastrar_bioimpedancia', vm.bioimpedancia).then(
					function(res) {
						console.log(vm.bioimpedancia);
						vm.bioimpedancia = null;
						AlertService.showSuccess('Cadastrado com sucesso!');
					}, function(error) {
						AlertService.showError(error.data.message);
					});
		}

		function submit_questionario() {
			
			if (vm.cadastrar_questionario.$invalid) {
				angular.forEach(vm.cadastrar_questionario.$error, function(errorField) {
					for (var i = 0; i < errorField.length; i++) {
						errorField[i].$setTouched();
					}
				});
                AlertService.showError('Por favor, preencha os campos obrigatórios (*).');
				return;
			}
			
			vm.questionario.data_cadastro = new Date();
			vm.questionario.cliente = vm.cliente;
			$http.post('cadastrar_questionario', vm.questionario).then(
					function(res) {
						console.log(vm.questionario);
						vm.questionario = null;
						AlertService.showSuccess('Cadastrado com sucesso!');
					}, function(error) {
						AlertService.showError(error.data.message);
					});
		}

		function submit_plano_terapeutico() {
			
			if (vm.cadastrar_planto_terapeutico.$invalid) {
				angular.forEach(vm.planto_terapeutico.$error, function(errorField) {
					for (var i = 0; i < errorField.length; i++) {
						errorField[i].$setTouched();
					}
				});
                AlertService.showError('Por favor, preencha os campos obrigatórios (*).');
				return;
			}
			
			vm.planto_terapeutico.data_cadastro = new Date();
			vm.planto_terapeutico.cliente = vm.cliente;
			$http.post('cadastrar_planto_terapeutico', vm.planto_terapeutico)
					.then(function(res) {
						console.log(vm.planto_terapeutico);
						vm.planto_terapeutico = null;
						AlertService.showSuccess('Cadastrado com sucesso!');
					}, function(error) {
						AlertService.showError(error.data.message);
					});
		}

		function submit_anamnese() {
			
			if (vm.cadastrar_anamnese.$invalid) {
				angular.forEach(vm.cadastrar_anamnese.$error, function(errorField) {
					for (var i = 0; i < errorField.length; i++) {
						errorField[i].$setTouched();
					}
				});
                AlertService.showError('Por favor, preencha os campos obrigatórios (*).');
				return;
			}
			
			vm.anamnese.data_cadastro = new Date();
			vm.anamnese.cliente = vm.cliente;
			$http.post('cadastrar_anamnese', vm.anamnese).then(function(res) {
				console.log(vm.bioimpedancia);
				vm.anamnese = null;
				AlertService.showSuccess('Cadastrado com sucesso!');
			}, function(error) {
				AlertService.showError(error.data.message);
			});
		}

		function isHideImage() {
			if (vm.cliente.image != '') {
				vm.hideImage = false;
			}
		}

		function init() {

			vm.id = $stateParams.id;

			$http.get('cliente-by-id/' + vm.id).then(function(response) {
				vm.cliente = response.data;
				isHideImage();
			}, function(error) {
				AlertService.showError(error.data.message);
			});
		}

		init();
	}

})();
