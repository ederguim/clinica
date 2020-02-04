(function() {
	'use strict';

	angular.module('App').controller('NavController', NavController);

	NavController.$inject = [ '$http', '$scope', 'AuthService', '$state', '$rootScope', 'LocalStorage'];

	function NavController($http, $scope, AuthService, $state, $rootScope, LocalStorage) {
		var vm = this;

		function init() {
			if (AuthService.user != undefined) {
				vm.user = AuthService.user;
				$scope.user = AuthService.user;
			}
		}

		$scope.$on('LoginSuccessful', function() {
			vm.user = AuthService.user;
			$scope.user = AuthService.user;
		});

		$scope.$on('LogoutSuccessful', function(event) {
			LocalStorage.remove('token');
			AuthService.user = null;
			$scope.user = null;
		});

		vm.logout = function() {
			LocalStorage.remove('token');
			AuthService.user = null;
			$rootScope.$broadcast('LogoutSuccessful');
			$state.go('login', {}, {reload : true});
		};

		init();
	}

})();
