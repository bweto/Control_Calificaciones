
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.RolEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase encargada de la persistencia en el rol
 * @author Dayan olaya, Roberto Garcia
 */
@Stateless
public class RolPersistence {
    
    /*
    *Atributo para la persistencia 
    */
    @PersistenceContext(unitName = "contorlcalificacionesPU")
    private EntityManager entityManager;
    
    /*
    *Metodo para obtener todos los objeto de tipo rol
    */
    public List<RolEntity> findAll(){
        Query queryRol = entityManager.createQuery("select r from rol r");
        return queryRol.getResultList();
    }
    
    /*
    *Metodo para obtener un objeto de tipo rol por id
    */
    public RolEntity find(long id){
        return entityManager.find(RolEntity.class, id);
    }
    
    /*
    *Metodo para obtener crear un objeto de tipo rol
    */
    public RolEntity create(RolEntity rolNew){
        entityManager.persist(rolNew);
        return rolNew;
    }
    
    /*
    *Metodo para actualizar un rol
    */
    public RolEntity update(RolEntity rolUpdate){
        return entityManager.merge(rolUpdate); 
    }
    
    /*
    *Metodo para remover un rol
    */
    public void remove(long id){
        RolEntity rolRemove = entityManager.find(RolEntity.class, id);
        entityManager.remove(rolRemove);
    }
}
