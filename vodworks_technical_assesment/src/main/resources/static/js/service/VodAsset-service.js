angular.module("VodWorkTecAssessmentApp")
    .factory('vodAssetsService', ['$q', '$resource', function ($q, $resource) {
        var vodAssets = $resource('../cal/', {id: '@id'}, {
            //cutom method definition
            getAssetsList: {
                method: 'GET',
                url: window.VodAppBaseUrl + '/assets/index',
                isArray: true
            }
        });
        return {
            'getAssetsList': function () {
                var defered = $q.defer();
                vodAssets.getAssetsList( function (response) {
                        defered.resolve(response);
                    },
                    function (error) {
                        defered.reject(error);
                    });
                return defered.promise;
            }
        }
    }]);