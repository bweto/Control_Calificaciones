package edu.konrad.controlcalificaciones.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




/**
 *Clase que se encarga de almacenar l ainfroamcion de los cursos.
 * @author Dayan Olaya, Roberto Garcia
 */
@Entity(name = "curso")
public class CursoEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCurso;
    @Column(name = "nombre_curso", nullable = false)
    private String nombreCurso;
    
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

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }    
}
