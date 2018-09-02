
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.ProgramaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Calse para hacer el mapeo relacional de progrmaEntity
 * @author dayan Olaya, Roberto Garcia
 */
public class ProgramaDto {
    
    /*
    *Identificacion del programa
    */
    private long idPrograma;
    /*
    *Identificación de la facultad
    */
    private long idFacultad;
    /*
    *Nombre del programa
    */
    private String nombrePrograma;
    
    /*
    *Constructor basico
    */

    public ProgramaDto() {
    }
    
    /*
    *Constructor apartir de una entidad programa
    */

    public ProgramaDto(ProgramaEntity programa) {
        this.idPrograma = programa.getIdPrograma();
        this.idFacultad = programa.getIdPrograma();
        this.nombrePrograma = programa.getNombrePrograma();
    }
    
    /*
    *Crear una entidad apartir de un modelo relacional
    *@return ProgramaEntity
    */
    public ProgramaEntity toEntity(){
        ProgramaEntity entity = new ProgramaEntity();
        entity.setIdPrograma(this.idPrograma);
        entity.setIdFacultad(this.idFacultad);
        entity.setNombrePrograma(this.nombrePrograma);
        return entity;
    }
    
    /*
    *Metodo para crear una lista de objetos relacionales a partir de una lista 
    *de la entidad programa
    */
    public List<ProgramaDto> toProgramaList(List<ProgramaEntity> programaList){
       List<ProgramaDto> ProgramaDtoList = new ArrayList<>();
       for(ProgramaEntity entity : programaList){
           ProgramaDtoList.add(new ProgramaDto(entity));
       }
       return ProgramaDtoList;
    }
    
    /*
    *getters and setters
    */

    public long getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(long idPrograma) {
        this.idPrograma = idPrograma;
    }

    public long getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(long idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }
    
}
