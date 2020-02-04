(function() {
	'use strict';

	angular.module('App').controller('FooterController', FooterController);

	FooterController.$inject = [ '$http', '$scope', 'AuthService' ];

	function FooterController($http, $scope, AuthService) {
		var vm = this;

	}

})();