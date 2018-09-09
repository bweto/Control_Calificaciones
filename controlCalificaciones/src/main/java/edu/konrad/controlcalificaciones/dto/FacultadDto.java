/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.FacultadEntity;
import edu.konrad.controlcalificaciones.entities.MateriaInscritaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bwto
 */
public class FacultadDto {
    
     private long idFacultad;
     private String nombreFacultad;

    public FacultadDto() {
    }

    public FacultadDto(FacultadEntity facultad) {
        this.idFacultad = facultad.getIdFacultad();
        this.nombreFacultad = facultad.getNombreFacultad();
    }
    
    public FacultadEntity toEntity(){
        FacultadEntity entity = new FacultadEntity();
        entity.setIdFacultad(this.idFacultad);
        entity.setNombreFacultad(this.nombreFacultad);
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos MateriInscritaEntity
    */
    public List<FacultadDto> toFacultadDtoList(List<FacultadEntity> facultadList){
        List<FacultadDto> facultadDtoList = new ArrayList<>();
        for(FacultadEntity entity : facultadList){
            facultadDtoList.add(new FacultadDto(entity));
        }
        return facultadDtoList;
    }

     
     
    public long getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(long idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }
     
     
}
