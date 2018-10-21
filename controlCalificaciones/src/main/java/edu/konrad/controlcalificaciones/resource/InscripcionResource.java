/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.InscripcionDto;
import edu.konrad.controlcalificaciones.logic.InscripcionLogic;
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
 *Clase que contiene las caracteristicas de los servicios rest para las inscripciones
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/inscripcion")
public class InscripcionResource {
    @EJB
    private InscripcionLogic inscripcionLogic;
    
    /*
    obtener todos las inscripciones
    */
    @GET
    public List<InscripcionDto> obtenerInscripciones(){
        return InscripcionDto.toInscripcionDtoList(inscripcionLogic.ObtenerInscripcion());
    }
    /*
    obtener inscripciones por id
    */
    @GET
    @Path("{id: \\d+}")
    public InscripcionDto obtenerInscripciones(@PathParam("id")long id){
        return new InscripcionDto((inscripcionLogic.ObtenerInscripcion(id)));
    }
    /*
    Crear una inscrićion
    */
    @POST
    public InscripcionDto crearInscripcion(InscripcionDto inscripcionNueva){
       return new InscripcionDto(inscripcionNueva.toEntity());
       
    }
    /*
    Actualizar la inscripcion
    */
    @PUT
    @Path("{id: \\d+}")
    public InscripcionDto actualizarInscripcion(@PathParam("id")long id, InscripcionDto inscripcionNueva){
        if(inscripcionLogic.ObtenerInscripcion(id) == null){
            throw new RuntimeException("No existe inscripcion");
        }
        else{
           inscripcionLogic.actualizarInscripcion(id, inscripcionNueva.toEntity());
        }
        return inscripcionNueva;
    }
    /*
    borrar inscripcion
    */
    @DELETE
    @Path("{id: \\d+}")
    public void borrarInscripcion(@PathParam("id")long id){
      if(inscripcionLogic.ObtenerInscripcion(id) == null){
            throw new RuntimeException("No existe inscripcion");
        }
        else{
           inscripcionLogic.borrarInscripcion(id);
        }
    }
}
