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
 *Clase que constiene la caracteristica de los servicios rest para una materia inscrita
 * @author Dayan Olaya y Roberto Garcia
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/MateriaInscrita")
public class MateriaInscritaResource {
    
    @EJB
    private MateriaInscritaLogic materiaLogic;
    
    /*
    Obtener todas las materis ainscritas
    */
    @GET
    public List<MateriaInscritaDto> obtenerMaterias(){
        return MateriaInscritaDto.toMateriaDtoList(materiaLogic.ObtenerMateriaInscrita());
    }
    /*
    Obtener mateias inscritas por id
    */
    @GET
    @Path("{id: \\d+}")
    public MateriaInscritaDto obtenerMateria(@PathParam("id") long id){
      return new MateriaInscritaDto(materiaLogic.ObtenerMateriaInscrita(id));
    }
    /*
    crear materia
    */
    @POST
    public MateriaInscritaDto crearMateria(MateriaInscritaDto nuevaMateria){
        return new MateriaInscritaDto(materiaLogic.crearMateriaInscrita(nuevaMateria.toEntity()));
        
    }
    /*
    Actualizar Materia
    */
    @PUT
    @Path("{id: \\d+}")
    public MateriaInscritaDto actualizarMateria(@PathParam("id")long id, MateriaInscritaDto mateiaNueva){
        MateriaInscritaEntity materia = materiaLogic.ObtenerMateriaInscrita(id);
        if(materia == null){
            throw new RuntimeException("No existe una materia inscrita");
        }
        else{
            materiaLogic.actualizarMateriaInscrita(id, mateiaNueva.toEntity());
        }
        return  mateiaNueva;
    }
    /*
     borrar una materia
    */
    @DELETE
    @Path("{id: \\d+}")
    public void borrarMateria(@PathParam("id")long id){
        MateriaInscritaEntity materia = materiaLogic.ObtenerMateriaInscrita(id);
        if(materia == null){
            throw new RuntimeException("No existe una materia inscrita");
        }
        else{
            materiaLogic.borrarMateriaInscrita(id);
        }
}
}
