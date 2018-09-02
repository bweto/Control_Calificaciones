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
import javax.persistence.OneToOne;

/**
 *Clase encargada de almacenar la información sobre el programa al que pertenece
 * un estudiante, un coordinador y una materia.
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "programa")
public class ProgramaEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPrograma;
    private long idFacultad;
    @Column(name = "nombre_programa", nullable = false)
    private String nombrePrograma;
     /*
    *Relaciones uno a uno de la tabla programa con las tablas estudainteEntity
    */
//    @OneToOne
//    private EstudianteEntity estudiante;
//    @OneToOne
//    private CoordinadorEntity coordinador;
//     @OneToMany( targetEntity = TipoCursoEntity.class )
//     private List TipoCursos;
    /*
    Constructor de la clase
    */

    public ProgramaEntity() {
    }
    
    /*
    getters and setters de la clase
    */

    public long getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(long idPrograma) {
        this.idPrograma = idPrograma;
    }

    public long getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(long idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

//    public EstudianteEntity getEstudiante() {
//        return estudiante;
//    }
//
//    public void setEstudiante(EstudianteEntity estudiante) {
//        this.estudiante = estudiante;
//    }
//
//    public CoordinadorEntity getCoordinador() {
//        return coordinador;
//    }
//
//    public void setCoordinador(CoordinadorEntity coordinador) {
//        this.coordinador = coordinador;
//    }
//
//    public List getTipoCursos() {
//        return TipoCursos;
//    }
//
//    public void setTipoCursos(List TipoCursos) {
//        this.TipoCursos = TipoCursos;
//    }

}
