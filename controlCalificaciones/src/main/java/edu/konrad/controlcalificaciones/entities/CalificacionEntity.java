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
 *Clase encargada de almacenar la información de las calificaciones de las materias.
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "calificacion")
public class CalificacionEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCalificacion;
    @Column(name = "primer_corte", nullable = false)
    private float primerCorte;
    @Column(name = "segundo_corte", nullable = false)
    private float segundoCorte;
    @Column(name = "tercer_corte", nullable = false)
    private float tercerCorte;
     @ManyToOne
    @JoinColumn(name ="inscripcion")
    private InscripcionEntity inscripcion;
    
    @ManyToOne
    @JoinColumn(name ="estado")
    private EstadoEntity estado;
//     @OneToMany( targetEntity = MateriInscritaEntity.class )
//     private List materiasInscritas;
    /*
    Constructor de la clase
    */

    public CalificacionEntity() {
    }
    /*
    getters and setters de los atributas de la clase
    */

    public long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public float getPrimerCorte() {
        return primerCorte;
    }

    public void setPrimerCorte(float primerCorte) {
        this.primerCorte = primerCorte;
    }

    public float getSegundoCorte() {
        return segundoCorte;
    }

    public void setSegundoCorte(float segundoCorte) {
        this.segundoCorte = segundoCorte;
    }

    public float getTercerCorte() {
        return tercerCorte;
    }

    public void setTercerCorte(float tercerCorte) {
        this.tercerCorte = tercerCorte;
    }
    
    public InscripcionEntity getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(InscripcionEntity inscripcion) {
        this.inscripcion = inscripcion;
    }

    public EstadoEntity getEstado() {
        return estado;
    }

    public void setEstado(EstadoEntity estado) {
        this.estado = estado;
    }
    
}
