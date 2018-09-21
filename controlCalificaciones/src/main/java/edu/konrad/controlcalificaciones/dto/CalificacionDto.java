
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.CalificacionEntity;
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
    private int primerCorte;
    /*
    Nota del segundo corte
    */
    private int segundoCorte;
    /*
    Nota del tercer corte
    */
    private int tercerCorte;
    
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
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos CalificacionEntity
    */
    public List<CalificacionDto> toMateriaDtoList(List<CalificacionEntity> calificacionList){
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
