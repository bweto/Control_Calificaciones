/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.CursoEntity;
import edu.konrad.controlcalificaciones.entities.EstudianteEntity;
import edu.konrad.controlcalificaciones.entities.InscripcionEntity;
import edu.konrad.controlcalificaciones.entities.MateriaInscritaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase encargada de hacer el mapeo relacional de los objetos de tipo inscripción 
 * 
 * @author Dayan Olaya Roberto Garcia
 */
public class InscripcionDto {
    
    private long idInscripcion;
     
    private CursoEntity curso;
     
    private EstudianteEntity estudiante;

    public InscripcionDto() {
    }

    public InscripcionDto(InscripcionEntity inscripcion) {
        this.idInscripcion = inscripcion.getIdInscripcion();
        this.curso = inscripcion.getCurso();
        this.estudiante = inscripcion.getEstudiante();
    }
    
    /*
     Crear una mariaInscritaEntity con un objeto relacional
     @return MateriInscritaEntity
    */
    public InscripcionEntity toEntity(){
        InscripcionEntity entity = new InscripcionEntity();
        entity.setIdInscripcion(this.idInscripcion);
        entity.setCurso(this.curso);
        entity.setEstudiante(this.estudiante);
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos MateriInscritaEntity
    */
    public List<InscripcionDto> toInscripcionDtoList(List<InscripcionEntity> inscripcionList){
        List<InscripcionDto> inscripcionDtoList = new ArrayList<>();
        for(InscripcionEntity entity : inscripcionList){
            inscripcionDtoList.add(new InscripcionDto(entity));
        }
        return inscripcionDtoList;
    }

    public long getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(long idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public CursoEntity getCurso() {
        return curso;
    }

    public void setCurso(CursoEntity curso) {
        this.curso = curso;
    }

    public EstudianteEntity getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteEntity estudiante) {
        this.estudiante = estudiante;
    }
    
    
    
}
