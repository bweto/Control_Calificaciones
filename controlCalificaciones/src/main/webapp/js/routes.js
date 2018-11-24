var app = angular.module("controlNotas");

//revisa la configuracion de la aplicacion mediante el manejo de estados de las
//rutas
app.config([
            "$stateProvider",
            "$urlRouterProvider",
            function ($stateProvider,$urlRouterProvider){
                
                $urlRouterProvider.otherwise('/');
                //Raiz
                $stateProvider.state("inicio",{
                    url: '/',
                    views:{
                        mainView:{
                            templateUrl:'./js/inicio/inicio.html',
                            controller: 'inicioctrl'
                        }
                    }       
                });
                //-------------vistas del administrador---------------
                //administrador
                $stateProvider.state("admin",{
                    url: '/admin',
                    views:{
                        mainView:{
                            templateUrl: './js/admin/admin.html',
                            controller: 'adminctrl'
                            }  
                    }
                });
                //administrador/tipoid
                $stateProvider.state("tipoid",{
                    url:'/tipoId',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/tipoid.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                //administrador/roles
                $stateProvider.state("roles",{
                    url:'/roles',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/roles.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                //admini/facultades
                $stateProvider.state("facultades",{
                    url:'/facultades',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/facultades.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                //admin/programas
                $stateProvider.state("programas",{
                    url:'/programas',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/programas.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                //admin/niveles
                $stateProvider.state("niveles",{
                    url:'/nivelesAcademicos',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/niveles.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                //admin/areas
                $stateProvider.state("areas",{
                    url:'/areas',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/areas.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                //admin/grupos
                $stateProvider.state("grupos",{
                    url:'/grupos',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/grupos.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                //admin/cursos
                $stateProvider.state("cursos",{
                    url:'/cursos',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/cursos.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                //admin/estados
                $stateProvider.state("estados",{
                    url:'/estados',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/estados.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                //admin/usuarios
                $stateProvider.state("usuarios",{
                    url:'/usuarios',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/usuarios.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                //admin/profesores
                $stateProvider.state("profesores",{
                    url:'/profesores',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/profesores.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                //admin/coordinadores
                $stateProvider.state("coordinadores",{
                    url:'/cooridnadores',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/cooridnadores.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                //admin/estudiante
                $stateProvider.state("estudiantes",{
                    url:'/estudiantes',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/estudiantes.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                //----------------vistas del Coordinador ---------------------
                //coordinador
                $stateProvider.state("coor",{
                    url: '/coordinador',
                    views:{
                        mainView:{
                            templateUrl: './js/coordinador/coordinador.html',
                            controller: 'coordinadorctrl'
                            }  
                    }
                });
                //crearEstudiante
                //administrador/tipoid
                $stateProvider.state("crearEstudiante",{
                    url:'/crearEstudiante',
                    parent:'coor',
                    views:{
                        coorV:{
                            templateUrl: './js/coordinador/views/crearEstudiante.html',
                            controller: 'coordinadorctrl'
                        }
                    }
                });
                //ver estudiantes
                 $stateProvider.state("verEstudiantes",{
                    url:'/Estudiantes',
                    parent:'coor',
                    views:{
                        coorV:{
                            templateUrl: './js/coordinador/views/verEstudiantes.html',
                            controller: 'coordinadorctrl'
                        }
                    }
                });
                //Editar Estudiante
                $stateProvider.state("editarEstudiante", {
                    url: '/Estudiantes/:id',
                    parent:'coor',
                views: {
                coorV: {
                    templateUrl: './js/coordinador/views/crearEstudiante.html',
                    controller: 'coordinadorctrl'
                }
            }
        });
                //crearprofesores
                $stateProvider.state("crearProfesor",{
                    url:'/crearProfesor',
                    parent:'coor',
                    views:{
                        coorV:{
                            templateUrl: './js/coordinador/views/crearProfesores.html',
                            controller: 'coordinadorctrl'
                        }
                    }
                });
                //ver profesores
                 $stateProvider.state("verProfesor",{
                    url:'/Profesores',
                    parent:'coor',
                    views:{
                        coorV:{
                            templateUrl: './js/coordinador/views/verProfesores.html',
                            controller: 'coordinadorctrl'
                        }
                    }
                });
                
                //crear grupos
                $stateProvider.state("crearGrupo",{
                    url:'/crearGrupo',
                    parent:'coor',
                    views:{
                        coorV:{
                            templateUrl: './js/coordinador/views/crearGrupos.html',
                            controller: 'coordinadorctrl'
                        }
                    }
                });
                //ver grupos
                 $stateProvider.state("verGrupos",{
                    url:'/Grupos',
                    parent:'coor',
                    views:{
                        coorV:{
                            templateUrl: './js/coordinador/views/verGrupos.html',
                            controller: 'coordinadorctrl'
                        }
                    }
                });
                // ----------- infoProfe----------
                $stateProvider.state("profe",{
                    url: '/profesor',
                    views:{
                        mainView:{
                            templateUrl: './js/profesor/profesor.html',
                            controller: 'profesorctrl'
                            }  
                    }
                });
                
                $stateProvider.state("verIProfesor",{
                    url:'/Profesor',
                    parent:'profe',
                    views:{
                        profeV:{
                            templateUrl: './js/profesor/views/verProfesores.html',
                            controller: 'profesorctrl'
                        }
                    }
                });
                
                 $stateProvider.state("crearIProfesor",{
                    url:'/Profesor',
                    parent:'profe',
                    views:{
                        profeV:{
                            templateUrl: './js/profesor/views/crearProfesores.html',
                            controller: 'profesorctrl'
                        }
                    }
                });
                        // ----------- infoEstudiante----------
                $stateProvider.state("estu",{
                    url: '/estudiante',
                    views:{
                        mainView:{
                            templateUrl: './js/estudiante/estudiante.html',
                            controller: 'estudiantectrl'
                            }  
                    }
                });
                
                $stateProvider.state("verIEstudiante",{
                    url:'/estudiante',
                    parent:'estu',
                    views:{
                        profeV:{
                            templateUrl: './js/estudiante/views/verEstudiantes.html',
                            controller: 'estudiantectrl'
                        }
                    }
                });
                
                 $stateProvider.state("crearIEstudiante",{
                    url:'/Estudiante',
                    parent:'estu',
                    views:{
                        profeV:{
                            templateUrl: './js/estudiante/views/crearEstudiantes.html',
                            controller: 'estudiantectrl'
                        }
                    }
                });
                
                
            }
            
            ]);


