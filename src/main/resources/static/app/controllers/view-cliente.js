(function() {
	'use strict';

	angular.module('App').controller('ViewClienteController', ViewClienteController);

	ViewClienteController.$inject = [ '$http', '$scope', 'AuthService', '$stateParams'];

	function ViewClienteController($http, $scope, AuthService, $stateParams) {
		var vm = this;
		vm.hideImage = true;

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
			}, function(response) {
				vm.message = error.message;
			});
		}

		init();
	}

})();
