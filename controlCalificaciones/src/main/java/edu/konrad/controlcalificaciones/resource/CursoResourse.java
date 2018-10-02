/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

import edu.konrad.controlcalificaciones.dto.CursoDto;
import edu.konrad.controlcalificaciones.entities.CursoEntity;
import edu.konrad.controlcalificaciones.logic.CursoLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
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
public class CursoResourse {
    
    @EJB
    private CursoLogic cursoLogic;
    
    @GET
    public List<CursoDto> getCursoList() {
        List<CursoEntity> curso = cursoLogic.ObtenerCurso();
        return CursoDto.toCursoList(curso);
    }
    
    @GET
    @Path("{id: \\d+}")
    public CursoDto getCurso(@PathParam("id") long id) {
        CursoEntity curso = cursoLogic.ObtenerCurso(id);
        return new CursoDto(curso);
    }
    
    @POST
    public CursoDto crearCurso(CursoDto cursoNuevo) {
        return new CursoDto(cursoLogic.crearCurso(cursoNuevo.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public CursoDto updateCurso(@PathParam("id") long id, CursoDto cursoDto) {
        CursoEntity cursoEntity = cursoLogic.ObtenerCurso(id);
        if (cursoEntity == null) {
            throw new RuntimeException("No existe el curso");
        } else {
            cursoLogic.actualizarCurso(id, cursoDto.toEntity());
        }
        return cursoDto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id) {
        CursoEntity cursoEntity = cursoLogic.ObtenerCurso(id);
        if (cursoEntity == null) {
            throw new RuntimeException("No existe el curso");
        } else {
            cursoLogic.borrarCurso(id);
        }
    } 
}
