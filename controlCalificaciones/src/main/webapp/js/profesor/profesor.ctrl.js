var profesorModule = angular.module("profesorModule");
//El controlador queda asociado al modulo
profesorModule.controller('profesorctrl',['$scope','$http','$state','$route','$rootScope',function($scope, $http, $state,$route,$rootScope){
   //variables
    $scope.estudiante = {};
    $scope.profesor = {};
    $scope.ite = {};
    $scope.grupo = {};
    $scope.generos =['Femenino','Masculino'];
    $scope.cantidad = [1,2,3,4,5,6];
    $scope.roles = new Array();
    $scope.programas = new Array();
    $scope.areas = new Array();
    $scope.tiposId = new Array();
    $scope.profes = new Array();
    //área para los porfesores
    $http.get('api/area').then(function (response) {
            $scope.areas = response.data;
        }, function (error) {
            console.log(error);
        });
   //obtenerTipoIDs
        $http.get('api/tipoId').then(function (response) {
            $scope.tiposId = response.data;
        }, function (error) {
            console.log(error);
        });
    //obtener programas
          $http.get('api/programa').then(function(response){
              $scope.programas = response.data;
          },function(err){
              console.log(err);
          });
          //obtener profesores
          $http.get('api/profesor').then(function(response){
              $scope.profes = response.data;
          },function(err){
              console.log(err);
          });
    //obtener rol
       $http.get('api/rol/').then(function(response){
           $scope.roles = response.data;
       }),
       function(err){
         console.log(err);  
       }; 
   //obtener estudiante por id
   var id = $state.params.id;
   $scope.estudiante = {};
   $scope.profesor ={};
   $scope.grupo = {};
   if(id){
       $http.get('api/estudiante/'+id).then(function(response){
           $scope.estudiante = response.data;
       }),
       function(err){
         console.log(err);  
       };
   }else if(id){
    $http.get('api/profesor/'+id).then(function(response){
           $scope.profesor = response.data;
       }),
       function(err){
         console.log(err);  
       };   
   }else if(id){
      $http.get('api/grupo/'+id).then(function(response){
           $scope.grupo = response.data;
       }),
       function(err){
         console.log(err);  
       };  
   }
   
      //Crear Estudiantes
      $scope.crear = function(){
          $state.go('crearEstudiante');
      };
      //------------Crear un nuevo Estudiante ---------------
      $scope.crearEstudiante = function(){  
       if($scope.estudiante.usuario
          && $scope.estudiante.cantidadMaterias
          && $scope.estudiante.codigoEstudiante
          && $scope.estudiante.programa){
          $scope.obj=JSON.parse(angular.toJson($scope.estudiante));
          $http.post('api/usuarios',JSON.stringify($scope.obj.usuario)).then(function(response){
            $scope.ite = response.data;
            $scope.ite.tipoId.idTipoId = $scope.obj.usuario.tipoId.idTipoId;
            $scope.ite.numeroId = $scope.obj.usuario.numeroId;
            $scope.obj.usuario = $scope.ite;
            nuevoEstudiante();
          },
          //creado de forma exitosa el usuario
          function(err){
              console.log(err);
          });
       };
   };
   
   //funcion crear estudiante
   function nuevoEstudiante(){
      $http.post('api/estudiante',JSON.stringify($scope.obj)).then(function(response){
          $state.go('verEstudiantes');
          $scope.obj ={};
                        },function(err){
                            console.log(err);
                        }); 
   }
   //Eliminar estudiante
   $scope.eliminar = function (estudiante) {
            var id = estudiante.usuario.idUsuario;
            $http.delete('api/estudiante/' + estudiante.idEstudiante).then(function (response) {
                $state.reload();
            }, function (error) {
                console.log(error);
            });
            eliminarU(id);
        };
  //Eliminar usuario
  $scope.eliminarU = function (id) {
            $http.delete('api/usuarios/' + id).then(function (response) {
            }, function (error) {
                console.log(error);
            });
        };
  //cierre de creación de estudiante
  $scope.show = function() {
      $scope.activo = 1;
    };
    
   //actualizar
   $scope.actualizarEstudiante = function(){
      if($scope.estudiante.usuario
          && $scope.estudiante.cantidadMaterias
          && $scope.estudiante.codigoEstudiante
          && $scope.estudiante.programa){
         $scope.actualizarUsuario($scope.estudiante.usuario);
         $scope.actualizarPrograma($scope.estudiante.programa);
         $http.put('api/estudiante/'+id,JSON.stringify($scope.estudiante)).then(function(response){
            $scope.estudiante ={};
            $scope.obtenerEstudiantes();
            $scope.reloadRoute();
         },function(err){
             console.log(err);
         }); 
       }
       
   };
   
   $scope.reloadRoute = function() {
    $state.reload();
};
   //Actualiar usuario
   $scope.actualizarUsuario = function(usuario){
      if(usuario){
         $http.put('api/usuarios/'+usuario.idUsuario,JSON.stringify(usuario)).then(function(response){
         },function(err){
             console.log(err);
         }); 
       }
   };
   //Actualizar Programa
   $scope.actualizarPrograma = function(programa){
      if(programa){
         $http.put('api/programa/'+programa.idPrograma,JSON.stringify(programa)).then(function(response){
         },function(err){
             console.log(err);
         }); 
       }
   };
   //obtener todos los Estudiantes
  $scope.obtenerEstudiantes = function (){
          $scope.estudiantes = new Array();
          $http.get('api/estudiante').then(function(response){
              $scope.estudiantes = response.data;
//              console.log($scope.estudiantes);
              $state.go('verEstudiantes');
          },function(err){
              console.log(err);
          });
      };
      //crear Profesor
      $scope.crearP = function(){
          $state.go('crearProfesor');
      };
      
      $scope.crearProfesor = function(){  
       if($scope.profesor.usuario
          && $scope.profesor
          && $scope.profesor.area
          ){
          $scope.obj=JSON.parse(angular.toJson($scope.profesor));
          $http.post('api/usuarios',JSON.stringify($scope.obj.usuario)).then(function(response){
              //buscamos el ultimo usuario creado
               console.log($scope.obj);
              console.log($scope.obj + '\n creo el usuario');
            $scope.ite = response.data;
            $scope.ite.tipoId.idTipoId = $scope.obj.usuario.tipoId.idTipoId;
            $scope.ite.usuario.numeroId = $scope.obj.usuario.numeroId;
            $scope.obj.usuario = $scope.ite;
            nuevoProfesor($scope.obj);
          },
          //creado de forma exitosa el usuario
          function(err){
              console.log($scope.obj + '\n no creo el usuario');
              console.log(err);
          });
       };
   };
   //Eliminar Profesor
   $scope.eliminarP = function (profesor) {
            var id = profesor.usuario.idUsuario;
            $http.delete('api/profesor/' + profesor.idProfesor).then(function (response) {
                //Recargar la pag
                $state.reload();
            }, function (error) {
                console.log(error);
            });
            eliminarU(id);
        };
    //nuevo Profesor
    function nuevoProfesor(val){
      $http.post('api/profesor',JSON.stringify(val)).then(function(response){
          console.log(val + '\n creo el proefe');
          $state.go('verProfesor');
          $scope.obj ={};
                        },function(err){
                            console.log(val);
                            console.log(val + '\n no creo el proefe'); 
                            console.log(err);
                        }); 
   }  
    //obtener todos los Profesores*************************************************
  $scope.obtenerProfe = function (){
          $scope.profesores = new Array();
          $http.get('api/profesor').then(function(response){
              $scope.profesores = response.data;
              $scope.profesores.forEach(function(e,i,a){
                  console.log($rootScope.user +" "+$rootScope.pass );
                  if(e.usuario.numeroId == $rootScope.user 
                  && e.usuario.pass == $rootScope.pass){
//                  console.log($rootScope.userActive);
//                  $scope.profesor = $rootScope.userActive;
                    console.log(e);
                    $scope.profes = e;
                  $state.go('verIProfesor');
               };
           });
              
          },function(err){
              console.log(err);
          });
      };
      //actualizar Profesores
      $scope.actualizarProfe = function(){
      if($scope.profesor){
         $scope.actualizarUsuario($scope.profesor.usuario);
         $http.put('api/profesor/'+id,JSON.stringify($scope.profesor)).then(function(response){
           $scope.reloadRoute();
         },function(err){
             console.log(err);
         }); 
       }
   };
      //----------------Creacion de cursos y grupos---------------------
      $scope.crearG = function(){
          $state.go('crearGrupo');
      };
      
      $scope.crearGrupo = function(){  
       if($scope.grupo.curso
          && $scope.grupo.profesor
          && $scope.grupo
          ){
          $scope.obj=JSON.parse(angular.toJson($scope.grupo));
          $http.post('api/curso',JSON.stringify($scope.obj.curso)).then(function(response){
              //buscamos el ultimo usuario creado
               console.log($scope.obj);
              console.log($scope.obj + '\n creo materia');
            $scope.obj.curso = response.data;
            nuevoGrupo($scope.obj);
          },
          //creado de forma exitosa el usuario
          function(err){
              console.log($scope.obj + '\n no creo curso');
              console.log(err);
          });
       };
   };
    function nuevoGrupo(val){
      $http.post('api/grupo',JSON.stringify(val)).then(function(response){
          console.log(val + '\n creo el proefe');
          $state.go('verGrupo');
          $scope.obj ={};
                        },function(err){
                            console.log(val);
                            console.log(val + '\n no creo grupo'); 
                            console.log(err);
                        }); 
   }  
    //obtener todos los Profesores
  $scope.obtenerGrupos = function (){
          $scope.grupos = new Array();
          $http.get('api/grupo').then(function(response){
              $scope.grupos = response.data;
              $state.go('verGrupos');
          },function(err){
              console.log(err);
          });
      };
      //Actualizar Grupo
      $scope.actualizarGrupo = function(){
      if($scope.grupo.curso
          && $scope.grupo.profesor
          && $scope.grupo){
         $http.put('api/grupo/'+id,JSON.stringify($scope.grupo)).then(function(response){
            actualizarCurso(response.data.curso);
            $state.go('crearGrupo');
         },function(err){
             console.log(err);
         }); 
       }
   };
   //Actualizar curso
    $scope.actualizarCurso = function(curso){
      if(curso){
         $http.put('api/curso/'+curso.idCurso,JSON.stringify(curso)).then(function(response){
            $scope.grupo ={};
         },function(err){
             console.log(err);
         }); 
       }
   };
      //fin
    }]);


