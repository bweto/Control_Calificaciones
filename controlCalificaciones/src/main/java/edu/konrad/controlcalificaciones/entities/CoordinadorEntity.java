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
 * Clase encargada de almacenar la infromaciòn de los coordinadores
 *
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "coordinador")
public class CoordinadorEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCoordinador;
    
    @ManyToOne
    @JoinColumn(name ="usuario")
    private UsuarioEntity usuario;
    @ManyToOne
    @JoinColumn(name ="programa")
    private ProgramaEntity programa;
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

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public ProgramaEntity getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaEntity programa) {
        this.programa = programa;
    }

}
