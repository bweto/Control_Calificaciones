
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.ProfesorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que mapea los objetos relacionales del profesor
 * @author Dayan Olaya, Roberto Garcia
 */
public class ProfesorDto {
    
    /*
    *id del profesor
    */
    private long idProfesor;
    /*
    *id del usuario
    */
    private long idUsuario;
    /*
    *id del area
    */
    private long idArea;
    /*
    *cantidad de cursos
    */
    private int cantidadCursos;
    
    /*
    *Constructor basico
    */

    public ProfesorDto() {
    }
    
    /*
    *Constructor de un objeto relacional a partir de un objeto de tipo ProfesorEntity
    *@param ProfesorEntity
    */

    public ProfesorDto(ProfesorEntity profesor) {
        this.idProfesor = profesor.getIdProfesor();
        this.idUsuario = profesor.getIdUsuario();
        this.idArea = profesor.getIdArea();
        this.cantidadCursos = profesor.getCantidadCursos();
    }
    
    /*
    *Metodo para crear una entidad apartir de un modelo relacional
    @return ProfesorEntity
    */
    public ProfesorEntity toEntity(){
        ProfesorEntity entity = new ProfesorEntity();
        entity.setIdProfesor(this.idProfesor);
        entity.setIdUsuario(this.idUsuario);
        entity.setIdArea(this.idArea);
        entity.setCantidadCursos(this.cantidadCursos);
        return entity;
    }
    
    /*
    *Metodo para crear una lista de modelos de objeto entidad a partir de 
     una lista de objetos profesor entity 
    */
    public List<ProfesorDto> toProfesorDtoList(List<ProfesorEntity> profesorList){
      List<ProfesorDto> profesorDtoList = new ArrayList<>();
      for(ProfesorEntity entity : profesorList){
          profesorDtoList.add(new ProfesorDto(entity));
      }
      return profesorDtoList;
    }
    
    /*
    *Getters and setters
    */

    public long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdArea() {
        return idArea;
    }

    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }

    public int getCantidadCursos() {
        return cantidadCursos;
    }

    public void setCantidadCursos(int cantidadCursos) {
        this.cantidadCursos = cantidadCursos;
    }
    
    
    
}
