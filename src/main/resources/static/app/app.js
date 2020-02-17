angular.module('App', [ 'ui.router', //
						'LocalStorageModule', //
						'ngFileUpload', //
						'ngMessages', //
						'ngAnimate', //
						'toastr' //
						])
    


	.run(function (AuthService, $rootScope, $state, LocalStorage, $http) {
        $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
        	
        	if (LocalStorage.get('token') != undefined) {
        		 $http.defaults.headers.common['Authorization'] = 'Bearer ' + LocalStorage.get('token').token;
        	}
        	
        	if (!AuthService.user) {
                if (toState.name != 'login' && toState.name != 'register') {
                    event.preventDefault();
                    $state.go('login');
                }
            } else {
                if (toState.data && toState.data.role) {
                    var hasAccess = false;
                    for (var i = 0; i < AuthService.user.roles.length; i++) {
                        var role = AuthService.user.roles[i];
                        if (toState.data.role == role) {
                            hasAccess = true;
                            break;
                        }
                    }
                    if (!hasAccess) {
                        event.preventDefault();
                        $state.go('access-denied');
                    }

                }
            }
        });
    });