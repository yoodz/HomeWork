define([ 'modules/controller', 'angular', 'services/login'], function(controller) {
  return controller.controller('loginController', [
    '$http','$scope', 'loginService', '$window', function($http, $scope, loginService, $window) {
      var vm = this;
      var result = "";
      vm.nameEmptyError = "username is not empty";
      vm.nameLengthError = "username is require in 4~20";
      vm.passwordEmptyError = "password is not empty";
      vm.passwordLengthError = "password is require in 4~20";
      vm.hello = "hehe";
      vm.validation = function () {
        vm.userData = {
          userName : vm.userName,
          password : vm.password
        }
        return loginService.validation(vm.userData).then(function(result) {
           isSuccess = result.data;
           if (isSuccess.role == null) {
             vm.isShowError = true;
             vm.ErrorMessage = "用户名或者密码错误"
           } else if (isSuccess.role == 'student') {
              var url = '../student/turn';
              return $window.location.href = url;
           } else if (isSuccess.role == 'teacher') {
             var url = '../teacher/turn';
              return $window.location.href = url;
           } else if (isSuccess.role == 'admin') {
             var url = '../admin/turn';
              return $window.location.href = url;
           }
        });
      };
      return vm;
    } 
  ]);
});
