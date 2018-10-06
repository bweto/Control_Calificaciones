
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.EstadoDto;
import edu.konrad.controlcalificaciones.logic.EstadoLogic;
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
 *Clase que contiene las caracteristicas de los servicios rest de un estado
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/estado")
public class EstadoResource {
    
    @EJB
    private EstadoLogic estadoLogic;
    
    /*
    obtener todos los estados
    */
    @GET
    public List<EstadoDto> obtenerEstado(){
        return EstadoDto.toEstadoDtoList(estadoLogic.ObtenerEstado());
    }
    
    /*
    obtener estado por id
    */
    @GET
    @Path("{id: \\d+}")
    public EstadoDto obtenerEstado(@PathParam("id")long id){
        return new EstadoDto(estadoLogic.ObtenerEstado(id));
    }
    
    /*
    crear estado
    */
    @POST
    public EstadoDto crearEstado(EstadoDto estadoNuevo){
       return  new EstadoDto(estadoNuevo.toEntity());
        
    }
    
    /*
    Actualizar estado
    */
    
    @PUT
    @Path("{id: \\d+}")
    public EstadoDto actualizarEstado(@PathParam("id")long id, EstadoDto estadoNuevo){
        if(estadoLogic.ObtenerEstado(id) == null){
            throw new RuntimeException("No existe estado");
        }
        else{
            estadoLogic.actualizarEstado(id, estadoNuevo.toEntity());
        }
        return estadoNuevo;
    }
    
    /*
    borrar estado
    */
    @DELETE
    @Path("{id: \\d+}")
    public void borrarEstado(@PathParam("id")long id){
         if(estadoLogic.ObtenerEstado(id) == null){
            throw new RuntimeException("No existe estado");
        }
        else{
            estadoLogic.borrarEstado(id);
        }
    }
}
