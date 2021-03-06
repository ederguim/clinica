(function() {
	'use strict';

	angular.module('App').controller('UsersController', UsersController);

	UsersController.$inject = [ '$http', '$scope', 'AuthService' ];

	function UsersController($http, $scope, AuthService) {
		var vm = this;
		
        var edit = false;
        vm.buttonText = 'Create';
        var init = function () {
            $http.get('api/users').success(function (res) {
                vm.users = res;

                $scope.userForm.$setPristine();
                vm.message = '';
                vm.usuario = null;
                vm.buttonText = 'Create';

            }).error(function (error) {
                vm.message = error.message;
            });
        };
        vm.initEdit = function (usuario) {
            edit = true;
            vm.usuario = usuario;
            vm.message = '';
            vm.buttonText = 'Update';
        };
        vm.initAddUser = function () {
            edit = false;
            vm.usuario = null;
            $scope.userForm.$setPristine();
            vm.message = '';
            vm.buttonText = 'Create';
        };
        vm.deleteUser = function (appUser) {
            $http.delete('api/users/' + appUser.id).success(function (res) {
                vm.deleteMessage = "Success!";
                init();
            }).error(function (error) {
                vm.deleteMessage = error.message;
            });
        };
        var editUser = function () {
            $http.put('api/users', vm.usuario).success(function (res) {
            	vm.usuario = null;
                vm.confirmPassword = null;
                vm.userForm.$setPristine();
                vm.message = "Editting Success";
                init();
            }).error(function (error) {
                vm.message = error.message;
            });
        };
        var addUser = function () {
            $http.post('api/users', vm.usuario).success(function (res) {
            	vm.usuario = null;
                vm.confirmPassword = null;
                vm.userForm.$setPristine();
                vm.message = "User Created";
                init();
            }).error(function (error) {
                $scope.message = error.message;
            });
        };
        vm.submit = function () {
            if (edit) {
                editUser();
            } else {
                addUser();
            }
        };
        init();
	}

})();
