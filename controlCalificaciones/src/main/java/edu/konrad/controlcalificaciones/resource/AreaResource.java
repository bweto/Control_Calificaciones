
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.AreaDto;
import edu.konrad.controlcalificaciones.logic.AreaLogic;
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
 *Clase que contiene las caracteristicas de los servicios de area 
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/area")
public class AreaResource {
    @EJB
    private AreaLogic areaLogic;
    
    /*
    Obtener todas las areas
    */
    @GET
    public List<AreaDto> obtenerArea(){
        return AreaDto.toAreaDtoList(areaLogic.ObtenerArea());
    }
    
    /*
    obtener una area por id
    */
    @GET
    @Path("{id: \\d+}")
    public AreaDto obtenerArea(@PathParam("id")long id){
        return new AreaDto(areaLogic.ObtenerArea(id));
    }
    /*
    crear area
    */
    @POST
    public AreaDto crearArea(AreaDto areaNueva){
      return new AreaDto(areaLogic.crearArea(areaNueva.toEntity()));
         
    }
    
    /*}
    Actuaizar area
    */
    @PUT
    @Path("{id: \\d+}")
    public AreaDto actualizarArea(@PathParam("id")long id, AreaDto areaNueva){
        if(areaLogic.ObtenerArea()== null){
            throw new RuntimeException("No existe area");
        }
        else{
            areaLogic.actualizarArea(id, areaNueva.toEntity());
        }
        return areaNueva;
    }
    
    /*
    Borrar area
    */
    @DELETE
    @Path("{id: \\d+}")
    public void borrarArea(@PathParam("id")long id){
        if(areaLogic.ObtenerArea(id) == null){
            throw new RuntimeException("No existe calificación");
        }
        else{
            areaLogic.borrarArea(id);
        }
    }
}
