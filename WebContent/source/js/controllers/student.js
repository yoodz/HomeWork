define([ 'modules/controller','angular', 'services/student', 'services/login'], function(controller) {
  return controller.controller('studentController', [
    '$scope','studentService', 'loginService', function($scope, studentService, loginService) {
    	$scope.greeting = 'this is the student page';
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
