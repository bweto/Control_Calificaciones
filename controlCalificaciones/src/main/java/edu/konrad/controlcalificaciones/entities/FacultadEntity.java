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
 *Clase encargada de almacenar la infromación sobre la facultad a la cual
 * pertenece un programa
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "facultad")
public class FacultadEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idFacultad;
    @Column(name = "nombre_facultad", nullable = false)
    private String nombreFacultad;
     /*
    *relación uno a muchos facultad con programa
    */
//     @OneToMany( targetEntity = ProgramaEntity.class )
//     private List programas;
    /*
    constructor e la clase
    */

    public FacultadEntity() {
    }
    
    /*
    getters and setters de la clase
    */

    public long getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(long idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    
}
