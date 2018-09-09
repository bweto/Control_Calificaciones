
package edu.konrad.controlcalificaciones.dto;


import edu.konrad.controlcalificaciones.entities.CalificacionEntity;
import edu.konrad.controlcalificaciones.entities.EstadoEntity;
import edu.konrad.controlcalificaciones.entities.InscripcionEntity;
import edu.konrad.controlcalificaciones.entities.MateriaInscritaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase encargada de hacer el mapeo relacional de los objetos de tipo materia 
 * InscritaEntity
 * @author Dayan Olaya Roberto Garcia
 */
public class MateriaInscritaDto {
    
    /*
     identificador de materia
    */
    private long idMateria;
    /*
     id de inscripcion
    */
    private InscripcionEntity inscripcion;
    /*
    id de estado
    */
    private EstadoEntity estado;
    /*
     id de calificacion
    */
    private CalificacionEntity calificacion;
    
    /*
     Constructor basico
    */
    public MateriaInscritaDto() {
    }
    
    /*
     Constructor Que crea onbjeto relacional a partir de un objeto materiaInscrita
    Entity
    @param MateriInscritaEntity
    */
    public MateriaInscritaDto(MateriaInscritaEntity materia) {
        this.idMateria = materia.getIdMateria();
        this.inscripcion = materia.getInscripcion();
        this.estado = materia.getEstado();
        this.calificacion = materia.getCalificacion();
    }
    
    /*
     Crear una mariaInscritaEntity con un objeto relacional
     @return MateriInscritaEntity
    */
    public MateriaInscritaEntity toEntity(){
        MateriaInscritaEntity entity = new MateriaInscritaEntity();
        entity.setIdMateria(this.idMateria);
        entity.setInscripcion(this.inscripcion);
        entity.setEstado(this.estado);
        entity.setCalificacion(this.calificacion);
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos MateriInscritaEntity
    */
    public List<MateriaInscritaDto> toMateriaDtoList(List<MateriaInscritaEntity> materiaList){
        List<MateriaInscritaDto> materiaDtoList = new ArrayList<>();
        for(MateriaInscritaEntity entity : materiaList){
            materiaDtoList.add(new MateriaInscritaDto(entity));
        }
        return materiaDtoList;
    }
    
    /*
     getters and setters
    */

    public long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(long idMateria) {
        this.idMateria = idMateria;
    }

    public InscripcionEntity getIdInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(InscripcionEntity idInscripcion) {
        this.inscripcion = inscripcion;
    }

    public EstadoEntity getEstado() {
        return estado;
    }

    public void setEstado(EstadoEntity idEstado) {
        this.estado = estado;
    }

    public CalificacionEntity getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(CalificacionEntity calificacion) {
        this.calificacion = calificacion;
    }
    
    
}
