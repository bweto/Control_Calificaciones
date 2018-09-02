
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase encargada del mapeo del objeto relacional
 * @author Dayan Olaya Roberto Garcia
 */
public class UsuarioDto {
   
    /*
    *id de un usuario
    */
    private long idUsuario;
    /*
    *tipo de is de un usuario
    */
    private long tipoId;
    /*
    *numero de identificacion de un usuario
    */
    private int numeroId;
    /*
    *Nombre de un usuario
    */
    private String nombreUsuario;
    /*
    *apellido de un usuario
    */
    private String apellidoUsuario;
    /*
    *rol de un usuario
    */
    private long idRol;
    /*
    *genero de un usuario
    */
    private String genero;
    /*
    *email de un genero
    */
    private String email;
    
    /*
    *Constructor basico
    */

    /**
     *
     */

    public UsuarioDto() {
    }
    /*
    *Constructor de un usuario Dto
    *@Param
    */

    /**
     *
     * @param usuario
     */

    public UsuarioDto(UsuarioEntity usuario) {
      
        this.idUsuario = usuario.getIdUsuario();
        this.nombreUsuario = usuario.getNombreUsuario();
        this.apellidoUsuario = usuario.getApellidoUsuario();
        this.tipoId = usuario.getTipoId();
        this.numeroId = usuario.getNumeroId();
        this.idRol = usuario.getIdRol();
        this.genero = usuario.getGenero();
        this.email = usuario.getEmail();
    }
    
    /*
    *
    */

    /**
     *
     * @return
     */

    
    public UsuarioEntity toEntity(){
        UsuarioEntity entity = new UsuarioEntity();
        entity.setIdUsuario(this.idUsuario);
        entity.setNombreUsuario(this.nombreUsuario);
        entity.setApellidoUsuario(this.apellidoUsuario);
        entity.setTipoId(this.tipoId);
        entity.setNumeroId(this.numeroId);
        entity.setIdRol(this.idRol);
        entity.setGenero(this.genero);
        entity.setEmail(this.email);
        return entity;
    }
    
    /*
    *
    */

    /**
     *
     * @param ListaUsuarios
     * @return
     */

    public List<UsuarioDto> toUsersList(List<UsuarioEntity> ListaUsuarios){
      List<UsuarioDto> listaUsuariosDto = new ArrayList<>();
      for(UsuarioEntity entity : ListaUsuarios){
          listaUsuariosDto.add(new UsuarioDto(entity));
      }
      return listaUsuariosDto;
    }
        
   
    
    /*
    *getters y setter
    */

    /**
     *
     * @return
     */


    public long getIdUsuario() {
        return idUsuario;
    }

    /**
     *
     * @param idUsuario
     */
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     *
     * @return
     */
    public long getTipoId() {
        return tipoId;
    }

    /**
     *
     * @param tipoId
     */
    public void setTipoId(long tipoId) {
        this.tipoId = tipoId;
    }

    /**
     *
     * @return
     */
    public int getNumeroId() {
        return numeroId;
    }

    /**
     *
     * @param numeroId
     */
    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }

    /**
     *
     * @return
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     *
     * @param nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     *
     * @return
     */
    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    /**
     *
     * @param apellidoUsuario
     */
    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    /**
     *
     * @return
     */
    public long getIdRol() {
        return idRol;
    }

    /**
     *
     * @param idRol
     */
    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

    /**
     *
     * @return
     */
    public String getGenero() {
        return genero;
    }

    /**
     *
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
