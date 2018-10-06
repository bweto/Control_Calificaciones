
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.RolDto;
import edu.konrad.controlcalificaciones.entities.RolEntity;
import edu.konrad.controlcalificaciones.logic.RolLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.management.relation.Role;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *Crea el comportamiento de los servicios rest para el rol
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/rol")
public class RolResource {
    
    @EJB
    private RolLogic rolLogic; 
    
    /*
    Obtener todos los roles
    */
    @GET
    public List<RolDto> obtenerRolList(){
       List<RolEntity> rolList = rolLogic.ObtenerRol();
       return RolDto.toRollist(rolList);
    }
    
    /*
    Obtener rol por id
    */
    
    @GET
    @PathParam("{id: \\d+}")
    public RolDto obtenerRol(@PathParam("id") long id){
        RolEntity rol = rolLogic.ObtenerRol(id);
        return new RolDto(rol);
    }
    
    /*
    Crear un rol
    */
    
    @POST
    
    public RolDto crearRol( RolDto rolNuevo){
        return new RolDto(rolLogic.crearRol(rolNuevo.toEntity()));
    }
    
    /*
    Actualizar un rol
    */
    @PUT
    @Path("{id: //d+}")
    public RolDto actualizarRol(@PathParam("id") long id, RolDto rolUpdate){
        RolEntity rol = rolLogic.ObtenerRol(id);
        if(rol == null){
        throw new RuntimeException("No existe rol");
        }
        else{
            rolLogic.actualizarRol(id, rolUpdate.toEntity());
        }
        return rolUpdate;
    }
    
    /*
    Borrar un rol
    */
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id){
       RolEntity rol = rolLogic.ObtenerRol(id);
        if(rol == null){
        throw new RuntimeException("No existe el rol");
        }
        else{
        rolLogic.borrarRol(id);
        }
    }
    
    
}
