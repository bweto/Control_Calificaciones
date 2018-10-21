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
 *Clase donde se almacena la informaciòn de un profesor.
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "profesor")
public class ProfesorEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProfesor;
    @Column(name = "cantidad_cursos", nullable = false)
    private int cantidadCursos;
    /*
    *Relaciones uno a muchos entre profesores y curso
    */
    @ManyToOne
    @JoinColumn(name ="usuario")
    private UsuarioEntity usuario;
    @ManyToOne
    @JoinColumn(name ="area")
    private AreaEntity area;
    /*
    Constructor de la clase
    */
    public ProfesorEntity() {
    }

    /*
    getters and setters para la clase.
    */
    public long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(long idProfesor) {
        this.idProfesor = idProfesor;
    }
    
    public int getCantidadCursos() {
        return cantidadCursos;
    }

    public void setCantidadCursos(int cantidadCursos) {
        this.cantidadCursos = cantidadCursos;
    }   

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public AreaEntity getArea() {
        return area;
    }

    public void setArea(AreaEntity area) {
        this.area = area;
    }
    
    
}
