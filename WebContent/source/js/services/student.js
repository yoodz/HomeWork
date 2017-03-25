define(['modules/service'], function(service) {
    return service.factory("studentService", ['Restangular',
         function(Restangular) {
         var studentService;
         studentService = Restangular.all('/page/student');

         
        return studentService;
    }]);
});