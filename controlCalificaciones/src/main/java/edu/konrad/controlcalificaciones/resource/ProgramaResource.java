/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.ProgramaDto;
import edu.konrad.controlcalificaciones.entities.ProgramaEntity;
import edu.konrad.controlcalificaciones.logic.ProgramaLogic;
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
@Path("/programa")
public class ProgramaResource {
    
    @EJB
    private ProgramaLogic programaLogic;
    
    @GET
    public List<ProgramaDto> getProgramaList() {
        List<ProgramaEntity> programa = programaLogic.ObtenerPrograma();
        return ProgramaDto.toProgramaList(programa);
    }
    
    @GET
    @Path("{id: \\d+}")
    public ProgramaDto getPrograma(@PathParam("id") long id) {
        ProgramaEntity programa = programaLogic.ObtenerPrograma(id);
        return new ProgramaDto(programa);
    }
    
    @POST
    public ProgramaDto crearPrograma(ProgramaDto programaNuevo) {
        return new ProgramaDto(programaLogic.crearPrograma(programaNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ProgramaDto updatePrograma(@PathParam("id") long id, ProgramaDto programaDto) {
        ProgramaEntity programaEntity = programaLogic.ObtenerPrograma(id);
        if (programaEntity == null) {
            throw new RuntimeException("No existe el programa");
        } else {
            programaLogic.actualizarPrograma(id, programaDto.toEntity());
        }
        return programaDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        ProgramaEntity programaEntity = programaLogic.ObtenerPrograma(id);
        if (programaEntity == null) {
            throw new RuntimeException("No existe el programa");
        } else {
            programaLogic.borrarPrograma(id);
        }
    }   
}
