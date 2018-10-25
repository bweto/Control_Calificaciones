
package edu.konrad.controlcalificaciones.resource;


import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *clase que muestra los servicios rest
 * @author Dayan y roberto
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application{
    
    public Set<Class<?>> getClases(){
        Set<Class<?>> resources = new HashSet<Class<?>>();
        addRestResourcesClasses(resources);
        return resources;
    }
    
    public void addRestResourcesClasses(Set<Class<?>> resources){
        resources.add(AreaResource.class);
        resources.add(CalificacionResource.class);
        resources.add(CoordinadorResource.class);
        resources.add(CursoResource.class);
        resources.add(EstadoResource.class);
        resources.add(EstudianteResource.class);
        resources.add(FacultadResource.class);
        resources.add(GrupoResource.class);
        resources.add(InscripcionResource.class);
        resources.add(MateriaInscritaResource.class);
        resources.add(NivelAcademicoResource.class);
        resources.add(ProfesorResource.class);
        resources.add(ProgramaResource.class);
        resources.add(RolResource.class);
        resources.add(TipoIdResource.class);
        resources.add(UsuarioResource.class);
        
        
    }
    
    
}
