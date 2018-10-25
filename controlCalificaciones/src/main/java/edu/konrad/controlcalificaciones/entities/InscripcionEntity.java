
package edu.konrad.controlcalificaciones.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 *Clase donde se almacena la informacion de 
 * @author Dayan Olaya, Roberto Garcia 
 */
@Entity(name = "inscripcion")
public class InscripcionEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idInscripcion;
    
    @ManyToOne
    @JoinColumn(name ="grupo")
    private GrupoEntity grupo;
    
    @ManyToOne
    @JoinColumn(name ="estudiante")
    private EstudianteEntity estudiante;

    /*
    Constructor de la clase
    */

    public InscripcionEntity() {
    }
    
    /*
    getters and setters de los atributos de la clase
    
    */

    public long getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(long idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    
    public EstudianteEntity getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteEntity estudiante) {
        this.estudiante = estudiante;
    }

    public GrupoEntity getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoEntity grupo) {
        this.grupo = grupo;
    }
    
    
    
}
