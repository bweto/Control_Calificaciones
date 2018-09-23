package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.FacultadEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que hace el mapeo relacional de objetos facultad entity a facultad Dto
 * @author Dayan olaya y Roberto Garcia
 */
public class FacultadDto {
    
     private long idFacultad;
     private String nombreFacultad;
     
    /*
     *Constructor basico
     */ 
    public FacultadDto() {
    }
    
    /*
    *Constructor para construir dto a partir de facultad entity
    */
    public FacultadDto(FacultadEntity facultad) {
        this.idFacultad = facultad.getIdFacultad();
        this.nombreFacultad = facultad.getNombreFacultad();
    }
    
    /*
    *crea un entidad a partir de una FacultadDto
    */
    public FacultadEntity toEntity(){
        FacultadEntity entity = new FacultadEntity();
        entity.setIdFacultad(this.idFacultad);
        entity.setNombreFacultad(this.nombreFacultad);
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos FacultadEntity
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
