define([ 'modules/controller','angular', 'services/admin'], function(controller) {
  return controller.controller('adminController', [
    '$scope','adminService', function($scope) {
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
      }

      return vm; 
    

    }
  ]);
});
