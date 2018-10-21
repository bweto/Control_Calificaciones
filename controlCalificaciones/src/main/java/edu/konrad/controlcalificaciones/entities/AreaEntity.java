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
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

/**
 *Clase encargada de almacenar la informaciòn sobre el area de profundisaciòn de
 * los profesores.
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "area")
public class AreaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idArea;
    @Column(name = "nombre_area", nullable = false)
    private String nombreArea;
//    @ManyToOne
//    @JoinColumn(name ="profesor")
//    private ProfesorEntity profesor;
    /*
    Constructor de la clase
    */
    public AreaEntity() {
    }
    
    /*
    getters and setters para los atributos de la clase
    */

    public long getIdArea() {
        return idArea;
    }

    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

//    public ProfesorEntity getProfesor() {
//        return profesor;
//    }
//
//    public void setProfesor(ProfesorEntity profesor) {
//        this.profesor = profesor;
//    }
    
    
    
}
