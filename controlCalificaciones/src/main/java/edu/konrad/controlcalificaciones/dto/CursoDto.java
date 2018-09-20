/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.CursoEntity;
import edu.konrad.controlcalificaciones.entities.GrupoEntity;
import edu.konrad.controlcalificaciones.entities.MateriaInscritaEntity;
import edu.konrad.controlcalificaciones.entities.NivelAcademicoEntity;
import edu.konrad.controlcalificaciones.entities.ProfesorEntity;
import edu.konrad.controlcalificaciones.entities.TipoCursoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bwto
 */
public class CursoDto {
    
    private long idCurso;
    private String nombreCurso;
    private ProfesorEntity profesor;
    private GrupoEntity grupo;
    private TipoCursoEntity tipoCurso;
    private NivelAcademicoEntity nivelAcademico;

    public CursoDto() {
    }

    public CursoDto(CursoEntity curso) {
        this.idCurso = curso.getIdCurso();
        this.nombreCurso = curso.getNombreCurso();
        this.profesor = curso.getProfesor();
        this.grupo = curso.getGrupo();
        this.tipoCurso = curso.getTipoCurso();
        this.nivelAcademico = curso.getNivelAcademico();
    }
    
     public CursoEntity toEntity(){
        CursoEntity entity = new CursoEntity();
        entity.setIdCurso(this.idCurso);
        entity.setNivelAcademico(this.nivelAcademico);
        entity.setNombreCurso(this.nombreCurso);
        entity.setProfesor(this.profesor);
        entity.setGrupo(this.grupo);
        entity.setTipoCurso(this.tipoCurso);
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos MateriInscritaEntity
    */
    public List<CursoDto> toCursoDtoList(List<CursoEntity> cursoList){
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

    public ProfesorEntity getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorEntity profesor) {
        this.profesor = profesor;
    }

    public GrupoEntity getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoEntity grupo) {
        this.grupo = grupo;
    }

    public TipoCursoEntity getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(TipoCursoEntity tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public NivelAcademicoEntity getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(NivelAcademicoEntity nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }
    
    
    
    
}
