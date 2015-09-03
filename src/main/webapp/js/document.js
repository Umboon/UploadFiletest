var app = angular.module('document', []);
var app = angular.module('document', []).controller('documentController', function ($http, $scope) {
    $scope.file;
    $scope.document = {};
   
    
    $scope.saveDocument = function () {
        saveFile();
        saveDocument();

    };
    
    function saveDocument(){
         $http.post('/savedocument', $scope.document).success(function (data) {
         });
    }

    $scope.deleteDocument = function () {
        $http.post('/deletedocument', $scope.document).success(function (data) {

        });
    };


 


     function  saveFile() {
        var fd = new FormData();
        fd.append('files', $scope.file);
        $http.post('/savefile', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        });
    }

});


app.directive('fileModel', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
});
