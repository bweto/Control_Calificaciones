/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.EstadoEntity;
import edu.konrad.controlcalificaciones.entities.MateriaInscritaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bwto
 */
public class EstadoDto {
    
    private long idEstado;
    private String nombreEstado;

    public EstadoDto() {
    }

    public EstadoDto(EstadoEntity estado) {
        this.idEstado = estado.getIdEstado();
        this.nombreEstado = estado.getNombreEstado();
    }

    /*
     Crear una mariaInscritaEntity con un objeto relacional
     @return MateriInscritaEntity
    */
    public EstadoEntity toEntity(){
        EstadoEntity entity = new EstadoEntity();
        entity.setIdEstado(this.idEstado);
        entity.setNombreEstado(this.nombreEstado);
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos MateriInscritaEntity
    */
    public List<EstadoDto> toEstadoDtoList(List<EstadoEntity> estadoList){
        List<EstadoDto> estadoDtoList = new ArrayList<>();
        for(EstadoEntity entity : estadoList){
            estadoDtoList.add(new EstadoDto(entity));
        }
        return estadoDtoList;
    }
    
    public long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
    
    
    
    
}
