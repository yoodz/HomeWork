define(['modules/service'], function(service) {
    return service.factory("teacherService", ['Restangular',
         function(Restangular) {
         var teacherService;
         teacherService = Restangular.all('/page');
         
        teacherService.addAd = function (params) {
            return this.customPOST(params, "/announce/add");
        };

        return teacherService;
    }]);
});