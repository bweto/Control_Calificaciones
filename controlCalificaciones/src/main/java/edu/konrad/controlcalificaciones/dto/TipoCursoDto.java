
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

    public static List<TipoCursoDto> toTipoCursoList(List<TipoCursoEntity> tipoCurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    *id tipo de curso 
    */
    private long idTipoCurso;
    /*
    *id programa 
    */
    private ProgramaDto programa;
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
        this.nombreTipoCurso = tipoCursoEntity.getNombreTipoCurso();
        if(tipoCursoEntity.getPrograma() != null){
            ProgramaEntity entity = new ProgramaEntity();
            entity.setFacultad(tipoCursoEntity.getPrograma().getFacultad());
            entity.setIdPrograma(tipoCursoEntity.getPrograma().getIdPrograma());
            entity.setNombrePrograma(tipoCursoEntity.getPrograma().getNombrePrograma());
            this.programa = new ProgramaDto(entity);
        }
      
    }
    
    /*
    *Metodo para crear una entidad a partir de la relacion
    @retrun TipoCursoEntity entity
    */
    public TipoCursoEntity toEnntity(){
        TipoCursoEntity entity = new TipoCursoEntity();
        entity.setIdTipoCurso( this.idTipoCurso);
        entity.setPrograma(this.programa.toEntity());
        entity.setNombreTipoCurso(this.nombreTipoCurso);
        return entity;
    }
    
    /*
    *Metodo para crear una lista con todas las relaciones
    *@param List<TipoCursoEntity> tipoCursoEntityList
    *@return List<TipoCursoDto>
    */
    public static List<TipoCursoDto> toTipopCursoList(List<TipoCursoEntity> tipoCursoEntityList){
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

    

    public String getNombreTipoCurso() {
        return nombreTipoCurso;
    }

    public void setNombreTipoCurso(String nombreTipoCurso) {
        this.nombreTipoCurso = nombreTipoCurso;
    }

    public ProgramaDto getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaDto programa) {
        this.programa = programa;
    }

    public TipoCursoEntity toEntity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
