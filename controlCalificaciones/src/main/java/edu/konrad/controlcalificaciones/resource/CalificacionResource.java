
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.CalificacionDto;
import edu.konrad.controlcalificaciones.logic.CalificacionLogic;
import java.util.List;
import javax.ejb.EJB;
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
 *Clases que contiene las caracteristicas de los servicios rest 
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/calificacion")
public class CalificacionResource {
  
    @EJB
    private CalificacionLogic calificacionLogic;
    
    /*
    Obtener todas las calificaciones
    */
    @GET
    public List<CalificacionDto> obtenerCalificaciones(){
        return CalificacionDto.toMateriaDtoList(calificacionLogic.ObtenerCalificacion());
    }
    
    /*
    obtener calificaciones por id
    */
    @GET
    @Path("{id: \\d+}")
    public CalificacionDto obtenerCalificacion(@PathParam("id")long id){
        return new CalificacionDto(calificacionLogic.ObtenerCalificacion(id));
    }
    
    /*
    crear calificacion
    */
    @POST
    public CalificacionDto crearCalificacion(CalificacionDto calificacionNueva){
        return new calificacionDto.crearCalificacion(calificacionNueva.toEntity());
         
    }
    
    /*
    actualizar calificacion
    */
    @PUT
    @Path("{id: \\d+}")
    public CalificacionDto actualizarCalificacion(@PathParam("id")long id, CalificacionDto calificacionNueva){
        if(calificacionLogic.ObtenerCalificacion(id) == null){
            throw new RuntimeException("No existe calificación");
        }
        else{
            calificacionLogic.actualizarCalificacion(id, calificacionNueva.toEntity());
        }
        return calificacionNueva;
    }
    
    /*
    borrar Calificacion
    */
    @DELETE
    @Path("{id: \\d+}")
    public void borrarCalificacion(@PathParam("id")long id){
        if(calificacionLogic.ObtenerCalificacion(id) == null){
            throw new RuntimeException("No existe calificación");
        }
        else{
            calificacionLogic.borrarCalificacion(id);
        }
    }
}
