/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.MateriaInscritaDto;
import edu.konrad.controlcalificaciones.entities.MateriaInscritaEntity;
import edu.konrad.controlcalificaciones.logic.MateriaInscritaLogic;
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
@Path("/materiaInscrita")
public class MateriaInscritaResource {
    
    @EJB
    private MateriaInscritaLogic materiaInscritaLogic;
    
    @GET
    public List<MateriaInscritaDto> getMateriaInscritaList() {
        List<MateriaInscritaEntity> materiaInscrita = materiaInscritaLogic.ObtenerMateriaInscrita();
        return MateriaInscritaDto.toMateriaInscritaList(materiaInscrita);
    }
    
    @GET
    @Path("{id: \\d+}")
    public MateriaInscritaDto getMateriaInscrita(@PathParam("id") long id) {
        MateriaInscritaEntity materiaInscrita = materiaInscritaLogic.ObtenerMateriaInscrita(id);
        return new MateriaInscritaDto(materiaInscrita);
    }
    
    @POST
    public MateriaInscritaDto crearMateriaInscrita(MateriaInscritaDto materiaInscritaNuevo) {
        return new MateriaInscritaDto(materiaInscritaLogic.crearMateriaInscrita(materiaInscritaNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public MateriaInscritaDto updateMateriaInscrita(@PathParam("id") long id, MateriaInscritaDto materiaInscritaDto) {
        MateriaInscritaEntity materiaInscritaEntity = materiaInscritaLogic.ObtenerMateriaInscrita(id);
        if (materiaInscritaEntity == null) {
            throw new RuntimeException("No existe la materia inscrita");
        } else {
            materiaInscritaLogic.actualizarMateriaInscrita(id, materiaInscritaDto.toEntity());
        }
        return materiaInscritaDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        MateriaInscritaEntity materiaInscritaEntity = materiaInscritaLogic.ObtenerMateriaInscrita(id);
        if (materiaInscritaEntity == null) {
            throw new RuntimeException("No existe la materia inscrita");
        } else {
            materiaInscritaLogic.borrarMateriaInscrita(id);
        }
    }    
}
