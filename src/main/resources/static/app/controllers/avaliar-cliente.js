(function() {
	'use strict';

	angular.module('App').controller('AvaliarClienteController',
			AvaliarClienteController);

	AvaliarClienteController.$inject = [ '$http', '$scope', 'AuthService',
			'$stateParams' ];

	function AvaliarClienteController($http, $scope, AuthService, $stateParams) {
		var vm = this;
		vm.submit_bioimpedancia = submit_bioimpedancia;
		vm.submit_questionario = submit_questionario;
		vm.submit_plano_terapeutico = submit_plano_terapeutico;
		vm.submit_anamnese = submit_anamnese;
		vm.clearMessage = clearMessage;

		vm.bioimpedancia = {cliente : ''}
		vm.questionario = {cliente : ''}
		vm.planto_terapeutico = {cliente : ''}
		vm.anamnese = {cliente : ''}

		function clearMessage() {
			vm.message = null;
			vm.questionario.tipo_pele = null;
		}

		function submit_bioimpedancia() {
			vm.bioimpedancia.data_cadastro = new Date();
			vm.bioimpedancia.cliente = vm.cliente;
			$http.post('cadastrar_bioimpedancia', vm.bioimpedancia).success(
					function(res) {
						console.log(vm.bioimpedancia);
						vm.bioimpedancia = null;
						$scope.cadastrar_bioimpedancia.$setPristine();
						vm.message = "Cadastrado com sucesso!";
					}).error(function(error) {
				vm.message = error.message;
			});
		}

		function submit_questionario() {
			vm.questionario.data_cadastro = new Date();
			vm.questionario.cliente = vm.cliente;
			$http.post('cadastrar_questionario', vm.questionario).success(
					function(res) {
						console.log(vm.questionario);
						vm.questionario = null;
						$scope.cadastrar_questionario.$setPristine();
						vm.message = "Cadastrado com sucesso!";
					}).error(function(error) {
				vm.message = error.message;
			});
		}

		function submit_plano_terapeutico() {
			vm.planto_terapeutico.data_cadastro = new Date();
			vm.planto_terapeutico.cliente = vm.cliente;
			$http.post('cadastrar_planto_terapeutico', vm.planto_terapeutico)
					.success(function(res) {
						console.log(vm.planto_terapeutico);
						vm.planto_terapeutico = null;
						$scope.cadastrar_planto_terapeutico.$setPristine();
						vm.message = "Cadastrado com sucesso!";
					}).error(function(error) {
						vm.message = error.message;
					});
		}

		function submit_anamnese() {
			vm.anamnese.data_cadastro = new Date();
			vm.anamnese.cliente = vm.cliente;
			$http.post('cadastrar_anamnese', vm.anamnese).success(
					function(res) {
						console.log(vm.bioimpedancia);
						vm.anamnese = null;
						$scope.cadastrar_anamnese.$setPristine();
						vm.message = "Cadastrado com sucesso!";
					}).error(function(error) {
				vm.message = error.message;
			});
		}

		function init() {

			vm.id = $stateParams.id;

			$http.get('cliente-by-id/' + vm.id).then(function(response) {
				vm.cliente = response.data;
				console.log(vm.cliente);
			}, function(response) {
				vm.message = error.message;
			});
		}

		init();
	}

})();
