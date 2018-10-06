
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.ProgramaDto;
import edu.konrad.controlcalificaciones.entities.ProgramaEntity;
import edu.konrad.controlcalificaciones.logic.ProgramaLogic;
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
 *almacena el comportamiento de los servicios rest de un programa
 * @author Dayan olaya y Roberto Garcia 
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/programa")
public class ProgramaResource {
   
    @EJB
    private ProgramaLogic programaLogic;
    
    /*
    Obtener todos los programas 
    */
    @GET
    public List<ProgramaDto> obtenerProgramas(){
        List<ProgramaEntity> programa = programaLogic.ObtenerPrograma();
        return ProgramaDto.toProgramaList(programa);
    }
    
    /*
    Obtener programa por id
    */
    @GET
    @Path("{id: \\d+}")
    public ProgramaDto obtenerPrograma(@PathParam("id") long id){
        ProgramaEntity programa = programaLogic.ObtenerPrograma(id);
        return new ProgramaDto(programa);
    }
    
    /*
    crear un progrma
    */
    
    @POST
    public ProgramaDto crearPrograma(ProgramaDto programaNuevo){
        return new ProgramaDto(programaLogic.crearPrograma(programaNuevo.toEntity()));
    }
    
    /*
    Actualizar un programa
    */
    @PUT
    @Path("{id: \\d+}")
    public ProgramaDto actualizarPrograma(@PathParam("id") long id, ProgramaDto programaNuevo){
       ProgramaEntity programa = programaLogic.ObtenerPrograma(id);
       if(programa == null){
           throw new RuntimeException("No existe el programa");
       }
       else{
           programaLogic.actualizarPrograma(id, programaNuevo.toEntity());
       }
       return programaNuevo;
    }
    
    /*
    Borrar un programa
    */
    @DELETE
    @Path("{id: \\d+}")
    public void borrarPrograma(@PathParam("id") long id){
        ProgramaEntity programa = programaLogic.ObtenerPrograma(id);
        
        if(programa == null){
            throw new RuntimeException("No existe el programa");
        }
        else{
            programaLogic.borrarPrograma(id);
        }
    }
}
