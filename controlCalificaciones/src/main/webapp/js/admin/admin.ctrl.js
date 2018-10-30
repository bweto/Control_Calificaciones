var adminModule = angular.module("adminModule");
//El controlador queda asociado al modulo
adminModule.controller('adminctrl',['$scope','$http','$state',function($scope, $http, $state){
      //obtener tipo ID
      $scope.tipoid = function(){
        $scope.tipoids = new Array();
        $http.get('api/tipoId').then(function (response) {
            $scope.tipoids = response.data;
            $state.go('tipoid');
        }, function (error) {
            console.log(error);
        });
    };
      // Obtener roles
      $scope.rol = function(){
          $scope.roles = new Array();
          $http.get('api/rol').then(function(response){
              $scope.roles = response.data;
              $state.go('roles');
          },function(err){
              console.log(err);
          });
      };
      //Obtener Facultades
      $scope.facultad = function(){
          $scope.facultades = new Array();
          $http.get('api/facultad').then(function(response){
              $scope.facultades = response.data;
              $state.go('facultades');
          },function(err){
              console.log(err);
          });
      };
      //Obtener Programas
      $scope.programa = function(){
          $scope.programas = new Array();
          $http.get('api/programa').then(function(response){
              $scope.programas = response.data;
              $state.go('programas');
          },function(err){
              console.log(err);
          });
      };
      //obtener niveles academicos
      $scope.nivelA = function(){
          $scope.niveles = new Array();
          $http.get('api/nivelAcademico').then(function(response){
              $scope.niveles = response.data;
              $state.go('niveles');
          },function(err){
              console.log(err);
          });
      };
      //obtener área
      $scope.area = function(){
          $scope.areas = new Array();
          $http.get('api/area').then(function(response){
              $scope.areas = response.data;
              $state.go('areas');
          },function(err){
              console.log(err);
          });
      };
      //Obtener Grupos
      $scope.grupo = function(){
          $scope.grupos = new Array();
          $http.get('api/grupo').then(function(response){
              $scope.grupos = response.data;
              $state.go('grupos');
          },function(err){
              console.log(err);
          });
      };
      //obtener cursos
      $scope.curso = function(){
          $scope.cursos = new Array();
          $http.get('api/curso').then(function(response){
              $scope.cursos = response.data;
              $state.go('cursos');
          },function(err){
              console.log(err);
          });
      };
      //Obtener Estados
      $scope.estado = function(){
          $scope.estados = new Array();
          $http.get('api/estado').then(function(response){
              $scope.estados = response.data;
              $state.go('estados');
          },function(err){
              console.log(err);
          });
      };
      //Obtener Usuarios
      $scope.usuario = function(){
          $scope.usuarios = new Array();
          $http.get('api/usuarios').then(function(response){
              $scope.usuarios = response.data;
              $state.go('usuarios');
          },function(err){
              console.log(err);
          });
      };
      //Obtener Profesor
      $scope.profesor = function(){
          $scope.profesores = new Array();
          $http.get('api/profesor').then(function(response){
              $scope.profesores = response.data;
              $state.go('profesores');
          },function(err){
              console.log(err);
          });
      };
      //Obtener Coordinador
      $scope.coordinador = function(){
          $scope.coordinadores = new Array();
          $http.get('api/coordinador').then(function(response){
              $scope.coordinadores = response.data;
              $state.go('coordinadores');
          },function(err){
              console.log(err);
          });
      };
      //Obtener Estudiantes
      $scope.estudiante = function(){
          $scope.estudiantes = new Array();
          $http.get('api/estudiante').then(function(response){
              $scope.estudiantes = response.data;
              $state.go('estudiantes');
          },function(err){
              console.log(err);
          });
      };
      //
    }]);


