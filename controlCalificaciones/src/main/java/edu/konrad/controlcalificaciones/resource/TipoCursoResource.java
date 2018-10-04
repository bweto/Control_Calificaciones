
package edu.konrad.controlcalificaciones.resource;

/**
 *Clase para crear el comportamiento de los servicios rest de un tipo de curso
 * @author Dayan Olaya y Robereto Garcia
 */
import edu.konrad.controlcalificaciones.dto.TipoCursoDto;
import edu.konrad.controlcalificaciones.entities.TipoCursoEntity;
import edu.konrad.controlcalificaciones.logic.TipoCursoLogic;
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

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tipoCurso")

public class TipoCursoResource {
  @EJB
    private TipoCursoLogic tipoCursoLogic;
    
  /*
  Obtiene todos los tipos de curso utilizando el metodo http get
  */
    @GET
    public List<TipoCursoDto> getTipoCursoList(){
        List<TipoCursoEntity> tipoCurso = tipoCursoLogic.ObtenerTipoCurso();
        return  TipoCursoDto.toTipopCursoList(tipoCurso);
    }
    
    /*
    obtiene un tipo de curso utilizando el metodo get y un paratemro id
    */
    @GET
    @Path("{id: \\d+}")
    public TipoCursoDto getTipoCurso(@PathParam("id") long id){
        TipoCursoEntity tipoCurso = tipoCursoLogic.ObtenerTipoCurso(id);
        return  new TipoCursoDto(tipoCurso);
    }
    /*
    crea un nuevo tipo de curso
    */
    @POST
    public TipoCursoDto crearTipoCurso(TipoCursoDto tipoCursoNuevo){
        
        return new TipoCursoDto(tipoCursoLogic.crearTipoCurso(tipoCursoNuevo.toEnntity()));
    }
    
    /*
    actualiza un tipo de curso
    */
    @PUT
    @Path("{id: \\d+}")
    public TipoCursoDto updateTipoCurso(@PathParam("id") long id, TipoCursoDto tipoCursoDto){
        TipoCursoEntity tipoCursoEntity = tipoCursoLogic.ObtenerTipoCurso(id);
        if(tipoCursoEntity == null){
        throw new RuntimeException("No existe el tipo curso");
        }
        else{
        tipoCursoLogic.actualizarTipoCurso(id, tipoCursoDto.toEnntity());
        }
        return tipoCursoDto;
    }
    
    /*
    Borra un tipo de curso
    */
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id){
        TipoCursoEntity tipoCursoEntity = tipoCursoLogic.ObtenerTipoCurso(id);
        if(tipoCursoEntity == null){
        throw new RuntimeException("No existe el tipo de curso");
        }
        else{
        tipoCursoLogic.borrarTipoCurso(id);
        }
    }
    
}
