
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.UsuarioEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase encargada de la persistencia de la entidad usuarioEntity
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class UsuarioPersistence {
 
    /*
    *Se crea el atributo de persistencia usado po el JPA
    */
  @PersistenceContext(unitName = "contorlcalificacionesPU")
  private EntityManager entitieManager;
  
  /*
  *Metodo que obtiene todos los usuarios
  */
  public List<UsuarioEntity> findAll(){
     Query queryUsuario = entitieManager.createQuery("select U from usuario U");
     return queryUsuario.getResultList();
  }
  
  /*
  *Metodo que busca un objeto de la clase usuario
  */
  public UsuarioEntity find(long id){
      return entitieManager.find(UsuarioEntity.class, id);
  }
  
  /*
  *Metodo que crea un objeto de la clase Usuario
  */
  public UsuarioEntity create(UsuarioEntity UsuarioNuevo){
      entitieManager.persist(UsuarioNuevo);
      return UsuarioNuevo;
  }
  
  /*
  *Metodo para actualiza el Usuario
  */
  public UsuarioEntity update(UsuarioEntity usuarioUpdate){
      return entitieManager.merge(usuarioUpdate);
  }
  
  /*
  *Metodo usado para remover un usuario
  */
  public void remove(long id){
      UsuarioEntity usuarioRemove = entitieManager.find(UsuarioEntity.class, id);
      entitieManager.remove(usuarioRemove);
  }
  //
}
