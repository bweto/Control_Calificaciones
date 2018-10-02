/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.UsuarioDto;
import edu.konrad.controlcalificaciones.entities.UsuarioEntity;
import edu.konrad.controlcalificaciones.logic.UsuarioLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
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
@Path("/usuario")
public class UsuarioResource {
    
    @EJB
    private UsuarioLogic usuarioLogic;
    
    @GET
    public List<UsuarioDto> getUsuarioList() {
        List<UsuarioEntity> usuario = usuarioLogic.ObtenerUsuario();
        return UsuarioDto.toUsuarioList(usuario);
    }
    
    @GET
    @Path("{id: \\d+}")
    public UsuarioDto getUsuario(@PathParam("id") long id) {
        UsuarioEntity usuario = usuarioLogic.ObtenerUsuario(id);
        return new UsuarioDto(usuario);
    }
    
    @POST
    public UsuarioDto crearUsuario(UsuarioDto usuarioNuevo) {
        return new UsuarioDto(usuarioLogic.crearUsuario(usuarioNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public UsuarioDto updateUsuario(@PathParam("id") long id, UsuarioDto usuarioDto) {
        UsuarioEntity usuarioEntity = usuarioLogic.ObtenerUsuario(id);
        if (usuarioEntity == null) {
            throw new RuntimeException("No existe el usuario");
        } else {
            usuarioLogic.actualizarUsuario(id, usuarioDto.toEntity());
        }
        return usuarioDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        UsuarioEntity usuarioEntity = usuarioLogic.ObtenerUsuario(id);
        if (usuarioEntity == null) {
            throw new RuntimeException("No existe el usuario");
        } else {
            usuarioLogic.borrarUsuario(id);
        }
    }   
}
