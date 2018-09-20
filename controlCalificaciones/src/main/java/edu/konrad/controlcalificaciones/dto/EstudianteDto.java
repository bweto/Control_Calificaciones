/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.EstudianteEntity;
import edu.konrad.controlcalificaciones.entities.MateriaInscritaEntity;
import edu.konrad.controlcalificaciones.entities.ProgramaEntity;
import edu.konrad.controlcalificaciones.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bwto
 */
public class EstudianteDto {
    
     private long idEstudiante;
     private int codigoEstudiante;
     private int cantidadMaterias;
     private UsuarioEntity usuario;
     private ProgramaEntity programa;

    public EstudianteDto() {
    }

    public EstudianteDto(EstudianteEntity estudiante) {
        this.idEstudiante = estudiante.getIdEstudiante();
        this.codigoEstudiante = estudiante.getCodigoEstudiante();
        this.cantidadMaterias = estudiante.getCantidadMaterias();
        this.usuario = estudiante.getUsuario();
        this.programa = estudiante.getPrograma();
    }
    
    public EstudianteEntity toEntity(){
        EstudianteEntity entity = new EstudianteEntity();
        entity.setIdEstudiante(this.idEstudiante);
        entity.setCantidadMaterias(this.cantidadMaterias);
        entity.setUsuario(this.usuario);
        entity.setPrograma(this.programa);
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos MateriInscritaEntity
    */
    public List<EstudianteDto> toEstudianteDtoList(List<EstudianteEntity> estudianteList){
        List<EstudianteDto> estudianteDtoList = new ArrayList<>();
        for(EstudianteEntity entity : estudianteList){
            estudianteDtoList.add(new EstudianteDto(entity));
        }
        return estudianteDtoList;
    }

    public long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(int cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public ProgramaEntity getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaEntity programa) {
        this.programa = programa;
    }
    
    
     
     
}
