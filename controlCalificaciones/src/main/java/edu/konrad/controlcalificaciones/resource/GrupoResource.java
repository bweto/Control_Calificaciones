
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.GrupoDto;
import edu.konrad.controlcalificaciones.logic.GrupoLogic;
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
 *Clase encargada de almacenar las caracteristicas de los servicios rest para un grupo
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/grupo")
public class GrupoResource {
    
    @EJB
    private GrupoLogic grupoLogic;
    
    /*
    Obtener todos los grupos
    */
    @GET
    public List<GrupoDto> obtenerGrupos(){
        return GrupoDto.toGrupoDtoList(grupoLogic.ObtenerGrupo());
    }
    
    /*
    Obtener grupo por id
    */
    @GET
    @Path("{id: \\d+}")
    public GrupoDto obtenerGrupo(@PathParam("id")long id){
        return new GrupoDto(grupoLogic.ObtenerGrupo(id));
    }
    
    /*
    crear grupo
    */
    @POST
    public GrupoDto crearGrupo(GrupoDto grupoNuevo){
       return new GrupoDto(grupoNuevo.toEntity());
       
    }
    
    /*
    Actualizar un grupo
    */
    @PUT
    @Path("{id: \\d+}")
    public GrupoDto actualizarGrupo(@PathParam("id")long id, GrupoDto grupoDto){
        if(grupoLogic.ObtenerGrupo(id) == null){
            throw new RuntimeException("No existe el grupo");
        }
        else{
            grupoLogic.actualizarGrupo(id, grupoDto.toEntity());
        }
        return grupoDto;
    }
    
    /*
    Borrar un grupo
    */
    @DELETE
    @Path("{id: \\d+}")
    public void borrarGrupo(@PathParam("id")long id){
        if(grupoLogic.ObtenerGrupo(id) == null){
            throw new RuntimeException("No existe el grupo");
        }
        else{
            grupoLogic.borrarGrupo(id);
        }
    }
}
