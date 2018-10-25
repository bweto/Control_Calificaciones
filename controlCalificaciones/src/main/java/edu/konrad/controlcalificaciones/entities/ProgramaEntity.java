
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
 *Clase encargada de almacenar la información sobre el programa al que pertenece
 * un estudiante, un coordinador y una materia.
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "programa")
public class ProgramaEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPrograma;
    @Column(name = "nombre_programa", nullable = false)
    private String nombrePrograma;
     /*
    *Relaciones muchos a uno de la tabla programa con la facultad
    */
    @ManyToOne
    @JoinColumn(name ="Facultad")
    private FacultadEntity facultad;
    
    @ManyToOne
    @JoinColumn(name ="nivel_academico")
    private NivelAcademicoEntity nivelAcademico;
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

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public FacultadEntity getFacultad() {
        return facultad;
    }

    public void setFacultad(FacultadEntity facultad) {
        this.facultad = facultad;
    }
 
    public NivelAcademicoEntity getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(NivelAcademicoEntity nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }
}
