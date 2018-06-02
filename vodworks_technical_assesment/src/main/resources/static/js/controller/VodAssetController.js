angular
    .module('VodWorkTecAssessmentApp')
    .controller('vodAssetsController', vodAssetsControllerFunction);

function vodAssetsControllerFunction(vodAssetsService) {

    var vm = this;

    vodAssetsService.getAssetsList().then(function (response) {
        vm.assetsList = response;
    }, function (error) {
    });
}