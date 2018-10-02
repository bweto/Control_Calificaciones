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
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/profesor")
public class ProfesorResource {
    
    @EJB
    private ProfesorLogic profesorLogic;
    
    @GET
    public List<ProfesorDto> getProfesorList() {
        List<ProfesorEntity> profesor = profesorLogic.ObtenerProfesor();
        return ProfesorDto.toProfesorList(profesor);
    }
    
    @GET
    @Path("{id: \\d+}")
    public ProfesorDto getProfesor(@PathParam("id") long id) {
        ProfesorEntity profesor = profesorLogic.ObtenerProfesor(id);
        return new ProfesorDto(profesor);
    }
    
    @POST
    public ProfesorDto crearProfesor(ProfesorDto profesorNuevo) {
        return new ProfesorDto(profesorLogic.crearProfesor(profesorNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ProfesorDto updateProfesor(@PathParam("id") long id, ProfesorDto profesorDto) {
        ProfesorEntity profesorEntity = profesorLogic.ObtenerProfesor(id);
        if (profesorEntity == null) {
            throw new RuntimeException("No existe el profesor");
        } else {
            profesorLogic.actualizarProfesor(id, profesorDto.toEntity());
        }
        return profesorDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        ProfesorEntity profesorEntity = profesorLogic.ObtenerProfesor(id);
        if (profesorEntity == null) {
            throw new RuntimeException("No existe el profesor");
        } else {
            profesorLogic.borrarProfesor(id);
        }
    }     
}
