/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.TipoIdDto;
import edu.konrad.controlcalificaciones.entities.TipoIdEntity;
import edu.konrad.controlcalificaciones.logic.TipoIdLogic;
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
@Path("/tipoId")
public class TipoIdResource {
    
    @EJB
    private TipoIdLogic tipoIdLogic;
    
    @GET
    public List<TipoIdDto> getTipoIdList() {
        List<TipoIdEntity> tipoId = tipoIdLogic.ObtenerTipoId();
        return TipoIdDto.toTipoIdList(tipoId);
    }
    
    @GET
    @Path("{id: \\d+}")
    public TipoIdDto getTipoId(@PathParam("id") long id) {
        TipoIdEntity tipoId = tipoIdLogic.ObtenerTipoId(id);
        return new TipoIdDto(tipoId);
    }
    
    @POST
    public TipoIdDto crearTipoId(TipoIdDto tipoIdNuevo) {
        return new TipoIdDto(tipoIdLogic.crearTipoId(tipoIdNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public TipoIdDto updateTipoId(@PathParam("id") long id, TipoIdDto tipoIdDto) {
        TipoIdEntity tipoIdEntity = tipoIdLogic.ObtenerTipoId(id);
        if (tipoIdEntity == null) {
            throw new RuntimeException("No existe el tipo de Id");
        } else {
            tipoIdLogic.actualizarTipoId(id, tipoIdDto.toEntity());
        }
        return tipoIdDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        TipoIdEntity tipoIdEntity = tipoIdLogic.ObtenerTipoId(id);
        if (tipoIdEntity == null) {
            throw new RuntimeException("No existe el tipo de Id");
        } else {
            tipoIdLogic.borrarTipoId(id);
        }
    }   
}
