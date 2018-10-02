
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.RolEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *clase que hace el mapeo relacional con el Rol
 * @author Dayan Olaya, Roberto Garcia
 */
public class RolDto {

    public static List<RolDto> toRolList(List<RolEntity> rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*
    *id rol
    
    */
   private long idRol;
   /*
   *nombre rol
   */
   private String nombreRol;
    
   /*
   *Constructor basico
   */
    public RolDto() {
    }
    
    /*
    *Constructor de un modelo relacional a partir de la entidad rol
    *@param RolEntity rol
    */
    public RolDto(RolEntity rol) {
        this.idRol = rol.getIdRol();
        this.nombreRol = rol.getNombreRol();
    }
   
    /*
    *crear una entidad a partir del modelo de objeto relacional
    *@param
    *@return RolEntity entity
    */
    public RolEntity toEntity(){
      RolEntity entity = new RolEntity();
      entity.setIdRol(this.idRol);
      entity.setNombreRol(this.nombreRol);
      return entity;
    }
    
    /*
    *Crear una lista del modelo de los objetos relaciones con la lista de entidades
    *@param List<RolEntity> 
    *@return List<RolDto>
    */
    public static List<RolDto> toRollist(List<RolEntity> rolEntityList){
       List<RolDto> rolDtoList = new ArrayList<>();
       for(RolEntity entity : rolEntityList){
           rolDtoList.add(new RolDto(entity));
       }
       return rolDtoList;
    }
    
    /*
    public
    *getters and setters
    */

    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
   
}
