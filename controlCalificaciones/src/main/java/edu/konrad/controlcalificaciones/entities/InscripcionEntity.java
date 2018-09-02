/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *Clase donde se almacena la informacion de 
 * @author Dayan Olaya, Roberto Garcia 
 */
@Entity(name = "isncripcion")
public class InscripcionEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idInscripcion;
    private long idCurso;
    private long idEstudiante;
//     @OneToMany( targetEntity = MateriInscritaEntity.class )
//     private List materiaInscrita;
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

    public long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(long idCurso) {
        this.idCurso = idCurso;
    }

    public long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    
}
