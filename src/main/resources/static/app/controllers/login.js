(function() {
	'use strict';

	angular.module('App').controller('LoginController', LoginController);

	LoginController.$inject = [ '$http', '$scope', '$state', 'AuthService',
			'$rootScope', 'LocalStorage' ];

	function LoginController($http, $scope, $state, AuthService, $rootScope,
			LocalStorage) {
		var vm = this;
		vm.login = login;

		function login() {
			$http({
				url : 'authenticate',
				method : "POST",
				params : {
					username : vm.username,
					password : vm.password
				}
			})
					.then(
							function(res) {
								$scope.password = null;
								if (res.data.token) {
									vm.message = '';
									$http.defaults.headers.common['Authorization'] = 'Bearer '
											+ res.data.token;
									AuthService.user = res.data.user;
									LocalStorage.set('token', res.data);
									$rootScope.$broadcast('LoginSuccessful');
									$state.go('home');
								} else {
									vm.message = 'Falha na autenticação!';
								}
							}, function(res) {
								vm.message = 'Falha na autenticação!';
							});
		}
	}

})();
