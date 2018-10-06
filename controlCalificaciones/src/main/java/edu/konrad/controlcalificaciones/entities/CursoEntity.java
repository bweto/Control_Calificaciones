/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 *Clase que se encarga de almacenar l ainfroamcion de los cursos.
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "curso")
public class CursoEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCurso;
    @Column(name = "nombre_curso", nullable = false)
    private String nombreCurso;
    
    @ManyToOne
    @JoinColumn(name ="profesor")
    private ProfesorEntity profesor;
    
    @ManyToOne
    @JoinColumn(name ="grupo")
    private GrupoEntity grupo;
    
    @ManyToOne
    @JoinColumn(name ="tipo_curso")
    private TipoCursoEntity tipoCurso;
    
    @ManyToOne
    @JoinColumn(name ="nivel_academico")
    private NivelAcademicoEntity nivelAcademico;
    /*
    Constructor de la clase
    */

    public CursoEntity() {
    }
    
    /*
    getters and setters de los atributos de la clase
    */

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
