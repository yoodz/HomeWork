define(['angular', 'angular-ui-router', 'angular-resource', 'controllers/student'], function(angular) {
  var studentModule = angular.module("studentModule", ['controller',
    'ui.router', 'service'], angular.noop);
   studentModule.config([
    "$stateProvider", "$urlRouterProvider", function($stateProvider, $urlRouterProvider) {
      $urlRouterProvider.otherwise("/step1");
      return $stateProvider.state("step1", {
        url: "/step1",
        templateUrl: "../../source/html/student/home-page.html"
      }).state("step2", {
        url: "/step2",
        templateUrl: "../../source/html/student/unfinish-work.html"
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
  studentModule.run(function($rootScope, $state, $stateParams) {
  $rootScope.$state = $state;
  return $rootScope.$stateParams = $stateParams;
  });
  return studentModule;
});
