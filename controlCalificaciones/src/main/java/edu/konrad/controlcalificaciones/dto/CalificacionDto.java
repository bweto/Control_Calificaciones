
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.CalificacionEntity;
import edu.konrad.controlcalificaciones.entities.EstadoEntity;
import edu.konrad.controlcalificaciones.entities.InscripcionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase Dto para realizar el mapeo relacional de la información de las 
 * calificaciones
 * @author Dayan Olaya y Roberto Garcia
 */
public class CalificacionDto {

   
    /*      
    Identificación de la calificación
    */
    private long idCalificacion;
    /*
    Nota del primer corte
    */
    private float primerCorte;
    /*
    Nota del segundo corte
    */
    private float segundoCorte;
    /*
    Nota del tercer corte
    */
    private float tercerCorte;
    
    /*
     id de inscripcion
    */
    private InscripcionDto inscripcion;
    /*
    id de estado
    */
    private EstadoDto estado;
    /*
    Constructor basico de la clase 
    */
    public CalificacionDto() {
    }
    
    /*
    Constructor parametrico, apartir de una entidad calificación
    */
    public CalificacionDto(CalificacionEntity calificacion) {
        this.idCalificacion = calificacion.getIdCalificacion();
        this.primerCorte = calificacion.getPrimerCorte();
        this.segundoCorte = calificacion.getSegundoCorte();
        this.tercerCorte = calificacion.getTercerCorte();
        if(calificacion.getInscripcion() != null){
            InscripcionEntity entity = new InscripcionEntity();
            entity.setCurso(calificacion.getInscripcion().getCurso());
            entity.setEstudiante(calificacion.getInscripcion().getEstudiante());
            entity.setIdInscripcion(calificacion.getInscripcion().getIdInscripcion());
            this.inscripcion = new InscripcionDto(entity);
        }
        if(calificacion.getEstado() != null){
         EstadoEntity entity = new EstadoEntity();
         entity.setIdEstado(calificacion.getEstado().getIdEstado());
         entity.setNombreEstado(calificacion.getEstado().getNombreEstado());
         this.estado = new EstadoDto(entity);
        }
    }
    
    /*
    Crear un Dto apartir de una entidad calificación
    */
    
    public CalificacionEntity toEntity(){
        CalificacionEntity entity = new CalificacionEntity();
        entity.setIdCalificacion(this.idCalificacion);
        entity.setPrimerCorte(this.primerCorte);
        entity.setSegundoCorte(this.segundoCorte);
        entity.setTercerCorte(this.tercerCorte);
        entity.setInscripcion(this.inscripcion.toEntity());
        entity.setEstado(this.estado.toEntity());
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos CalificacionEntity
    */
    public static List<CalificacionDto> toMateriaDtoList(List<CalificacionEntity> calificacionList){
        List<CalificacionDto> calificacionDtoList = new ArrayList<>();
        for(CalificacionEntity entity : calificacionList){
            calificacionDtoList.add(new CalificacionDto(entity));
        }
        return calificacionDtoList;
    }

    public long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public float getPrimerCorte() {
        return primerCorte;
    }

    public void setPrimerCorte(int primerCorte) {
        this.primerCorte = primerCorte;
    }

    public float getSegundoCorte() {
        return segundoCorte;
    }

    public void setSegundoCorte(int segundoCorte) {
        this.segundoCorte = segundoCorte;
    }

    public float getTercerCorte() {
        return tercerCorte;
    }

    public void setTercerCorte(int tercerCorte) {
        this.tercerCorte = tercerCorte;
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
    
    
}
