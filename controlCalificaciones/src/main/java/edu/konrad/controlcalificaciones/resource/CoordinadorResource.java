/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.CoordinadorDto;
import edu.konrad.controlcalificaciones.entities.CoordinadorEntity;
import edu.konrad.controlcalificaciones.logic.CoordinadorLogic;
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
@Path("/coordinador")
public class CoordinadorResource {
    
    @EJB
    private CoordinadorLogic coordinadorLogic;
    
    @GET
    public List<CoordinadorDto> getCoordinadorList() {
        List<CoordinadorEntity> coordinador = coordinadorLogic.ObtenerCoordinador();
        return CoordinadorDto.toCoordinadorList(coordinador);
    }
    
    @GET
    @Path("{id: \\d+}")
    public CoordinadorDto getCoordinador(@PathParam("id") long id) {
        CoordinadorEntity coordinador = coordinadorLogic.ObtenerCoordinador(id);
        return new CoordinadorDto(coordinador);
    }
    
    @POST
    public CoordinadorDto crearCoordinador(CoordinadorDto coordinadorNuevo) {
        return new CoordinadorDto(coordinadorLogic.crearCoordinador(coordinadorNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public CoordinadorDto updateCoordinador(@PathParam("id") long id, CoordinadorDto coordinadorDto) {
        CoordinadorEntity coordinadorEntity = coordinadorLogic.ObtenerCoordinador(id);
        if (coordinadorEntity == null) {
            throw new RuntimeException("No existe el coordinador");
        } else {
            coordinadorLogic.actualizarCoordinador(id, coordinadorDto.toEntity());
        }
        return coordinadorDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        CoordinadorEntity coordinadorEntity = coordinadorLogic.ObtenerCoordinador(id);
        if (coordinadorEntity == null) {
            throw new RuntimeException("No existe el coordinador");
        } else {
            coordinadorLogic.borrarCoordinador(id);
        }
    } 
}