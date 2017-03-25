define(['angular',
 'angular-ui-router',
  'uiBootstrap', 
  'uiBootstrapTpls',
  'angular-resource',
   'controllers/teacher'], function(angular) {
  var teacherModule = angular.module("teacherModule", ['controller',
    'service', 'ui.router', 'ui.bootstrap', 'ui.bootstrap.tpls'], angular.noop);
   teacherModule.config([
    "$stateProvider", "$urlRouterProvider", function($stateProvider, $urlRouterProvider) {
      $urlRouterProvider.otherwise("/step1");
      return $stateProvider.state("step1", {
        url: "/step1",
        templateUrl: "../../source/html/student/home-page.html"
      }).state("step2", {
        url: "/step2",
        templateUrl: "../../source/html/teacher/notice.html"
      }).state("step3", {
        url: "/step3",
        templateUrl: "../../source/html/student/manger-information.html"
      }).state("unFinish", {
        url: "/unFinish",
        templateUrl: "../../source/html/student/unfinish-tab.html"
      }).state("haveFinish", {
        url: "/haveFinish",
        templateUrl: "../../source/html/student/have-finish-tab.html"
      });
    }
  ]);
  teacherModule.run(function($rootScope, $state, $stateParams) {
  $rootScope.$state = $state;
  return $rootScope.$stateParams = $stateParams;
  });
  return teacherModule;
});
