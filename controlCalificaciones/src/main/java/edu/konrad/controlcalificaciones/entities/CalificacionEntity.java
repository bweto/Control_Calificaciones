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
 *Clase encargada de almacenar la información de las calificaciones de las materias.
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "calificacion")
public class CalificacionEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCalificacion;
    @Column(name = "primer_corte", nullable = false)
    private int primerCorte;
    @Column(name = "segundo_corte", nullable = false)
    private int segundoCorte;
    @Column(name = "tercer_corte", nullable = false)
    private int tercerCorte;
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

    public int getPrimerCorte() {
        return primerCorte;
    }

    public void setPrimerCorte(int primerCorte) {
        this.primerCorte = primerCorte;
    }

    public int getSegundoCorte() {
        return segundoCorte;
    }

    public void setSegundoCorte(int segundoCorte) {
        this.segundoCorte = segundoCorte;
    }

    public int getTercerCorte() {
        return tercerCorte;
    }

    public void setTercerCorte(int tercerCorte) {
        this.tercerCorte = tercerCorte;
    }
    
    
}
