
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.CursoDto;
import edu.konrad.controlcalificaciones.logic.CursoLogic;
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
 *clase utilizada para almacenar el comportamiento de los servicios rest para un curso
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/curso")
public class CursoResource {
    
    @EJB
    private CursoLogic cursoLogic;
    
    /*
    obtener todos los cursos
    */
    @GET
    public List<CursoDto> obtenerCurso(){
        return CursoDto.toCursoDtoList(cursoLogic.ObtenerCurso());
    }
    
    /*-
    Obtener curso por id
    */
    @GET
    @Path("{id: \\d+}")
    public CursoDto obtenerCurso(@PathParam("id")long id){
        return new CursoDto(cursoLogic.ObtenerCurso(id));
    }
    /*
    crear un curso
    */
    @POST
    public CursoDto crearCurso(CursoDto cursoNuevo){
        return new CursoDto(cursoNuevo.toEntity());
       
    }
    /*
    Actualizar Curso
    */
    @PUT
    @Path("{id: \\d+}")
    public CursoDto actualizarCurso(@PathParam("id")long id, CursoDto cursoNuevo){
        if(cursoLogic.ObtenerCurso(id)==null){
            throw  new RuntimeException("No existe curso");
        }
        else{
            cursoLogic.actualizarCurso(id, cursoNuevo.toEntity());
        }
        return cursoNuevo;
            
    }
    /*
    Borar curso por id
    */
    @DELETE
    @Path("{id: \\d+}")
    public void borrarCurso(@PathParam("id")long id){
        if(cursoLogic.ObtenerCurso(id)==null){
            throw  new RuntimeException("No existe curso");
        }
        else{
            cursoLogic.borrarCurso(id);
        }
    }
}
