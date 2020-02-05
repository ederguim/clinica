(function() {
	'use strict';

	angular.module('App').controller('HomeController', HomeController);

	HomeController.$inject = [ '$http', '$scope', 'AuthService' ];

	function HomeController($http, $scope, AuthService) {
		var vm = this;
		vm.user = AuthService.user
		vm.data = null;

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