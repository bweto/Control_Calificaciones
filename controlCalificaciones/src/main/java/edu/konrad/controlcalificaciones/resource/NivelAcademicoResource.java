/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.NivelAcademicoDto;
import edu.konrad.controlcalificaciones.entities.NivelAcademicoEntity;
import edu.konrad.controlcalificaciones.logic.NivelAcademicoLogic;
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
@Path("/nivelAcademico")
public class NivelAcademicoResource {
    
    @EJB
    private NivelAcademicoLogic nivelAcademicoLogic;
    
    @GET
    public List<NivelAcademicoDto> getNivelAcademicoList() {
        List<NivelAcademicoEntity> nivelAcademico = nivelAcademicoLogic.ObtenerNivelAcademico();
        return NivelAcademicoDto.toNivelAcademicoList(nivelAcademico);
    }
    
    @GET
    @Path("{id: \\d+}")
    public NivelAcademicoDto getNivelAcademico(@PathParam("id") long id) {
        NivelAcademicoEntity nivelAcademico = nivelAcademicoLogic.ObtenerNivelAcademico(id);
        return new NivelAcademicoDto(nivelAcademico);
    }
    
    @POST
    public NivelAcademicoDto crearNivelAcademico(NivelAcademicoDto nivelAcademicoNuevo) {
        return new NivelAcademicoDto(nivelAcademicoLogic.crearNivelAcademico(nivelAcademicoNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public NivelAcademicoDto updateNivelAcademico(@PathParam("id") long id, NivelAcademicoDto nivelAcademicoDto) {
        NivelAcademicoEntity nivelAcademicoEntity = nivelAcademicoLogic.ObtenerNivelAcademico(id);
        if (nivelAcademicoEntity == null) {
            throw new RuntimeException("No existe el nivel academico");
        } else {
            nivelAcademicoLogic.actualizarNivelAcademico(id, nivelAcademicoDto.toEntity());
        }
        return nivelAcademicoDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        NivelAcademicoEntity nivelAcademicoEntity = nivelAcademicoLogic.ObtenerNivelAcademico(id);
        if (nivelAcademicoEntity == null) {
            throw new RuntimeException("No existe el nivel academico");
        } else {
            nivelAcademicoLogic.borrarNivelAcademico(id);
        }
    }   
}
