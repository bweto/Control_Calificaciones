/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.CalificacionDto;
import edu.konrad.controlcalificaciones.entities.CalificacionEntity;
import edu.konrad.controlcalificaciones.logic.CalificacionLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
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
@Path("/calificacion")
public class CalificacionResource {
    
    @EJB
    private CalificacionLogic calificacionLogic;
    
    @GET
    public List<CalificacionDto> getCalificacionList() {
        List<CalificacionEntity> calificacion = calificacionLogic.ObtenerCalificacion();
        return CalificacionDto.toCalificacionList(calificacion);
    }
    
    @GET
    @Path("{id: \\d+}")
    public CalificacionDto getCalificacion(@PathParam("id") long id) {
        CalificacionEntity calificacion = calificacionLogic.ObtenerCalificacion(id);
        return new CalificacionDto(calificacion);
    }
    
    @POST
    public CalificacionDto crearCalificacion(CalificacionDto calificacionNuevo) {
        return new CalificacionDto(calificacionLogic.crearCalificacion(calificacionNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public CalificacionDto updateCalificacion(@PathParam("id") long id, CalificacionDto calificacionDto) {
        CalificacionEntity calificacionEntity = calificacionLogic.ObtenerCalificacion(id);
        if (calificacionEntity == null) {
            throw new RuntimeException("No existe la calificacion");
        } else {
            calificacionLogic.actualizarCalificacion(id, calificacionDto.toEntity());
        }
        return calificacionDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        CalificacionEntity calificacionEntity = calificacionLogic.ObtenerCalificacion(id);
        if (calificacionEntity == null) {
            throw new RuntimeException("No existe la calificacion");
        } else {
            calificacionLogic.borrarCalificacion(id);
        }
    } 
}
