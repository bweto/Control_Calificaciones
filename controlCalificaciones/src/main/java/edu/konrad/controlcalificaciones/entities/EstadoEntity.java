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
 *Clase encargada de almacenar la información del estado de la materia 
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "estado")
public class EstadoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEstado;
    @Column(name = "nombre_estado", nullable = false)
    private String nombreEstado;
    
//     @OneToMany( targetEntity = CursoEntity.class )
//     private List cursos;
    /*
    constructor de la clase
    */

    public EstadoEntity() {
    }
    
    /*
    getters and setters de la clase
    */

    public long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
    
}
