package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.CoordinadorEntity;
import edu.konrad.controlcalificaciones.entities.ProgramaEntity;
import edu.konrad.controlcalificaciones.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase Dto para realizar el mapeo relacional de la información de los
 * coordinadores
 * @author Dayan Olaya y Roberto Garcia 
 */
public class CoordinadorDto {
    
    /*
    *identificación del coordindor
    */
    private long idCoordinador;
    
    /*
    *Objeto usuario, donde se almacena la información general del coordinador
    */
    private UsuarioDto usuario;
    
    /*
    * Objeto programa, donde se almacena la información general del programa
    */
    private ProgramaDto programa;
    
    /*
    * Constructor basico
    */
    public CoordinadorDto() {
    }
    
    /*
    *Constructor de Dto apartir de un coordinador entity
    */
    public CoordinadorDto(CoordinadorEntity coordinador) {
        this.idCoordinador = usuario.getIdUsuario();
        
        if(coordinador.getUsuario() != null){
            UsuarioEntity entity = new UsuarioEntity();
            entity.setIdUsuario(coordinador.getUsuario().getIdUsuario());
            entity.setApellidoUsuario(coordinador.getUsuario().getApellidoUsuario());
            entity.setEmail(coordinador.getUsuario().getEmail());
            entity.setGenero(coordinador.getUsuario().getGenero());
            entity.setNombreUsuario(coordinador.getUsuario().getNombreUsuario());
            entity.setRol(coordinador.getUsuario().getRol());
            entity.setTipoId(coordinador.getUsuario().getTipoId());
            this.usuario = new UsuarioDto(entity);
        }
        if(coordinador.getPrograma() != null){
            ProgramaEntity entity = new ProgramaEntity();
            entity.setFacultad(coordinador.getPrograma().getFacultad());
            entity.setNombrePrograma(coordinador.getPrograma().getNombrePrograma());
            entity.setIdPrograma(coordinador.getPrograma().getIdPrograma());
            this.programa = new ProgramaDto(entity);
        }
        
           
    }
    
    /*
    crear un dto apartir de una entidad Coordinador
    */
    public CoordinadorEntity toEntity(){
        CoordinadorEntity entity = new CoordinadorEntity();
        entity.setIdCoordinador(this.idCoordinador);
        entity.setPrograma(this.programa.toEntity());
        entity.setUsuario(this.usuario.toEntity());
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos Coordinador Entity
    */
    public static List<CoordinadorDto> toCoordinadorDtoList(List<CoordinadorEntity> coordinadorList){
        List<CoordinadorDto> coordinadorDtoList = new ArrayList<>();
        for(CoordinadorEntity entity : coordinadorList){
            coordinadorDtoList.add(new CoordinadorDto(entity));
        }
        return coordinadorDtoList;
    }
    
    public long getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(long idCoordinador) {
        this.idCoordinador = idCoordinador;
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
