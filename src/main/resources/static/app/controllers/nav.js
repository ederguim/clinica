(function() {
	'use strict';

	angular.module('App').controller('NavController', NavController);

	NavController.$inject = ['$http', '$scope', 'AuthService', '$state', '$rootScope'];

	function NavController($http, $scope, AuthService, $state, $rootScope) {
		var vm = this;
		 $scope.$on('LoginSuccessful', function () {
	            vm.user = AuthService.user;
	        });
	        $scope.$on('LogoutSuccessful', function () {
	            $scope.user = null;
	        });
	        vm.logout = function () {
	            AuthService.user = null;
	            $rootScope.$broadcast('LogoutSuccessful');
	            $state.go('login');
	        };

	}

})();

