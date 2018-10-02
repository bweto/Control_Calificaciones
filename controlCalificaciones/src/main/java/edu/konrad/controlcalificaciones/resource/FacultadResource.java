/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.FacultadDto;
import edu.konrad.controlcalificaciones.entities.FacultadEntity;
import edu.konrad.controlcalificaciones.logic.FacultadLogic;
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
@Path("/facultad")
public class FacultadResource {
    
    @EJB
    private FacultadLogic facultadLogic;
    
    @GET
    public List<FacultadDto> getEFacultadList() {
        List<FacultadEntity> facultad = facultadLogic.ObtenerFacultad();
        return FacultadDto.toFacultadList(facultad);
    }
    
    @GET
    @Path("{id: \\d+}")
    public FacultadDto getFacultad(@PathParam("id") long id) {
        FacultadEntity facultad = facultadLogic.ObtenerFacultad(id);
        return new FacultadDto(facultad);
    }
    
    @POST
    public FacultadDto crearFacultad(FacultadDto facultadNuevo) {
        return new FacultadDto(facultadLogic.crearFacultad(facultadNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public FacultadDto updateFacultad(@PathParam("id") long id, FacultadDto facultadDto) {
        FacultadEntity facultadEntity = facultadLogic.ObtenerFacultad(id);
        if (facultadEntity == null) {
            throw new RuntimeException("No existe la facultad");
        } else {
            facultadLogic.actualizarFacultad(id, facultadDto.toEntity());
        }
        return facultadDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        FacultadEntity facultadEntity = facultadLogic.ObtenerFacultad(id);
        if (facultadEntity == null) {
            throw new RuntimeException("No existe la facultad");
        } else {
            facultadLogic.borrarFacultad(id);
        }
    }    
}
