
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.TipoIdEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que hace el mapeo de relacionale del tipoId
 * @author Dayan Olaya Roberto Garcia
 */
public class TipoIdDto {
    
    /*
    *id del tipo de identificacion
    */
    private long idTipoId;
    /*
    *nombre del tipo de identificacion
    */
    private String nombreTipoId;

    /*
    *Constructor basico
    */
    public TipoIdDto() {
    }
    
    /*
    *Constructor para crear un TipoIdDto resiviendo un TipoIdEntity
    *@param TipoIdEntiy
    */
    public TipoIdDto(TipoIdEntity tipoId){
        this.idTipoId = tipoId.getIdTipoId();
        this.nombreTipoId = tipoId.getNombreTipoId();
    }
    
    /*
    *Metodo para crear una entidad apartir de de un dto
    *return entity
    */
    public TipoIdEntity toEntity(){
        TipoIdEntity entity = new TipoIdEntity();
        entity.setIdTipoId(this.idTipoId);
        entity.setNombreTipoId(this.nombreTipoId);
        return entity;
    }
    
    /*
    *Metodo para crear un lista de todos los tipos de id
    *@param List<TipoIdEntity> ListaTipoIdEntity
    *@return List<TipoIdEntity> listTipoId
    */
    
    public List<TipoIdDto> toTipoIdList(List<TipoIdEntity> listaTipoIdEntity){
       List<TipoIdDto> listaTipoIdDto = new ArrayList<>();
       for(TipoIdEntity entity : listaTipoIdEntity){
           listaTipoIdDto.add(new TipoIdDto(entity));
       }
       return listaTipoIdDto;
    }
    /*
    *Getters and setters
    */

    public long getIdTipoId() {
        return idTipoId;
    }

    public void setIdTipoId(long idTipoId) {
        this.idTipoId = idTipoId;
    }

    public String getNombreTipoId() {
        return nombreTipoId;
    }

    public void setNombreTipoId(String nombreTipoId) {
        this.nombreTipoId = nombreTipoId;
    }
   
}
