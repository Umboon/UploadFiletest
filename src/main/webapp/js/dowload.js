angular.module('dowload', []);
angular.module('dowload', []).controller('dowloadController', function ($http, $scope) {

    $scope.lodeDocument = {};

    function getDocument() {
        $http.get('/getdocument').success(function (data) {
            $scope.lodeDocument = data;
        });
    }
    getDocument();

     $scope.dowload = function (id){
         console.log(id);
         console.log(id.file.id);
         $http.post('/dowloaddocument',id.file);
     };


});


