var app = angular.module("controlNotas");

//revisa la configuracion de la aplicacion mediante el manejo de estados de las
//rutas
app.config([
            "$stateProvider",
            "$urlRouterProvider",
            function ($stateProvider,$urlRouterProvider){
                
                $urlRouterProvider.otherwise('/');
                $stateProvider.state("inicio",{
                    url: '/',
                    views:{
                        mainView:{
                            templateUrl:'./js/inicio/inicio.html',
                            controller: 'inicioctrl'
                        }
                    }       
                })
                .state("admin",{
                    url: '/admin',
                    views:{
                        mainView:{
                            templateUrl: './js/admin/admin.html',
                            controller: 'adminctrl'
                            }  
                    }
                })
                .state("tipoid",{
                    url:'/tipoId',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/tipoid.html',
                            controller: 'adminctrl'
                        }
                    }
                })
                .state("roles",{
                    url:'/roles',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/roles.html',
                            controller: 'adminctrl'
                        }
                    }
                })
                .state("facultades",{
                    url:'/facultades',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/facultades.html',
                            controller: 'adminctrl'
                        }
                    }
                })
                .state("programas",{
                    url:'/programas',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/programas.html',
                            controller: 'adminctrl'
                        }
                    }
                })
                .state("niveles",{
                    url:'/nivelesAcademicos',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/niveles.html',
                            controller: 'adminctrl'
                        }
                    }
                })
                .state("areas",{
                    url:'/areas',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/areas.html',
                            controller: 'adminctrl'
                        }
                    }
                })
                .state("grupos",{
                    url:'/grupos',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/grupos.html',
                            controller: 'adminctrl'
                        }
                    }
                })
                .state("cursos",{
                    url:'/cursos',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/cursos.html',
                            controller: 'adminctrl'
                        }
                    }
                })
                .state("estados",{
                    url:'/estados',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/estados.html',
                            controller: 'adminctrl'
                        }
                    }
                })
                .state("usuarios",{
                    url:'/usuarios',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/usuarios.html',
                            controller: 'adminctrl'
                        }
                    }
                })
                .state("profesores",{
                    url:'/profesores',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/profesores.html',
                            controller: 'adminctrl'
                        }
                    }
                })
                .state("coordinadores",{
                    url:'/cooridnadores',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/cooridnadores.html',
                            controller: 'adminctrl'
                        }
                    }
                })
                .state("estudiantes",{
                    url:'/estudiantes',
                    parent:'admin',
                    views:{
                        adminV:{
                            templateUrl: './js/admin/views/estudiantes.html',
                            controller: 'adminctrl'
                        }
                    }
                });
                
                     
            }
            
            ]);


