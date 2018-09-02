
package edu.konrad.controlcalificaciones.dto;


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
    private long idInscripcion;
    /*
    id de estado
    */
    private long idEstado;
    /*
     id de calificacion
    */
    private long idCalificacion;
    
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
        this.idInscripcion = materia.getIdInscripcion();
        this.idEstado = materia.getIdEstado();
        this.idCalificacion = materia.getIdCalificacion();
    }
    
    /*
     Crear una mariaInscritaEntity con un objeto relacional
     @return MateriInscritaEntity
    */
    public MateriaInscritaEntity toEntity(){
        MateriaInscritaEntity entity = new MateriaInscritaEntity();
        entity.setIdMateria(this.idMateria);
        entity.setIdInscripcion(this.idInscripcion);
        entity.setIdEstado(this.idEstado);
        entity.setIdCalificacion(this.idCalificacion);
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

    public long getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(long idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(long idEstado) {
        this.idEstado = idEstado;
    }

    public long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }
    
    
}
