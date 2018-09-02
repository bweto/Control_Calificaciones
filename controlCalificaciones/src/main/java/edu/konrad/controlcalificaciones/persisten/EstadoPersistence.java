
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.EstadoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase para la persistencia de estado
 * @author Dayan Olaya, roberto garcia
 */
@Stateless 
public class EstadoPersistence {
   /*
    *Atributo de persistencia
    */ 
    @PersistenceContext(unitName = "estadoPU")
    private EntityManager entityManager;
    
    /*
    *Metodo para buscar todos los estados
    */
    public List<EstadoEntity> findAll(){
        Query query = entityManager.createQuery("select e from EstadoEntity e");
        return query.getResultList();
    }
    
    /*
    *Metodo para encontrar un estado por id
    */
    public EstadoEntity find(long id){
        return entityManager.find(EstadoEntity.class, id);
    }
    
    /*
    *Metodo para creaar un los estados
    */
    public EstadoEntity create(EstadoEntity estadoNew){
        entityManager.persist(entityManager);
        return estadoNew;
    }
    
    /*
    *Metodo para actualizar un estado
    */
    public EstadoEntity update(EstadoEntity estadoUpdate){
        entityManager.merge(estadoUpdate);
        return estadoUpdate;
    }
    
    /*
    *Metodo para borrar un estado
    */
    public void remove(long id){
        EstadoEntity estadoRemove = entityManager.find(EstadoEntity.class, id);
        entityManager.remove(estadoRemove);
    }
}
