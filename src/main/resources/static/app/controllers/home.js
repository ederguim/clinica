(function() {
	'use strict';

	angular.module('App').controller('HomeController', HomeController);

	HomeController.$inject = [ '$http', '$scope', 'AuthService' ];

	function HomeController($http, $scope, AuthService) {
		var vm = this;
		vm.user = AuthService.user
	}

})();