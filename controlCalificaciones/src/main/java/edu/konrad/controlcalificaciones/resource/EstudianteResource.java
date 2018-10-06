
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.EstudianteDto;
import edu.konrad.controlcalificaciones.logic.EstudianteLogic;
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
 *Clase encargada de almacenar las caracteristicas de los servicios rest para un estudiante
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/estudiante") 
public class EstudianteResource {
   @EJB
    private EstudianteLogic estudianteLogic;
    
    /*
    Obtener todos los estudiantes
    */
    @GET
    public List<EstudianteDto> obtenerEstudiante(){
        return EstudianteDto.toEstudianteDtoList(estudianteLogic.ObtenerEstudiante());
    }
    
    /*
    Obtener estudiante por id
    */
    @GET
    @Path("{id: \\d+}")
    public EstudianteDto obtenerEstudiante(@PathParam("id")long id){
        return new EstudianteDto(estudianteLogic.ObtenerEstudiante(id));
    }
    
    /*
    crear estudiante
    */
    @POST
    public EstudianteDto crearEstudiante(EstudianteDto estudianteNuevo){
        return new EstudianteDto.crearEstudiante(estudianteNuevo.toEntity());
        
    }
    
    /*
    Actualizar un estudiante
    */
    @PUT
    @Path("{id: \\d+}")
    public EstudianteDto actualizarEstudiante(@PathParam("id")long id, EstudianteDto estudianteDto){
        if(estudianteLogic.ObtenerEstudiante(id) == null){
            throw new RuntimeException("No existe el estudiante");
        }
        else{
            estudianteLogic.actualizarEstudiante(id, estudianteDto.toEntity());
        }
        return estudianteDto;
    }
    
    /*
    Borrar un estudiante
    */
    @DELETE
    @Path("{id: \\d+}")
    public void borrarEstudiante(@PathParam("id")long id){
        if(estudianteLogic.ObtenerEstudiante(id) == null){
            throw new RuntimeException("No existe el estudiante");
        }
        else{
            estudianteLogic.borrarEstudiante(id);
        }
    }
}
