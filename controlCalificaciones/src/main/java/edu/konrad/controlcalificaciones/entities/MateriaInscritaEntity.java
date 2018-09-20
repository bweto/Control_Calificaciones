/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *Clase donde se almacena la infroamcion de los cursos inscritos
 * @author dayan Olaya, Roberto Garcia
 */
@Entity(name = "materia_inscrita")
public class MateriaInscritaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMateria;

    @ManyToOne
    @JoinColumn(name ="inscripcion")
    private InscripcionEntity inscripcion;
    
    @ManyToOne
    @JoinColumn(name ="estado")
    private EstadoEntity estado;
    
    @ManyToOne
    @JoinColumn(name ="calificacion")
    private CalificacionEntity calificacion;
    /*
    constructor de la clase
    */

    public MateriaInscritaEntity() {
    }
    /*
    getters and setters de los atributos de la clase
    */

    public long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(long idMateria) {
        this.idMateria = idMateria;
    }

    public InscripcionEntity getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(InscripcionEntity inscripcion) {
        this.inscripcion = inscripcion;
    }

    public EstadoEntity getEstado() {
        return estado;
    }

    public void setEstado(EstadoEntity estado) {
        this.estado = estado;
    }

    public CalificacionEntity getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(CalificacionEntity calificacion) {
        this.calificacion = calificacion;
    }

    
    
}
