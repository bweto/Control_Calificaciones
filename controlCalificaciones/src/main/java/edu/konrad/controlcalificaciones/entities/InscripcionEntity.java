/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 *Clase donde se almacena la informacion de 
 * @author Dayan Olaya, Roberto Garcia 
 */
@Entity(name = "inscripcion")
public class InscripcionEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idInscripcion;
    
    @ManyToOne
    @JoinColumn(name ="curso")
    private CursoEntity curso;
    
//    @ManyToOne
//    @JoinColumn(name ="estudiante")
//    private EstudianteEntity estudiante;

    /*
    Constructor de la clase
    */

    public InscripcionEntity() {
    }
    
    /*
    getters and setters de los atributos de la clase
    
    */

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

//    public EstudianteEntity getEstudiante() {
//        return estudiante;
//    }
//
//    public void setEstudiante(EstudianteEntity estudiante) {
//        this.estudiante = estudiante;
//    }
    
    
    
}
