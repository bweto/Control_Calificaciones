
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.FacultadDto;
import edu.konrad.controlcalificaciones.logic.FacultadLogic;
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
 *Clase que se encarga de almacenar el comportamiento de los servicios rest de 
 * una facultad
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/facultad")
public class FacultadResource {
    
    @EJB
    private FacultadLogic facultadLogic;
    
    /*
    Obtener todas las facultades
    */
    @GET
    public List<FacultadDto> obtenerFacultad(){
        return FacultadDto.toFacultadDtoList(facultadLogic.ObtenerFacultad());
    }
    
    /*
    Obtener facultad por id
    */
    @GET
    @Path("{id: \\d+}")
    public FacultadDto obtenerFacultad(@PathParam("id")long id){
        return new FacultadDto(facultadLogic.ObtenerFacultad(id));
    }
    
    /*
    crear una facultad
    */
    @POST
    public FacultadDto crearFacultad(FacultadDto facultadNueva){
        return new facultadDto(facultadNueva.toEntity());
        
    }
    
    /*
    Actualizar una facultad
    */
    @PUT
    @Path("{id: \\d+}")
    public FacultadDto actualizarFacultad(@PathParam("id")long id, FacultadDto facultadNueva){
        if(facultadLogic.ObtenerFacultad(id) == null){
            throw new RuntimeException("No existe la facultad");
        }
        else{
            facultadLogic.actualizarFacultad(id, facultadNueva.toEntity());
        }
        return facultadNueva;
    }
    
    /*
    Borrar una facultad
    */
    @DELETE
    @Path("{id: \\d+}")
    public void borrarFacultad(@PathParam("id")long id){
        if(facultadLogic.ObtenerFacultad(id) == null){
            throw new RuntimeException("No existe la facultad");
        }
        else{
            facultadLogic.borrarFacultad(id);
        }
    }
    
}
