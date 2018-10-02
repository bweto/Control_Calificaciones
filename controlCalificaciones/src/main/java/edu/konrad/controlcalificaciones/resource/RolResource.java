/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.RolDto;
import edu.konrad.controlcalificaciones.entities.RolEntity;
import edu.konrad.controlcalificaciones.logic.RolLogic;
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
@Path("/rol")
public class RolResource {
    
    @EJB
    private RolLogic rolLogic;
    
    @GET
    public List<RolDto> getRolList() {
        List<RolEntity> rol = rolLogic.ObtenerRol();
        return RolDto.toRolList(rol);
    }
    
    @GET
    @Path("{id: \\d+}")
    public RolDto getRol(@PathParam("id") long id) {
        RolEntity rol = rolLogic.ObtenerRol(id);
        return new RolDto(rol);
    }
    
    @POST
    public RolDto crearRol(RolDto rolNuevo) {
        return new RolDto(rolLogic.crearRol(rolNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public RolDto updateRol(@PathParam("id") long id, RolDto rolDto) {
        RolEntity rolEntity = rolLogic.ObtenerRol(id);
        if (rolEntity == null) {
            throw new RuntimeException("No existe el rol");
        } else {
            rolLogic.actualizarRol(id, rolDto.toEntity());
        }
        return rolDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        RolEntity rolEntity = rolLogic.ObtenerRol(id);
        if (rolEntity == null) {
            throw new RuntimeException("No existe el rol");
        } else {
            rolLogic.borrarRol(id);
        }
    }    
}
