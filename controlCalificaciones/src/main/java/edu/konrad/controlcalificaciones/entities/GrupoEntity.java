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
 *Clase donde se almacena la información del grupo al que pertenece un curso.
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "grupo")
public class GrupoEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idGrupo;
    @Column(name = "horario", nullable = false)
    private String horario;
    @Column(name = "cupo", nullable = false)
    private int cupo;
    
    @ManyToOne
    @JoinColumn(name="profesor")
    private ProfesorEntity profesor;
    
//    @ManyToOne
//    @JoinColumn(name="curso")
//    private CursoEntity curso;
    /*
    *
    */
    
//     @OneToMany( targetEntity = CursoEntity.class )
//     private List cursos;
    /*
    constructor de clase
    */

    public GrupoEntity() {
    }
    
    /*
    getters and setters de los atrinutos de la clase 
    */

    public long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public ProfesorEntity getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorEntity profesor) {
        this.profesor = profesor;
    }

//    public CursoEntity getCurso() {
//        return curso;
//    }
//
//    public void setCurso(CursoEntity curso) {
//        this.curso = curso;
//    }
    
    
    
}
