
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.EstadoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Mapeo relacional para objetos de tipo Estado entity
 * @author Dayan olaya y Roberto Garcia
 */
public class EstadoDto {
    
    private long idEstado;
    private String nombreEstado;

    /*
    *Constructor basico
    */
    public EstadoDto() {
    }
    
    /*
    *constructor para crear dto a partir de entidades
    */
    public EstadoDto(EstadoEntity estado) {
        this.idEstado = estado.getIdEstado();
        this.nombreEstado = estado.getNombreEstado();
    }

    /*
     Crear una EstadoEntity con un objeto relacional
     @return EstadoEntity
    */
    public EstadoEntity toEntity(){
        EstadoEntity entity = new EstadoEntity();
        entity.setIdEstado(this.idEstado);
        entity.setNombreEstado(this.nombreEstado);
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos EstadoEntity
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
