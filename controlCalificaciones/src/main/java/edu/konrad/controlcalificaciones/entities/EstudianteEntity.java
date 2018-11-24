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
 *Clase donde se almacena la informaciòn de los estudiantes.
 * @author Dayan olaya, Roberto Garcia
 */
@Entity(name = "estudiante")
public class EstudianteEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEstudiante;
    @Column(name = "codigo_estudiante", nullable = false)
    private int codigoEstudiante;
    @Column(name = "cantidad_materias", nullable = false)
    private int cantidadMaterias;
    
    /*
    *relación uno a muchos estudiante con inscripción
    */
    @ManyToOne
    @JoinColumn(name ="usuario")
    private UsuarioEntity usuario;
    
    @ManyToOne
    @JoinColumn(name ="programa")
    private ProgramaEntity programa;
    /*
    Constructor de la clase
    */
    public EstudianteEntity() {
    }
    
    /*
    getters and setters de los atributos de la clase.
    */
    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(int cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
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
