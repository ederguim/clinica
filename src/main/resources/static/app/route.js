angular.module('App').config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/page-not-found');
    $stateProvider.state('nav', {
        abstract: true,
        url: '',
        views: {
            'nav@': {
                templateUrl: 'app/views/nav.html',
                controller: 'NavController as vm'
            }
        }
    })
    .state('footer', {
        abstract: true,
        url: '',
        views: {
            'footer@': {
                templateUrl: 'app/views/footer.html',
                controller: 'FooterController as vm'
            }
        }
    })
    .state('login', {
        parent: 'nav',
        url: '/login',
        views: {
            'content@': {
                templateUrl: 'app/views/login.html',
                controller: 'LoginController as vm'
            }
        }
    }).state('users', {
        parent: 'nav',
        url: '/users',
        data: {
            role: 'ADMIN'
        },
        views: {
            'content@': {
                templateUrl: 'app/views/users.html',
                controller: 'UsersController as vm',
            }
        }
    }).state('home', {
        parent: 'nav',
        url: '/',
        views: {
            'content@': {
                templateUrl: 'app/views/home.html',
                controller: 'HomeController as vm'
            }
        }
    }).state('page-not-found', {
        parent: 'nav',
        url: '/page-not-found',
        views: {
            'content@': {
                templateUrl: 'app/views/page-not-found.html',
                controller: 'PageNotFoundController as vm'
            }
        }
    }).state('access-denied', {
        parent: 'nav',
        url: '/access-denied',
        views: {
            'content@': {
                templateUrl: 'app/views/access-denied.html',
                controller: 'AccessDeniedController'
            }
        }
    })
    .state('cliente', {
        parent: 'nav',
        url: '/cliente',
        views: {
            'content@': {
                templateUrl: 'app/views/cliente.html',
                controller: 'ClienteController as vm'
            }
        }
    })
    .state('register', {
        parent: 'nav',
        url: '/register',
        views: {
            'content@': {
                templateUrl: 'app/views/register.html',
                controller: 'RegisterController as vm'
            }
        }
    });
});
