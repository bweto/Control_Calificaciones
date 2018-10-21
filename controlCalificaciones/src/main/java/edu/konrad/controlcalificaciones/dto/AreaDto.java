
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.AreaEntity;
//import edu.konrad.controlcalificaciones.entities.ProfesorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class AreaDto {

   
    
    private long idArea;
    private String nombreArea;
//    private ProfesorDto profesor;
    
    public AreaDto() {
    }

    public AreaDto(AreaEntity area) {
        this.idArea = area.getIdArea();
        this.nombreArea = area.getNombreArea();
//        if(area.getProfesor()!= null){
//           ProfesorEntity entity = new ProfesorEntity();
//           entity.setIdProfesor(area.getProfesor().getIdProfesor());
//           entity.setUsuario(area.getProfesor().getUsuario());
//           entity.setCantidadCursos(area.getProfesor().getCantidadCursos());
//           this.profesor = new ProfesorDto(entity);
//        }
    }
    
    
    public AreaEntity toEntity(){
        AreaEntity entity = new AreaEntity();
        entity.setIdArea(this.idArea);
        entity.setNombreArea(this.nombreArea);
//        entity.setProfesor(this.profesor.toEntity());
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos MateriInscritaEntity
    */
    public static List<AreaDto> toAreaDtoList(List<AreaEntity> areaList){
        List<AreaDto> areaDtoList = new ArrayList<>();
        for(AreaEntity entity : areaList){
            areaDtoList.add(new AreaDto(entity));
        }
        return areaDtoList;
    }
    
    
    public long getIdArea() {
        return idArea;
    }

    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
    
    
    
    
}
