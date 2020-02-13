(function() {
	'use strict';

	angular.module('App').controller('DetalheClienteController',
			DetalheClienteController);

	DetalheClienteController.$inject = [ '$http', '$scope', 'AuthService',
			'$stateParams', '$filter' ];

	function DetalheClienteController($http, $scope, AuthService, $stateParams,
			$filter) {
		var vm = this;
		vm.bioimpedancia = null;
		vm.openQuestionario = openQuestionario;
		vm.openBioimpedancia = openBioimpedancia;
		vm.openPlanoTerapeutico = openPlanoTerapeutico;
		vm.openAnamnese = openAnamnese;

		google.charts.load('current', {
			packages : [ 'corechart', 'line' ]
		});
		google.charts.setOnLoadCallback(drawGorduraVisceral);
		google.charts.setOnLoadCallback(drawGorduraPeso);

		function drawGorduraVisceral() {

			if (vm.bioimpedancia != null) {

				var data = new google.visualization.DataTable();
				data.addColumn('string', 'X');
				data.addColumn('number', '% Gord.');

				var rows = [];
				for (var i = 0; i < vm.bioimpedancia.length; i++) {
					var _bio = vm.bioimpedancia[i];
					var map = [];
					var data_avaliacao = $filter('date')(_bio.data_avaliacao,
							"dd/MM/yyyy");

					map.push(data_avaliacao);
					map.push(_bio.gordura_visceral);
					rows.push(map);
				}
				data.addRows(rows);

				var options = {
					title : 'Gordura Visceral',
					legend : {
						position : 'none'
					},
					width : 400,
					height : 200,
					hAxis : {
						title : 'Data'
					},
					vAxis : {
						title : 'Percentual'
					}
				};

				var chart = new google.visualization.LineChart(document
						.getElementById('chart_div'));

				chart.draw(data, options);
			}
		}

		function drawGorduraPeso() {

			if (vm.bioimpedancia != null) {

				var data = new google.visualization.DataTable();
				data.addColumn('string', 'X');
				data.addColumn('number', 'Kg.');

				var rows = [];
				for (var i = 0; i < vm.bioimpedancia.length; i++) {
					var _bio = vm.bioimpedancia[i];
					var map = [];
					var data_avaliacao = $filter('date')(_bio.data_avaliacao,
							"dd/MM/yyyy");

					map.push(data_avaliacao);
					map.push(_bio.peso);
					rows.push(map);
				}
				data.addRows(rows);

				var options = {
					title : 'Peso',
					legend : {
						position : 'none'
					},
					width : 400,
					height : 200,
					hAxis : {
						title : 'Data'
					},
					vAxis : {
						title : 'KG'
					}
				};

				var chart = new google.visualization.LineChart(document
						.getElementById('chart_div_2'));

				chart.draw(data, options);
			}
		}

		function openQuestionario() {
			$http.get('questionario-by-id-cliente/' + vm.id).then(
					function(response) {
						vm.questionario = response.data;
						console.log(vm.questionario);
					}, function(response) {
						vm.message = error.message;
					});
		}
		
		function openBioimpedancia() {
			$http.get('bioimpedancia-by-id-cliente/' + vm.id).then(
					function(response) {
						vm.bioimpedancia = response.data;
						drawGorduraVisceral();
						drawGorduraPeso();
						console.log(vm.bioimpedancia);
					}, function(response) {
						vm.message = error.message;
					});
		}
		
		function openPlanoTerapeutico() {
			$http.get('planto-terapeutico-by-id-cliente/' + vm.id).then(
					function(response) {
						vm.planto_terapeutico = response.data;
						console.log(vm.planto_terapeutico);
					}, function(response) {
						vm.message = error.message;
					});
		}
		
		function openAnamnese() {
			$http.get('anamnese-by-id-cliente/' + vm.id).then(
					function(response) {
						vm.anamnese = response.data;
						console.log(vm.anamnese);
					}, function(response) {
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
			
			openQuestionario();
		}

		init();
	}

})();
