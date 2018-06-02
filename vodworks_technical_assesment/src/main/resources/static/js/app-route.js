angular
    .module('VodWorkTecAssessmentApp')
    .config(routesConfig);

/** @ngInject */
function routesConfig($routeProvider) {

    $routeProvider.when('/', {
        templateUrl: 'views/VodAssetsList.html'
    }).otherwise({
        redirectTo: '/'
    });
};