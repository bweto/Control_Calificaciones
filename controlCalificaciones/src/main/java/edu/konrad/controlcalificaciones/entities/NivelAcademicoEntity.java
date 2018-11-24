/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *Clase que almacena la información del nivel academico del curso
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "nivel_academico")
public class NivelAcademicoEntity implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idNivelAcademico;
     @Column(name = "nombre_nivel", nullable = false)
    private String nombreNivelAcademico;
//     @OneToMany( targetEntity = CursoEntity.class )
//     private List cursos;
    /*
    Constructor de la clase
    */

    public NivelAcademicoEntity() {
    }
    
    /*
    getters and setters de la clase
    */

    public long getIdNivelAcademico() {
        return idNivelAcademico;
    }

    public void setIdNivelAcademico(long idNivelAcademico) {
        this.idNivelAcademico = idNivelAcademico;
    }

    public String getNombreNivelAcademico() {
        return nombreNivelAcademico;
    }

    public void setNombreNivelAcademico(String nombreNivelAcademico) {
        this.nombreNivelAcademico = nombreNivelAcademico;
    }
//
//    public List getCursos() {
//        return cursos;
//    }
//
//    public void setCursos(List cursos) {
//        this.cursos = cursos;
//    }
    
    
}
