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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/**
 *
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "usuario")
public class UsuarioEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUsuario;
    @Column(name = "numero_id", nullable = false)
    private int numeroId;
    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario;
    @Column(name = "apellido_usuario", nullable = false)
    private String apellidoUsuario;
    @Column(name = "genero", nullable = false)
    private String genero;
    @Column(name = "email", nullable = false)
    private String email;
    
    /*
    *Relaciones uno a muchos de la tabla usuario con las tablas tipoId y rol.  
    */
    @ManyToOne
    @JoinColumn(name ="tipo_id")
    private TipoIdEntity tipoId;
      
    @ManyToOne
    @JoinColumn(name ="rol")
    private RolEntity rol;
   
    /*
    Constructor de la clase 
    */
    public UsuarioEntity() {
    }
    
    
    /*
    getters and setters de los atributos de la clase 
    */

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoIdEntity getTipoId() {
        return tipoId;
    }

    public void setTipoId(TipoIdEntity tipoId) {
        this.tipoId = tipoId;
    }

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

}
