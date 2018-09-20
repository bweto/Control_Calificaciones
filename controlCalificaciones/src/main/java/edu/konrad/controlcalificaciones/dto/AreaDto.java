
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.AreaEntity;
import edu.konrad.controlcalificaciones.entities.MateriaInscritaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bwto
 */
public class AreaDto {

    public static List<AreaDto> toAreaList(List<AreaEntity> areas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private long idArea;
    private String nombreArea;

    public AreaDto() {
    }

    public AreaDto(AreaEntity area) {
        this.idArea = area.getIdArea();
        this.nombreArea = area.getNombreArea();
    }
    
    
    public AreaEntity toEntity(){
        AreaEntity entity = new AreaEntity();
        entity.setIdArea(this.idArea);
        entity.setNombreArea(this.nombreArea);
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos MateriInscritaEntity
    */
    public List<AreaDto> toAreaDtoList(List<AreaEntity> areaList){
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
