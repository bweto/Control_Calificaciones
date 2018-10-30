var loginModule = angular.module("loginModule");
//El controlador queda asociado al modulo
loginModule.controller('loginctrl',['$scope','$http','$state',function($scope, $http, $state){
        
        $scope.connect = false;
        $scope.content = "Iniciar Sesión";
        $scope.login = function(){
            
            if( $scope.connect) {
                $scope.connect = false;
                $scope.content = "Cerrar Sesión";
            }
            else{
               $state.go('inicio');
               $scope.connect = true;
               $scope.content = "Iniciar Sesión";
               
            }
        };
        
        $scope.close = function(){
            $scope.connect = false;
        };
       
       $scope.loginus = function(){
           $scope.user;
           $scope.pass;
           if($scope.user === "admin" && $scope.pass === "admin" ){
               $scope.connect = false;
               $scope.content = "Cerrar Sesión";
               $state.go('admin');
           }
       };
        
    }]);


