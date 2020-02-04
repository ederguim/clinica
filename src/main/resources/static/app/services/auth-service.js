(function() {
	'use strict';

	angular.module('App').service('AuthService', AuthService);

	AuthService.$inject = ['LocalStorage'];

	function AuthService(LocalStorage) {
		return {
			user : (LocalStorage.get('token') != undefined) ? LocalStorage.get('token').user : null
		}
	}

})();