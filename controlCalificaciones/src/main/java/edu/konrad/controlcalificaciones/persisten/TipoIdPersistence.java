
package edu.konrad.controlcalificaciones.persisten;

/**
 *Clase encargada de crear la persistencia para los tipos de id para las 
 * identificaciones de los usuarios
 * @author Dayan olaya, Roberto garcia
 */

import edu.konrad.controlcalificaciones.entities.TipoIdEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TipoIdPersistence {
    
    /*
    *atributo de percistencia 
    */
    @PersistenceContext(unitName = "tipoIdPU")
    private EntityManager entityManager;
    
    /*
    *Metodo que obtiene todos los tipos id
    */
    public List<TipoIdEntity> findAll(){
      Query queryTipoId = entityManager.createQuery("select T from TipoIdEntity T ");
      return queryTipoId.getResultList();
    }
    
    /*
    *Metodo que busca un tipoId por id
    */
    public TipoIdEntity find(long id){
        return entityManager.find(TipoIdEntity.class, id);
    }
    
    /*
    *Metodo para crear un objeto de la clase de tipoId
    */
    public TipoIdEntity create(TipoIdEntity tipoIdNew){
        entityManager.persist(tipoIdNew);
        return tipoIdNew;
    }
    
    /*
    *Metodo para actualiza un objeto de la clase de tipoId
    */
    public TipoIdEntity update(TipoIdEntity tipoIdUpdate){
        return entityManager.merge(tipoIdUpdate);
    }
    
    /*
    *Metodo usado para borrar un objeto de tipoId
    */
    public void remove(long id){
        TipoIdEntity tipoIdDestroy = entityManager.find(TipoIdEntity.class, id);
        entityManager.remove(tipoIdDestroy);
    }
}
