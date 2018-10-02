
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

    public static List<MateriaInscritaDto> toMateriaInscritaList(List<MateriaInscritaEntity> materiaInscrita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
     identificador de materia
    */
    private long idMateria;
    /*
     id de inscripcion
    */
    private InscripcionDto inscripcion;
    /*
    id de estado
    */
    private EstadoDto estado;
    /*
     id de calificacion
    */
    private CalificacionDto calificacion;
    
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
        if(materia.getInscripcion() != null){
            InscripcionEntity entity = new InscripcionEntity();
            entity.setCurso(materia.getInscripcion().getCurso());
            entity.setEstudiante(materia.getInscripcion().getEstudiante());
            entity.setIdInscripcion(materia.getInscripcion().getIdInscripcion());
            this.inscripcion = new InscripcionDto(entity);
        }
        if(materia.getEstado() != null){
         EstadoEntity entity = new EstadoEntity();
         entity.setIdEstado(materia.getEstado().getIdEstado());
         entity.setNombreEstado(materia.getEstado().getNombreEstado());
         this.estado = new EstadoDto(entity);
        }
        if(materia.getCalificacion() != null){
            CalificacionEntity entity = new CalificacionEntity();
            entity.setIdCalificacion(materia.getCalificacion().getIdCalificacion());
            entity.setPrimerCorte(materia.getCalificacion().getPrimerCorte());
            entity.setSegundoCorte(materia.getCalificacion().getSegundoCorte());
            entity.setTercerCorte(materia.getCalificacion().getTercerCorte());
            this.calificacion = new CalificacionDto(entity);
        }
        
    }
    
    /*
     Crear una mariaInscritaEntity con un objeto relacional
     @return MateriInscritaEntity
    */
    public MateriaInscritaEntity toEntity(){
        MateriaInscritaEntity entity = new MateriaInscritaEntity();
        entity.setIdMateria(this.idMateria);
        entity.setInscripcion(this.inscripcion.toEntity());
        entity.setEstado(this.estado.toEntity());
        entity.setCalificacion(this.calificacion.toEntity());
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos MateriInscritaEntity
    */
    public static List<MateriaInscritaDto> toMateriaDtoList(List<MateriaInscritaEntity> materiaList){
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

    public InscripcionDto getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(InscripcionDto inscripcion) {
        this.inscripcion = inscripcion;
    }

    public EstadoDto getEstado() {
        return estado;
    }

    public void setEstado(EstadoDto estado) {
        this.estado = estado;
    }

    public CalificacionDto getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(CalificacionDto calificacion) {
        this.calificacion = calificacion;
    }

    
    
    
}
