
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.EstudianteEntity;
import edu.konrad.controlcalificaciones.entities.ProgramaEntity;
import edu.konrad.controlcalificaciones.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que hace el mapeo relacional para objetos del tipo EstudianteEntity
 * @author Dayan olaya y Roberto Garcia
 */
public class EstudianteDto {

   
    
     private long idEstudiante;
     private int codigoEstudiante;
     private int cantidadMaterias;
     private UsuarioDto usuario;
     private ProgramaDto programa;
     
    /*
     *constructor basico
     */
    public EstudianteDto() {
    }
    
    /*
    *Constructor de un dto a partir de una entidad
    */
    public EstudianteDto(EstudianteEntity estudiante) {
        this.idEstudiante = estudiante.getIdEstudiante();
        this.codigoEstudiante = estudiante.getCodigoEstudiante();
        this.cantidadMaterias = estudiante.getCantidadMaterias();
        if(estudiante.getUsuario() != null){
            UsuarioEntity entity = new UsuarioEntity();
            entity.setIdUsuario(estudiante.getUsuario().getIdUsuario());
            entity.setApellidoUsuario(estudiante.getUsuario().getApellidoUsuario());
            entity.setEmail(estudiante.getUsuario().getEmail());
            entity.setGenero(estudiante.getUsuario().getGenero());
            entity.setNombreUsuario(estudiante.getUsuario().getNombreUsuario());
            entity.setRol(estudiante.getUsuario().getRol());
            entity.setTipoId(estudiante.getUsuario().getTipoId());
            entity.setPass(estudiante.getUsuario().getPass());
            this.usuario = new UsuarioDto(entity);
        }
        if(estudiante.getPrograma() != null){
            ProgramaEntity entity = new ProgramaEntity();
            entity.setFacultad(estudiante.getPrograma().getFacultad());
            entity.setNombrePrograma(estudiante.getPrograma().getNombrePrograma());
            entity.setIdPrograma(estudiante.getPrograma().getIdPrograma());
            this.programa = new ProgramaDto(entity);
        }
    }
    /*
    *Creat entidaddes a partir de dtos
    */
    
    public EstudianteEntity toEntity(){
        EstudianteEntity entity = new EstudianteEntity();
        entity.setIdEstudiante(this.idEstudiante);
        entity.setCantidadMaterias(this.cantidadMaterias);
        entity.setUsuario(this.usuario.toEntity());
        entity.setPrograma(this.programa.toEntity());
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos EstudianteEntity
    */
    public static List<EstudianteDto> toEstudianteDtoList(List<EstudianteEntity> estudianteList){
        List<EstudianteDto> estudianteDtoList = new ArrayList<>();
        for(EstudianteEntity entity : estudianteList){
            estudianteDtoList.add(new EstudianteDto(entity));
        }
        return estudianteDtoList;
    }

    public long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(int cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public ProgramaDto getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaDto programa) {
        this.programa = programa;
    }
   
}
