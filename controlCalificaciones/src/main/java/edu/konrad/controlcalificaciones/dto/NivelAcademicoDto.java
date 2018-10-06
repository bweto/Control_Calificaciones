
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.NivelAcademicoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que crea modelo relacional para la clase Nivel Academico
 * @author Dayan Olaya, Roberto Garcia
 */
public class NivelAcademicoDto {

    
    /*
    id del nivel academico
    */
    private long idNivelAcademico;
    /*
    nombre Nivel academico
    */
    private String nombreNivelAcademico;
    
    /*
     Constructor basico
    */

    public NivelAcademicoDto() {
    }
    
    /*
     Constructor apartir de un objeto nivel academico entity
     @param NivelAcademicoEntity
    */

    public NivelAcademicoDto(NivelAcademicoEntity nivel) {
        this.idNivelAcademico = nivel.getIdNivelAcademico();
        this.nombreNivelAcademico = nivel.getNombreNivelAcademico();
    }
    
    /*
     Metodo para cerar una entidad apartir de un objeto de modelo relacional
     @return NivelAcademicoEntity
    */
    public NivelAcademicoEntity toEntity(){
        NivelAcademicoEntity entity = new NivelAcademicoEntity();
        entity.setIdNivelAcademico(this.idNivelAcademico);
        entity.setNombreNivelAcademico(this.nombreNivelAcademico);
        return entity;
    }
    
    /*
     Metodo encargado de crear un lista de objetos de modelo relacional a partir de una
     lista de objetos NivelAcademicoEntity
    */
    public static List<NivelAcademicoDto> toNivelAcademicoDtoList(List<NivelAcademicoEntity> nivelList){
      List<NivelAcademicoDto> nivelAcademicoDtoList = new ArrayList<>();
      for(NivelAcademicoEntity entity : nivelList){
        nivelAcademicoDtoList.add(new NivelAcademicoDto(entity));
      }
      return nivelAcademicoDtoList;
    }
    
    /*
     getters and setters
    */

    public long getIdNivelAcademico() {
        return idNivelAcademico;
    }

    public void setIdNivelAcademico(long idNivelAcademico) {
        this.idNivelAcademico = idNivelAcademico;
    }

    public String getNombreNivelAcademico() {
        return nombreNivelAcademico;
    }

    public void setNombreNivelAcademico(String nombreNivelAcademico) {
        this.nombreNivelAcademico = nombreNivelAcademico;
    }
    
    
}
