/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.EstudianteDto;
import edu.konrad.controlcalificaciones.entities.EstudianteEntity;
import edu.konrad.controlcalificaciones.logic.EstudianteLogic;
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
@Path("/estudiante")
public class EstudianteResource {
    
    @EJB
    private EstudianteLogic estudianteLogic;
    
    @GET
    public List<EstudianteDto> getEstudianteList() {
        List<EstudianteEntity> estudiante = estudianteLogic.ObtenerEstudiante();
        return EstudianteDto.toEstudianteList(estudiante);
    }
    
    @GET
    @Path("{id: \\d+}")
    public EstudianteDto getEstudiante(@PathParam("id") long id) {
        EstudianteEntity estudiante = estudianteLogic.ObtenerEstudiante(id);
        return new EstudianteDto(estudiante);
    }
    
    @POST
    public EstudianteDto crearEstudiante(EstudianteDto estudianteNuevo) {
        return new EstudianteDto(estudianteLogic.crearEstudiante(estudianteNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public EstudianteDto updateEstudiante(@PathParam("id") long id, EstudianteDto estudianteDto) {
        EstudianteEntity estudianteEntity = estudianteLogic.ObtenerEstudiante(id);
        if (estudianteEntity == null) {
            throw new RuntimeException("No existe el estudiante");
        } else {
            estudianteLogic.actualizarEstudiante(id, estudianteDto.toEntity());
        }
        return estudianteDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        EstudianteEntity estudianteEntity = estudianteLogic.ObtenerEstudiante(id);
        if (estudianteEntity == null) {
            throw new RuntimeException("No existe el estudiante");
        } else {
            estudianteLogic.borrarEstudiante(id);
        }
    } 
}
