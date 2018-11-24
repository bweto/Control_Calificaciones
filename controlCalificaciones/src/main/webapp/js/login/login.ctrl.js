var loginModule = angular.module("loginModule");
//El controlador queda asociado al modulo
loginModule.controller('loginctrl',['$scope','$http','$state','$rootScope',function($scope, $http, $state,$rootScope){
        
        $scope.connect = false;
        $scope.content = "Iniciar Sesión";
        $scope.coordinadores = new Array();
        $scope.profesores = new Array();
        $scope.estudiantes = new Array();
        
        //login 
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
        
        //obtener
        function obtener(){
          $http.get('api/estudiante').then(function(response){
              $scope.estudiantes = response.data;
          },function(err){
              console.log(err);
          });
      
          $http.get('api/coordinador').then(function(response){
              $scope.coordinadores = response.data;
          },function(err){
              console.log(err);
          });
 
     
          $http.get('api/profesor').then(function(response){
              $scope.profesores = response.data;
          },function(err){
              console.log(err);
          });
      };

        //cerrar
        $scope.close = function(){
            $scope.connect = false;
        };
       
       //
       obtener();
       $scope.loginus = function(){
           $rootScope.user;
           $rootScope.pass;
           //Es coordinador ¿?
           $scope.coordinadores.forEach(function(e,i,a){
                  if(e.usuario.numeroId == $rootScope.user 
                  && e.usuario.pass == $rootScope.pass){
                   $scope.connect = false;
                   $scope.content = "Cerrar Sesión";
                   $rootScope.userActive = e;
                   $state.go('coor'); 
               };
               });
           //Es Profesor ¿?
           $scope.profesores.forEach(function(e,i,a){
                  if(e.usuario.numeroId == $rootScope.user 
                  && e.usuario.pass == $rootScope.pass){
                   $scope.connect = false;
                   $scope.content = "Cerrar Sesión";
                   $rootScope.userActive = e;
                   $state.go('profe'); 
               };
           });
            //Es Estudiante
            $scope.estudiantes.forEach(function(e,i,a){
                  if(e.usuario.numeroId == $rootScope.user
                    && e.usuario.pass == $rootScope.pass){
                    $scope.connect = false;
                    $scope.content = "Cerrar Sesión";
                    $rootScope.userActive = e;
                    $state.go('estu'); 
               }
           });
           // es admin ¿?
           if('admin' == $rootScope.user 
                  && 'admin' == $rootScope.pass){
                   $scope.connect = false;
                   $scope.content = "Cerrar Sesión";
                   $state.go('admin'); 
               };

              
              };
           
///fin 
}]);


