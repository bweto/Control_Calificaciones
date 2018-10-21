/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.ProfesorDto;
import edu.konrad.controlcalificaciones.entities.ProfesorEntity;
import edu.konrad.controlcalificaciones.logic.ProfesorLogic;
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
 *Crea el comportamiento de los servicios rest para un profesor
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/profesor")
public class ProfesorResource {
    
    @EJB
    private ProfesorLogic profesorLogic;
    
    /*
    Obtener todos los profesores
    */
    @GET
    public List<ProfesorDto> obtenerProfesores(){
        return ProfesorDto.toProfesorDtoList(profesorLogic.ObtenerProfesor());
    }
    
    /*
    Obtener profesor por id
    */
    
    @GET
    @Path("{id: \\d+}")
    public ProfesorDto obtenerProfesor(@PathParam("id") long id){
        return new ProfesorDto(profesorLogic.ObtenerProfesor(id));
    }
    
    /*
    crear profesor
    */
    @POST
    public ProfesorDto crearProfesor(ProfesorDto profesorNuevo){
       return new ProfesorDto(profesorNuevo.toEntity());
        
    }
    /*
    Actualizar profesor
    */
    @PUT
    @Path("{id: \\d+}")
    public ProfesorDto actualizarProfesor(@PathParam("id") long id, ProfesorDto profesorNuevo){
      ProfesorEntity profesor = profesorLogic.ObtenerProfesor(id);
      if(profesor == null){
         throw new RuntimeException("No existe el profesor");
      }
      else{
          profesorLogic.actualizarProfesor(id, profesorNuevo.toEntity());
      }
      return profesorNuevo;
    }
    
    /*
    Borrar profesor
    */
    @DELETE
    @Path("{id: \\d+}")
    public void borrarProfesor(@PathParam("id") long id){
      ProfesorEntity profesor = profesorLogic.ObtenerProfesor(id);
      if(profesor == null){
         throw new RuntimeException("No existe el profesor");
      }
      else{ 
          profesorLogic.borrarProfesor(id);
      } 
    }
}
