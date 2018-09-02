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
 * Clase encargada de almacenar el rol del usuario, puede ser coordinador,
 * profesor o alumno.
 *
 * @author Dayan Olaya, Roberto garcia
 */
@Entity(name = "rol")
public class RolEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idRol;
    @Column(name = "nombre_rol", nullable = false)
    private String nombreRol;
     /*
    *relación uno a muchos tipoId con Usuario
    */
     @OneToMany( targetEntity = UsuarioEntity.class )
     private List usuarios;
     /*
    Constructor de la clase 
    */
    public RolEntity() {
    }
/*
    getters and setters de los atributos de la clase
    */
    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }

}
