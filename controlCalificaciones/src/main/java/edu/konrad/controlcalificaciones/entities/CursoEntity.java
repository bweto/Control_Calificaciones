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
 *Clase que se encarga de almacenar l ainfroamcion de los cursos.
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "curso")
public class CursoEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCurso;
    
    private long idProfesor;
    private long idGrupo;
    private long idTipoCurso;
    private long idNivel;
    @Column(name = "nombre_curso", nullable = false)
    private String nombreCurso;
//     @OneToMany( targetEntity = MateriInscritaEntity.class )
//     private List materiasInscritas;
    /*
    Constructor de la clase
    */

    public CursoEntity() {
    }
    
    /*
    getters and setters de los atributos de la clase
    */

    public long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(long idCurso) {
        this.idCurso = idCurso;
    }

    public long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public long getIdTipoCurso() {
        return idTipoCurso;
    }

    public void setIdTipoCurso(long idTipoCurso) {
        this.idTipoCurso = idTipoCurso;
    }

    public long getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(long idNivel) {
        this.idNivel = idNivel;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    
    
}
