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
 *Clase que contiene la información del tipo de identificación que puede tener 
 * un usuario
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "tipo_id")
public class TipoIdEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idTipoId;
    @Column(name = "nombre_tipo_id", nullable = false)
    private String nombreTipoId;
    
    
    /*
    *relación uno a muchos tipoId con Usuario
    */
     @OneToMany( targetEntity = UsuarioEntity.class )
     private List usuarios;
     /*
    Constructor de la clase 
    */
    public TipoIdEntity() {
    }
    /*
     getters and setters para los atributos de la clase.
    */
    public long getIdTipoId() {
        return idTipoId;
    }

    public void setIdTipoId(long idTipoId) {
        this.idTipoId = idTipoId;
    }

    public String getNombreTipoId() {
        return nombreTipoId;
    }

    public void setNombreTipoId(String nombreTipoId) {
        this.nombreTipoId = nombreTipoId;
    }

    public List getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}
