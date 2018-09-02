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
 * Clase encargada de almacenar la infromaciòn de los coordinadores
 *
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "coordinador")
public class CoordinadorEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCoordinador;
    
    private long idUsuario;
    private long idPrograma;

    /*
    Constructor de la clase
     */
    public CoordinadorEntity() {
    }
    /*
    getters and setters para los atributos de la clase
    */
    public long getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(long idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(long idPrograma) {
        this.idPrograma = idPrograma;
    }

}
