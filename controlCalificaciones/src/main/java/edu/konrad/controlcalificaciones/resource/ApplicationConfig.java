/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@ApplicationPath("/api")
public class ApplicationConfig {
    public Set<Class<?>> getClases(){
        Set<Class<?>> resources = new HashSet<Class<?>>();
        addRestResourcesClasses(resources);
        return resources;
    }
    
    public void addRestResourcesClasses(Set<Class<?>> resources){
        resources.add(EstudianteResource.class);
    }
}
