
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.ProgramaEntity;
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
    private ProgramaEntity programa;
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
        this.programa = tipoCursoEntity.getPrograma();
        this.nombreTipoCurso = tipoCursoEntity.getNombreTipoCurso();
    }
    
    /*
    *Metodo para crear una entidad a partir de la relacion
    @retrun TipoCursoEntity entity
    */
    public TipoCursoEntity toEnntity(){
        TipoCursoEntity entity = new TipoCursoEntity();
        entity.setIdTipoCurso( this.idTipoCurso);
        entity.setPrograma(this.programa);
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

    public ProgramaEntity getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaEntity programa) {
        this.programa = programa;
    }

    public String getNombreTipoCurso() {
        return nombreTipoCurso;
    }

    public void setNombreTipoCurso(String nombreTipoCurso) {
        this.nombreTipoCurso = nombreTipoCurso;
    }
    
}
