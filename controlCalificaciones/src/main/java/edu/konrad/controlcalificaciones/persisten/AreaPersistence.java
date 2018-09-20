
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.AreaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase para la persistencia para los objetos area
 * @author Dayan Olaya, Roberto Garcia 
 */
@Stateless
public class AreaPersistence {
    /*
    *Atributo de persistencia
    */
    @PersistenceContext(unitName = "contorlcalificacionesPU")
    private EntityManager entityManager;
    
    /*
    *Metodo para buscar todas las areas
    */
    public List<AreaEntity> findAll(){
        Query query = entityManager.createQuery("select a from area a");
        return query.getResultList();
    }
    
    /*
    *Metodo para buscar un area por id
    */
    public AreaEntity find(long id){
        return entityManager.find(AreaEntity.class, id);
    }
    
    /*
    *Metodo para crear un area
    */
    
    public AreaEntity create(AreaEntity areaNew){
        
        entityManager.persist(areaNew);
        return areaNew;
    }
    
    /*
    *Metodo para atualizar un area 
    */
    
    public AreaEntity update (AreaEntity areaUpdate){
        entityManager.persist(areaUpdate);
        return areaUpdate;
    }
    
    /*
    *Metodo para remover un area por id
    */
    public void remove(long id){
        AreaEntity areaRemove = entityManager.find(AreaEntity.class, id);
        entityManager.remove(areaRemove);
    }
}
