/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.GrupoDto;
import edu.konrad.controlcalificaciones.entities.GrupoEntity;
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
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/grupo")
public class GrupoResource {
    
    @EJB
    private GrupoLogic grupoLogic;
    
    @GET
    public List<GrupoDto> getGrupoList() {
        List<GrupoEntity> grupo = grupoLogic.ObtenerGrupo();
        return GrupoDto.toGrupoList(grupo);
    }
    
    @GET
    @Path("{id: \\d+}")
    public GrupoDto getGrupo(@PathParam("id") long id) {
        GrupoEntity grupo = grupoLogic.ObtenerGrupo(id);
        return new GrupoDto(grupo);
    }
    
    @POST
    public GrupoDto crearGrupo(GrupoDto grupoNuevo) {
        return new GrupoDto(grupoLogic.crearGrupo(grupoNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public GrupoDto updateGrupo(@PathParam("id") long id, GrupoDto grupoDto) {
        GrupoEntity grupoEntity = grupoLogic.ObtenerGrupo(id);
        if (grupoEntity == null) {
            throw new RuntimeException("No existe el grupo");
        } else {
            grupoLogic.actualizarGrupo(id, grupoDto.toEntity());
        }
        return grupoDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        GrupoEntity grupoEntity = grupoLogic.ObtenerGrupo(id);
        if (grupoEntity == null) {
            throw new RuntimeException("No existe el grupo");
        } else {
            grupoLogic.borrarGrupo(id);
        }
    }    
}
