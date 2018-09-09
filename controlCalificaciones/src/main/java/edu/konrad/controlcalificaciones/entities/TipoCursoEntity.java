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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *Clase encargada de almacenar el tipo al que pertenece el curso si es de pregrado
 * o posgrado
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "tipo_curso")
public class TipoCursoEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idTipoCurso;
    @Column(name = "nombre_tipo_curso", nullable = false)
    private String nombreTipoCurso;
    
    @ManyToOne
    @JoinColumn(name ="programa")
    private ProgramaEntity programa;
    /*
    Constructor de la clase
    */

    public TipoCursoEntity() {
    }
    /*
    getters and setters para los atributos de la clase
    */

    public long getIdTipoCurso() {
        return idTipoCurso;
    }

    public void setIdTipoCurso(long idTipoCurso) {
        this.idTipoCurso = idTipoCurso;
    }

    public String getNombreTipoCurso() {
        return nombreTipoCurso;
    }

    public void setNombreTipoCurso(String nombreTipoCurso) {
        this.nombreTipoCurso = nombreTipoCurso;
    }

    public ProgramaEntity getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaEntity programa) {
        this.programa = programa;
    }

    
    
}
