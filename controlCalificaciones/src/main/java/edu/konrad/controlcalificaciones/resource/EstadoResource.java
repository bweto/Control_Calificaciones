/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.EstadoDto;
import edu.konrad.controlcalificaciones.entities.EstadoEntity;
import edu.konrad.controlcalificaciones.logic.EstadoLogic;
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
@Path("/estado")
public class EstadoResource {
    
    @EJB
    private EstadoLogic estadoLogic;
    
    @GET
    public List<EstadoDto> getEstadoList() {
        List<EstadoEntity> estado = estadoLogic.ObtenerEstado();
        return EstadoDto.toEstadoList(estado);
    }
    
    @GET
    @Path("{id: \\d+}")
    public EstadoDto getEstado(@PathParam("id") long id) {
        EstadoEntity estado = estadoLogic.ObtenerEstado(id);
        return new EstadoDto(estado);
    }
    
    @POST
    public EstadoDto crearEstado(EstadoDto estadoNuevo) {
        return new EstadoDto(estadoLogic.crearEstado(estadoNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public EstadoDto updateEstado(@PathParam("id") long id, EstadoDto estadoDto) {
        EstadoEntity estadoEntity = estadoLogic.ObtenerEstado(id);
        if (estadoEntity == null) {
            throw new RuntimeException("No existe el estado");
        } else {
            estadoLogic.actualizarEstado(id, estadoDto.toEntity());
        }
        return estadoDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        EstadoEntity estadoEntity = estadoLogic.ObtenerEstado(id);
        if (estadoEntity == null) {
            throw new RuntimeException("No existe el estado");
        } else {
            estadoLogic.borrarEstado(id);
        }
    }     
}
