
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.CalificacionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase de persistencia de la calse Calificacion
 * @author Dayan Olaya, Roberto Garcia
 */
@Stateless
public class CalificacionPersistence {
    /*
    *Ateributo para la persistencia
    */
    @PersistenceContext(unitName = "calificacionPU")
    private EntityManager entityManager;
    
    /*
    *Metodo para buscar todas las calificaciones
    */
    public List<CalificacionEntity> findAll(){
        Query query = entityManager.createQuery("select c from CalificacionEntity c");
        return query.getResultList();
    }
    
    /*
    *Metodo para buscar una calificacion por id
    */
    public CalificacionEntity find(long id){
        return entityManager.find(CalificacionEntity.class, id);
    }
    
    /*
    *Metodo para cerear una calificacion
    */
    public CalificacionEntity create(CalificacionEntity calificacionNew){
        entityManager.persist(calificacionNew);
        return calificacionNew;
    }
    
    /*
    *Metodo para actualizar una calificacion
    */
    public CalificacionEntity update(CalificacionEntity calificacionUpdate){
        entityManager.merge(calificacionUpdate);
        return calificacionUpdate;
    }
    
    /*
    *Metodo para borrar una clificacion
    */
    public void remove(long id){
        CalificacionEntity calificacionRemove = entityManager.find(CalificacionEntity.class, id);
        entityManager.remove(calificacionRemove);
    }
}
