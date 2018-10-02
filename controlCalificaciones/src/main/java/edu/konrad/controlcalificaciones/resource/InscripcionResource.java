/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.InscripcionDto;
import edu.konrad.controlcalificaciones.entities.InscripcionEntity;
import edu.konrad.controlcalificaciones.logic.InscripcionLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/inscripcion")
public class InscripcionResource {
    
    @EJB
    private InscripcionLogic inscripcionLogic;
    
    @GET
    public List<InscripcionDto> getInscripcionList() {
        List<InscripcionEntity> inscripcion = inscripcionLogic.ObtenerInscripcion();
        return InscripcionDto.toInscripcionList(inscripcion);
    }
    
    @GET
    @Path("{id: \\d+}")
    public InscripcionDto getInscripcion(@PathParam("id") long id) {
        InscripcionEntity inscripcion = inscripcionLogic.ObtenerInscripcion(id);
        return new InscripcionDto(inscripcion);
    }
    
    @POST
    public InscripcionDto crearInscripcion(InscripcionDto inscripcionNuevo) {
        return new InscripcionDto(inscripcionLogic.crearInscripcion(inscripcionNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public InscripcionDto updateInscripcion(@PathParam("id") long id, InscripcionDto inscripcionDto) {
        InscripcionEntity inscripcionEntity = inscripcionLogic.ObtenerInscripcion(id);
        if (inscripcionEntity == null) {
            throw new RuntimeException("No existe la inscripcion");
        } else {
            inscripcionLogic.actualizarInscripcion(id, inscripcionDto.toEntity());
        }
        return inscripcionDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        InscripcionEntity inscripcionEntity = inscripcionLogic.ObtenerInscripcion(id);
        if (inscripcionEntity == null) {
            throw new RuntimeException("No existe la inscripcion");
        } else {
            inscripcionLogic.borrarInscripcion(id);
        }
    }    
}
