define(['angular', 'restangular' ], function(angular, restangular) {
  var service;
  service = angular.module('service', ['restangular']);
  service.run([
    'Restangular', function(Restangular) {
      Restangular.setBaseUrl("/HomeWork");
    }
  ]);
  return service;
});
