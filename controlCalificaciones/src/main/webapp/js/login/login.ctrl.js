var loginModule = angular.module("loginModule");
//El controlador queda asociado al modulo
loginModule.controller('loginctrl',['$scope','$http','$state',function($scope, $http, $state){
        
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
           $scope.user;
           $scope.pass;
           //Es coordinador ¿?
           $scope.coordinadores.forEach(function(e,i,a){
                  console.log(e +'Estoy en el for each');
                  console.log(e.usuario.numeroId);
                  if(e.usuario.numeroId == $scope.user 
                  && e.usuario.pass == $scope.pass){
                   $scope.connect = false;
                   $scope.content = "Cerrar Sesión";
                   $state.go('coor'); 
               };
               });
           //Es Profesor ¿?
           $scope.profesores.forEach(function(e,i,a){
                  console.log(e +'Estoy en el for each');
                  console.log(e.usuario.numeroId);
                  if(e.usuario.numeroId == $scope.user 
                  && e.usuario.pass == $scope.pass){
                   $scope.connect = false;
                   $scope.content = "Cerrar Sesión";
                   $state.go('profe'); 
               };
           });
            //Es Estudiante
            $scope.estudiantes.forEach(function(e,i,a){
                  console.log(e +'Estoy en el for each');
                  console.log(e.usuario.numeroId);
                  if(e.usuario.numeroId == $scope.user 
                    && e.usuario.pass == $scope.pass){
                    $scope.connect = false;
                    $scope.content = "Cerrar Sesión";
                    $state.go('estudi'); 
               }
           });
           // es admin ¿?
           if('admin' == $scope.user 
                  && 'admin' == $scope.pass){
                   $scope.connect = false;
                   $scope.content = "Cerrar Sesión";
                   $state.go('admin'); 
               };

              
              };
           
///fin 
}]);


