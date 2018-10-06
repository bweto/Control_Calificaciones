
package edu.konrad.controlcalificaciones.resource;

/**
 *Servicios rest para la clase usuario, y consumo de su información
 * @author Dayan Olaya y Roberto Garcia 
 */
import edu.konrad.controlcalificaciones.dto.UsuarioDto;
import edu.konrad.controlcalificaciones.entities.UsuarioEntity;
import edu.konrad.controlcalificaciones.logic.UsuarioLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/usuarios")
public class UsuarioResource {
  @EJB
    private UsuarioLogic usuarioLogic;
    
  /*
  *Obtiene todos usuarios por el metodo http get
  */
    @GET
    public List<UsuarioDto> getUsuariosList(){
        List<UsuarioEntity> usuarios = usuarioLogic.ObtenerUsuario();
        return  UsuarioDto.toUsersList(usuarios);
    }
    
    /*
    *Obtiene un usuario por un id utilizando el metodo http get
    @param id long
    */
    @GET
    @Path("{id: \\d+}")
    public UsuarioDto getUsuario(@PathParam("id") long id){
        UsuarioEntity usuario = usuarioLogic.ObtenerUsuario(id);
        return  new UsuarioDto(usuario);
    }
    
    /*
    *Crea un usuario con el metodo post http
    */
    @POST
    public UsuarioDto crearUsuario(UsuarioDto usuarioNuevo){
        
        return new UsuarioDto(usuarioLogic.crearUsuario(usuarioNuevo.toEntity()));
    }
    
    /*
    *Realiza la actualización de un usuario con el metodo http put
    */
    @PUT
    @Path("{id: \\d+}")
    public UsuarioDto updateUsuario(@PathParam("id") long id, UsuarioDto usuarioDto){
        UsuarioEntity usuarioEntity = usuarioLogic.ObtenerUsuario(id);
        if(usuarioEntity == null){
        throw new RuntimeException("No existe el usuario");
        }
        else{
        usuarioLogic.actualizarUsuario(id, usuarioDto.toEntity());
        }
        return usuarioDto;
    }
    
    /*
    *realiza el borrado de un archivo, buscando primero por el id y despues hace 
    el borrado con el metodo http delete
    */
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") long id){
        UsuarioEntity usuarioEntity = usuarioLogic.ObtenerUsuario(id);
        if(usuarioEntity == null){
        throw new RuntimeException("No existe el usuario");
        }
        else{
        usuarioLogic.borrarUsuario(id);
        }
    }  
}
