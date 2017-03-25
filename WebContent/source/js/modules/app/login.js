define(['angular', 'controllers/login'], function(angular) {
  var loginModule = angular.module("loginModule", ['controller', 'service'], angular.noop);

  loginModule.run(function($rootScope , $interval){
      var i = 0 ;
      var timer = $interval(function(){
        if( i == 1) {
            $rootScope.background1boolean = true;
            $rootScope.background2boolean = false;
            $rootScope.background3boolean = false;
          }
          else if (i == 2) {
            $rootScope.background2boolean = true;
            $rootScope.background1boolean = false;
            $rootScope.background3boolean = false;
          }
          else if (i == 3) {
            $rootScope.background3boolean = true;
            $rootScope.background2boolean = false;
            $rootScope.background1boolean = false;
            i = 0;
          }
          i = i + 1 ;
          
      },3000)
  });

  return loginModule;
});
