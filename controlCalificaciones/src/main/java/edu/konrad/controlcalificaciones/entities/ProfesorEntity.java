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
 *Clase donde se almacena la informaciòn de un profesor.
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "profesor")
public class ProfesorEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProfesor;
    private long idUsuario;
    private long idArea;
    @Column(name = "cantidad_cursos", nullable = false)
    private int cantidadCursos;
    /*
    *Relaciones uno a muchos entre profesores y curso
    */
     @OneToMany( targetEntity = CursoEntity.class )
     private List cursos;
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

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdArea() {
        return idArea;
    }

    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }

    public int getCantidadCursos() {
        return cantidadCursos;
    }

    public void setCantidadCursos(int cantidadCursos) {
        this.cantidadCursos = cantidadCursos;
    }

    public List getCursos() {
        return cursos;
    }

    public void setCursos(List cursos) {
        this.cursos = cursos;
    }
    
    
    
    
    
    
}
