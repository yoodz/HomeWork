define([ 'modules/controller',
         'angular', 
         'jQuery',
         'services/teacher'
          ], function(controller, angular, $, params) {
    controller.controller('teacherController', [
    '$scope', '$http', '$modal', 'teacherService','$timeout', function($scope, $http, $modal, teacherService, $timeout) {
      var vm = this;
      vm.showDropDowm = function () {
        vm.isShowDropDown = true;
      };

      vm.displayDropDowm = function () {
        vm.isShowDropDown = false;
      };

      vm.logout = function () {
        url = '/HomeWork/page/user/logout';
        window.location.href = url;
      };

      vm.create = function() {
        var modalInstance = $modal.open({
          templateUrl: 'create.html',
          controller: 'createCtrl',
          resolve: {
            modalData: function() {} 
          }
        }).result.then(function(data) {
          if (data) {
          }
        });
      };




      _init = function() {
        


      }



      _init();
      return vm;
    }
  ]);
  
  return controller.controller("createCtrl", [
    '$scope', '$modalInstance', 'modalData', 'teacherService', function($scope, $modalInstance, modalData, teacherService) {
      var vm;
      vm = $scope;

      vm.close = function() {
        $modalInstance.dismiss();
      };
      vm.cancel = function() {
        $modalInstance.dismiss();
      };
      return vm.submit = function() {
        param = {
          content: vm.content
        };
        teacherService.addAd(param);
        $modalInstance.dismiss();
      };
    }
  ]);
});
