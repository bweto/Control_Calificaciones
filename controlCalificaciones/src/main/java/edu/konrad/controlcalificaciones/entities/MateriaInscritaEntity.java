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

/**
 *Clase donde se almacena la infroamcion de los cursos inscritos
 * @author dayan Olaya, Roberto Garcia
 */
@Entity(name = "materia_inscrita")
public class MateriaInscritaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMateria;
    private long idInscripcion;
    private long idEstado;
    private long idCalificacion;
    
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

    public long getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(long idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(long idEstado) {
        this.idEstado = idEstado;
    }

    public long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }
    
}
