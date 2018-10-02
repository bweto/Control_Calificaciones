/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.TipoCursoDto;
import edu.konrad.controlcalificaciones.entities.TipoCursoEntity;
import edu.konrad.controlcalificaciones.logic.TipoCursoLogic;
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
@Path("/tipoCurso")
public class TipoCursoResource {
    
    @EJB
    private TipoCursoLogic tipoCursoLogic;
    
    @GET
    public List<TipoCursoDto> getTipoCursoList() {
        List<TipoCursoEntity> tipoCurso = tipoCursoLogic.ObtenerTipoCurso();
        return TipoCursoDto.toTipoCursoList(tipoCurso);
    }
    
    @GET
    @Path("{id: \\d+}")
    public TipoCursoDto getTipoCurso(@PathParam("id") long id) {
        TipoCursoEntity tipoCurso = tipoCursoLogic.ObtenerTipoCurso(id);
        return new TipoCursoDto(tipoCurso);
    }
    
    @POST
    public TipoCursoDto crearTipoCurso(TipoCursoDto tipoCursoNuevo) {
        return new TipoCursoDto(tipoCursoLogic.crearTipoCurso(tipoCursoNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public TipoCursoDto updateTipoCurso(@PathParam("id") long id, TipoCursoDto tipoCursoDto) {
        TipoCursoEntity tipoCursoEntity = tipoCursoLogic.ObtenerTipoCurso(id);
        if (tipoCursoEntity == null) {
            throw new RuntimeException("No existe el tipo de curso");
        } else {
            tipoCursoLogic.actualizarTipoCurso(id, tipoCursoDto.toEntity());
        }
        return tipoCursoDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        TipoCursoEntity tipoCursoEntity = tipoCursoLogic.ObtenerTipoCurso(id);
        if (tipoCursoEntity == null) {
            throw new RuntimeException("No existe el tipo de curso");
        } else {
            tipoCursoLogic.borrarTipoCurso(id);
        }
    }    
}
