
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.AreaEntity;
import edu.konrad.controlcalificaciones.entities.ProfesorEntity;
import edu.konrad.controlcalificaciones.entities.UsuarioEntity;
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
    private UsuarioDto usuario;
    /*
    *id del area
    */
    private AreaDto area;
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
        if(profesor.getUsuario() != null){
            UsuarioEntity entity = new UsuarioEntity();
            entity.setIdUsuario(profesor.getUsuario().getIdUsuario());
            entity.setApellidoUsuario(profesor.getUsuario().getApellidoUsuario());
            entity.setEmail(profesor.getUsuario().getEmail());
            entity.setGenero(profesor.getUsuario().getGenero());
            entity.setNombreUsuario(profesor.getUsuario().getNombreUsuario());
            entity.setRol(profesor.getUsuario().getRol());
            entity.setTipoId(profesor.getUsuario().getTipoId());
            this.usuario = new UsuarioDto(entity);
        }
        if(profesor.getArea()!= null){
            AreaEntity entity = new AreaEntity();
            entity.setIdArea(profesor.getArea().getIdArea());
            entity.setNombreArea(profesor.getArea().getNombreArea());
            this.area = new AreaDto(entity);
        }
        this.cantidadCursos = profesor.getCantidadCursos();
    }
    
    /*
    *Metodo para crear una entidad apartir de un modelo relacional
    @return ProfesorEntity
    */
    public ProfesorEntity toEntity(){
        ProfesorEntity entity = new ProfesorEntity();
        entity.setIdProfesor(this.idProfesor);
        entity.setUsuario(this.usuario.toEntity());
        entity.setArea(this.area.toEntity());
        entity.setCantidadCursos(this.cantidadCursos);
        return entity;
    }
    
    /*
    *Metodo para crear una lista de modelos de objeto entidad a partir de 
     una lista de objetos profesor entity 
    */
    public static List<ProfesorDto> toProfesorDtoList(List<ProfesorEntity> profesorList){
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

    

    public int getCantidadCursos() {
        return cantidadCursos;
    }

    public void setCantidadCursos(int cantidadCursos) {
        this.cantidadCursos = cantidadCursos;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area = area;
    }
    
    
    
}
