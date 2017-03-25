require.config({
    baseUrl : "/HomeWork/source/js/",
    paths : {
        'jQuery' : 'lib/jquery/dist/jquery.min',
        'angular' : 'lib/angular/angular.min',
        'angular-ui-router' : 'lib/angular-ui-router/release/angular-ui-router.min',
        'angular-resource' : 'lib/angular-resource/angular-resource.min',
        'jQuery-ui' : 'lib/jquery-ui/jquery-ui.min',
        'ng-file-upload-shim' : 'lib/ng-file-upload/angular-file-upload-shim.min',
        'ng-file-upload' : 'lib/ng-file-upload/angular-file-upload.min',
        'restangular': 'lib/restangular/dist/restangular.min',
        'lodash': 'lib/lodash/lodash.min',
        'uiBootstrap': 'lib/angular-bootstrap/ui-bootstrap.min',
        'uiBootstrapTpls': 'lib/angular-bootstrap/ui-bootstrap-tpls.min'
    },
    shim : {
        'jQuery' : {
            'exports' : 'jQuery'
        },
        'angular' : {
            'exports' : 'angular'
        },
        'jQuery-ui' : {
            'deps' : ['jQuery'],
            'exports' : 'jQuery-ui'
        },
        'angular-ui-router' : {
            'deps' : ['angular'],
            'exports' : 'angular-ui-router'
        },
        'angular-resource' : ['angular'],
        'ng-file-upload-shim' : {
            'deps' : ['angular'],
            'exports' : 'ng-file-upload-shim'
        },
        'ng-file-upload' : {
            'deps' : ['angular'],
            'exports' : 'ng-file-upload'
        },
        'restangular': ['angular', 'lodash'],
        'uiBootstrap': ['angular'],
        'uiBootstrapTpls': ['uiBootstrap']
    }
});

require(['angular', 'jQuery','angular-ui-router','angular-resource', 'modules/app/admin'], function(angular) {
    angular.bootstrap(document, ['adminModule']);
});
