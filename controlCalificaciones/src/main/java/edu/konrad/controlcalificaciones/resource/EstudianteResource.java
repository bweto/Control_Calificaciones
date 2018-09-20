/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.resource;

//import edu.konrad.controlcalificaciones.dto.EstudianteDto;
//import edu.konrad.controlcalificaciones.entities.EstudianteEntity;
//import edu.konrad.controlcalificaciones.logic.EstudianteLogic;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import static javax.ws.rs.HttpMethod.PUT;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
///**
// * @author Dayan Olaya y Roberto Garcia
// */
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//@Path("/areas")
//public class EstudianteResource {
//    
//    @EJB
//    private EstudianteLogic estudianteLogic;
//    
//    @GET
//    public List<EstudianteDto> getAreasList() {
//        List<EstudianteEntity> estudiante = estudianteLogic.ObtenerEstudiante();
//        return EstudianteDto;
//    }
//    
//    @GET
//    @Path("{id: \\d+}")
//    public AreaDto getArea(@PathParam("id") long id) {
//        AreaEntity area = areaLogic.ObtenerArea(id);
//        return new AreaDto(area);
//    }
//    
//    @POST
//    public AreaDto crearArea(AreaDto areaNueva) {
//        return new AreaDto(areaLogic.crearArea(areaNueva.toEntity()));
//    }
//    
//    @PUT
//    @Path("{id: \\d+}")
//    public AreaDto updateArea(@PathParam("id") long id, AreaDto areaDto) {
//        AreaEntity areaEntity = areaLogic.ObtenerArea(id);
//        if (areaEntity == null) {
//            throw new RuntimeException("No existe area");
//        } else {
//            areaLogic.actualizarArea(id, areaDto.toEntity());
//        }
//        return areaDto;
//    }
//    
//    @DELETE
//    @Path("{id: \\d+}")
//    public void delete(@PathParam("id") long id) {
//        AreaEntity areaEntity = areaLogic.ObtenerArea(id);
//        if (areaEntity == null) {
//            throw new RuntimeException("No existe el area");
//        } else {
//            areaLogic.borrarArea(id);
//        }
//    }
//}
// 