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
 *clase que contiene las carateristicas de los servicios rest para un nivel 
 * academico
 * @author Dayan olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/nivelAcademico")
public class NivelAcademicoResource {
    
    @EJB
    private NivelAcademicoLogic nivelLogic;
    
    /*
    Obtener todos los nivel academicos
    */
    @GET
    public List<NivelAcademicoDto> obtenerNiveles(){
       return NivelAcademicoDto.toNivelAcademicoDtoList(nivelLogic.ObtenerNivelAcademico());
    }
    /*
    Obtener nivl acdemico por id
    */
    @GET
    @Path("{id: \\d+}")
    public NivelAcademicoDto obtenerNivel(@PathParam("id")long id){
        return new NivelAcademicoDto(nivelLogic.ObtenerNivelAcademico(id));
    }
    
    /*
    crear un nivel academico
    */
    @POST
    public NivelAcademicoDto crearNivel(NivelAcademicoDto nivelNuevo){
        return new NivelDto(nivelNuevo.toEntity());
      
    }
    
    /*
    Actualizar nivel academico
    */
    @PUT
    @Path("{id: \\d+}")
    public NivelAcademicoDto actualizarNivel(@PathParam("id")long id, NivelAcademicoDto nivelNuevo){
        NivelAcademicoEntity nivel = nivelLogic.ObtenerNivelAcademico(id);
        if(nivel == null){
            throw new RuntimeException("No existe el nivel academico");
        }
        else{
            nivelLogic.actualizarNivelAcademico(id, nivelNuevo.toEntity());
        }
        return nivelNuevo;
    }
    /*
    borrar nivel 
    */
    @DELETE
    @Path("{id: \\d+}")
    public void borrarNivel(@PathParam("id")long id){
          NivelAcademicoEntity nivel = nivelLogic.ObtenerNivelAcademico(id);
        if(nivel == null){
            throw new RuntimeException("No existe el nivel academico");
        }
        else{
            nivelLogic.borrarNivelAcademico(id);
        }
    }
            
}
