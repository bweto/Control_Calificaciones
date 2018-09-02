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
 *Clase donde se almacena la informaciòn de los estudiantes.
 * @author Dayan olaya, Roberto Garcia
 */
@Entity(name = "estudiante")
public class EstudianteEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEstudiante;
    private long idPrograma;
    private long idUsuario;
    @Column(name = "primer_corte", nullable = false)
    private int cantidadMaterias;
    
    /*
    *relación uno a muchos estudiante con inscripción
    */
    @OneToMany( targetEntity = InscripcionEntity.class )
     private List Inscripciones;
    
    /*
    Constructor de la clase
    */
    public EstudianteEntity() {
    }
    
    /*
    getters and setters de los atributos de la clase.
    */
    public long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public long getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(long idPrograma) {
        this.idPrograma = idPrograma;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(int cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public List getInscripciones() {
        return Inscripciones;
    }

    public void setInscripciones(List Inscripciones) {
        this.Inscripciones = Inscripciones;
    }
    
    
    
    
   
}
