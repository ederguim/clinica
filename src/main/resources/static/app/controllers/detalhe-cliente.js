(function() {
	'use strict';

	angular.module('App').controller('DetalheClienteController',
			DetalheClienteController);

	DetalheClienteController.$inject = [ '$http', '$scope', 'AuthService',
			'$stateParams' ];

	function DetalheClienteController($http, $scope, AuthService, $stateParams) {
		var vm = this;
		vm.openBioimpedancia = openBioimpedancia;

		google.charts.load('current', {
			packages : [ 'corechart', 'line' ]
		});
		google.charts.setOnLoadCallback(drawBasic);
		google.charts.setOnLoadCallback(drawBasic_2);

		function drawBasic() {

			var data = new google.visualization.DataTable();
			data.addColumn('string', 'X');
			data.addColumn('number', '% Gord.');

			data.addRows([[ '10/01/2020', 32 ], //
						  [ '02/03/2020', 27 ], //
						  [ '03/04/2020', 23 ], //
						  [ '04/05/2020', 17 ]]);

			var options = {
				title: 'Gordura Visceral',	
				legend: { position: 'none' },
				width: 400,
		        height: 200,
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
		
		function drawBasic_2() {

			var data = new google.visualization.DataTable();
			data.addColumn('string', 'X');
			data.addColumn('number', '% Gord.');

			data.addRows([[ '10/01/2020', 32 ], //
						  [ '02/03/2020', 27 ], //
						  [ '03/04/2020', 23 ], //
						  [ '04/05/2020', 17 ]]);

			var options = {
				title: 'Gordura Visceral',	
				legend: { position: 'none' },
				width: 400,
		        height: 200,
				hAxis : {
					title : 'Data'
				},
				vAxis : {
					title : 'Percentual'
				}
			};

			var chart = new google.visualization.LineChart(document
					.getElementById('chart_div_2'));

			chart.draw(data, options);
		}
		
		function openBioimpedancia (){
			
			$http.get('bioimpedancia-by-id-cliente/' + vm.id).then(function(response) {
				vm.bioimpedancia = response.data;
				console.log(vm.bioimpedancia);
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
		}

		init();
	}

})();
