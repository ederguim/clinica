(function() {
	'use strict';

	angular.module('App').controller('PageNotFoundController', PageNotFoundController);

	PageNotFoundController.$inject = [ '$http', '$scope', 'AuthService' ];

	function PageNotFoundController($http, $scope, AuthService) {
		var vm = this;

	}

})();