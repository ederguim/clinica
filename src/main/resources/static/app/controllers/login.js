(function() {
	'use strict';

	angular.module('App').controller('LoginController', LoginController);

	LoginController.$inject = [ '$http', '$scope', '$state', 'AuthService',
			'$rootScope' ];

	function LoginController($http, $scope, $state, AuthService, $rootScope) {
		var vm = this;
		vm.login = function() {
			$http({
				url : 'authenticate',
				method : "POST",
				params : {
					username : vm.username,
					password : vm.password
				}
			})
					.success(
							function(res) {
								$scope.password = null;
								if (res.token) {
									vm.message = '';
									$http.defaults.headers.common['Authorization'] = 'Bearer '
											+ res.token;

									AuthService.user = res.user;
									$rootScope.$broadcast('LoginSuccessful');
									$state.go('home');
								} else {
									vm.message = 'Authetication Failed !';
								}
							}).error(function(error) {
						vm.message = 'Authetication Failed !';
					});

		}
	}

})();
