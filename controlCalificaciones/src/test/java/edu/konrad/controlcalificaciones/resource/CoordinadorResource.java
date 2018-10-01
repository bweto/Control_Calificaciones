
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.CoordinadorDto;
import edu.konrad.controlcalificaciones.logic.CoordinadorLogic;
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
 *Clase que se encarga de las caracteristicas de los servicios rest de un coordinador
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/coordinador")
public class CoordinadorResource {
 
        @EJB
        private CoordinadorLogic coordinadorLogic;
        
        /*
        Obtener todos los coordinadores
        */
        @GET
        public List<CoordinadorDto> obtenerCoordinadores(){
            return CoordinadorDto.toCoordinadorDtoList(coordinadorLogic.ObtenerCoordinador());
        }
        
        /*
        Obtener coordinador por id
        */
        @GET
        @Path("{id: //d+}")
        public CoordinadorDto obtenerCoordinador(@PathParam("id")long id){
            return new CoordinadorDto(coordinadorLogic.ObtenerCoordinador(id));
        }
        
        /*
        Crear un coordinador
        */
        @POST
        public CoordinadorDto crearCoordinador(CoordinadorDto coordinadorNuevo){
            coordinadorLogic.crearCoordinador(coordinadorNuevo.toEntity());
            return coordinadorNuevo;
        }
        
        /*
        Actualizar un coordinador
        */
        @PUT
        @Path("{id: //d+}")
        public CoordinadorDto actualizarCoordinador(@PathParam("id")long id, CoordinadorDto coordinadorNuevo){
            if(coordinadorLogic.ObtenerCoordinador() == null){
                throw new RuntimeException("No existe coordinador");
            }
            else{
                coordinadorLogic.actualizarCoordinador(id, coordinadorNuevo.toEntity());
            }
            return coordinadorNuevo;
        }
        
        /*
        Borrar un coordindaor
        */
        @DELETE
        @Path("{id: //d+}")
        public void borrarCoordindaor(@PathParam("id")long id){
            if(coordinadorLogic.ObtenerCoordinador() == null){
                throw new RuntimeException("No existe coordinador");
            }
            else{
                coordinadorLogic.borrarCoordinador(id);
            }
        }
}
