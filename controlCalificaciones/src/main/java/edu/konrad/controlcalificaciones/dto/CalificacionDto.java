/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.CalificacionEntity;
import edu.konrad.controlcalificaciones.entities.MateriaInscritaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bwto
 */
public class CalificacionDto {
    
    private long idCalificacion;
    private int primerCorte;
    private int segundoCorte;
    private int tercerCorte;

    public CalificacionDto() {
    }

    public CalificacionDto(CalificacionEntity calificacion) {
        this.idCalificacion = calificacion.getIdCalificacion();
        this.primerCorte = calificacion.getPrimerCorte();
        this.segundoCorte = calificacion.getSegundoCorte();
        this.tercerCorte = calificacion.getTercerCorte();
    }
    
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
     de objetos MateriInscritaEntity
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
