
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.TipoCursoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que realiza el mapeo relacional 
 * @author Dayan Olaya, Roberto Garcia
 */
public class TipoCursoDto {
    
    /*
    *id tipo de curso 
    */
    private long idTipoCurso;
    /*
    *id programa 
    */
    private long idprograma;
    /*
    *nombre del tipo de curso
    */
    private String nombreTipoCurso;
    
    /*
    *Constructor basico
    */
    public TipoCursoDto() {
    }
    
    /*
    *Constructo de dto a partir de una entity
    *@param TipoCursoEntity tipoCursoEntity 
    */
    public TipoCursoDto( TipoCursoEntity tipoCursoEntity){
        this.idTipoCurso = tipoCursoEntity.getIdTipoCurso();
        this.idprograma = tipoCursoEntity.getIdprograma();
        this.nombreTipoCurso = tipoCursoEntity.getNombreTipoCurso();
    }
    
    /*
    *Metodo para crear una entidad a partir de la relacion
    @retrun TipoCursoEntity entity
    */
    public TipoCursoEntity toEnntity(){
        TipoCursoEntity entity = new TipoCursoEntity();
        entity.setIdTipoCurso( this.idTipoCurso);
        entity.setIdprograma(this.idprograma);
        entity.setNombreTipoCurso(this.nombreTipoCurso);
        return entity;
    }
    
    /*
    *Metodo para crear una lista con todas las relaciones
    *@param List<TipoCursoEntity> tipoCursoEntityList
    *@return List<TipoCursoDto>
    */
    public List<TipoCursoDto> toTipopCursoList(List<TipoCursoEntity> tipoCursoEntityList){
       List<TipoCursoDto> tipoCursoDtoList = new ArrayList<>();
       for(TipoCursoEntity entity : tipoCursoEntityList){
           tipoCursoDtoList.add(new TipoCursoDto(entity));
       }
        return tipoCursoDtoList;
    }
    
    /*
    *getters and setters
    */

    public long getIdTipoCurso() {
        return idTipoCurso;
    }

    public void setIdTipoCurso(long idTipoCurso) {
        this.idTipoCurso = idTipoCurso;
    }

    public long getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(long idprograma) {
        this.idprograma = idprograma;
    }

    public String getNombreTipoCurso() {
        return nombreTipoCurso;
    }

    public void setNombreTipoCurso(String nombreTipoCurso) {
        this.nombreTipoCurso = nombreTipoCurso;
    }
    
}
