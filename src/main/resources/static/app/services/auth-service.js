//angular.module('App').service('AuthService', function() {
//	return {
//		user : null
//	}
//});

(function() {
	'use strict';

	angular.module('App').service('AuthService', AuthService);

	AuthService.$inject = [];

	function AuthService() {
		return {
			user : null
		}

	}

})();