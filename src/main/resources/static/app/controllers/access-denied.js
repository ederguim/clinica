(function() {
	'use strict';

	angular.module('App').controller('AccessDeniedController',
			AccessDeniedController);

	AccessDeniedController.$inject = [ '$http', '$scope', 'AuthService' ];

	function AccessDeniedController($http, $scope, AuthService) {
		var vm = this;

	}

})();
