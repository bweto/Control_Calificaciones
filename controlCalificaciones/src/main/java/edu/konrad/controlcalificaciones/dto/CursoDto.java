package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.CursoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 Clase Dto para realizar el mapeo relacional de la información de los
 * cursos
 * @author Dayan olaya y Roberto Garcia
 */
public class CursoDto {

    public static List<CursoDto> toCursoList(List<CursoEntity> curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private long idCurso;
    private String nombreCurso;
    
    /*
    *Constructor basico
    */
    public CursoDto() {
    }
    
    /*
    *crear un Dto a partir de un entity
    */
    public CursoDto(CursoEntity curso) {
        this.idCurso = curso.getIdCurso();
        this.nombreCurso = curso.getNombreCurso();
        }
        
 
    
    /*
    *crear un entity apartir de un dto
    */
     public CursoEntity toEntity(){
        CursoEntity entity = new CursoEntity();
        entity.setIdCurso(this.idCurso);
        entity.setNombreCurso(this.nombreCurso);
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos cursoEntity
    */
    public static List<CursoDto> toCursoDtoList(List<CursoEntity> cursoList){
        List<CursoDto> cursoDtoList = new ArrayList<>();
        for(CursoEntity entity : cursoList){
            cursoDtoList.add(new CursoDto(entity));
        }
        return cursoDtoList;
    }
    
    public long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

}
