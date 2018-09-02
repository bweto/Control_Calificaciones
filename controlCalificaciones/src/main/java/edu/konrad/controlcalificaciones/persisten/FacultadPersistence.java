
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.FacultadEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase para la persistencia de facultades
 * @author dayan Olaya, Roberto Garcia
 */
@Stateless
public class FacultadPersistence {
    
    /*
    *Atributo de persistencia
    */
    @PersistenceContext(unitName = "facultadPU")
    private EntityManager entityManager;
    
    /*
    *Metodo para buscar todas las facultades
    */
    public List<FacultadEntity> findAll(){
        Query query = entityManager.createQuery("select f from FacultadEntity f");
        return query.getResultList();
    }
    
    /*
    *Metodo para buscar la facultad por id
    */
    public FacultadEntity find(long id){
        return entityManager.find(FacultadEntity.class, id);
    }
    
    /*
    *Metodo para crear una facultad
    */
    public FacultadEntity create(FacultadEntity facultadNew){
        entityManager.persist(facultadNew);
        return facultadNew;
    }
    
    /*
    *Metodo para actualizar una facultad
    */
    public FacultadEntity update(FacultadEntity facultadUpdate){
        entityManager.merge(facultadUpdate);
        return facultadUpdate;
    }
    
    /*
    *Metodo para remover una facultad
    */
    public void remove(long id){
        FacultadEntity facultadRemove = entityManager.find(FacultadEntity.class, id);
        entityManager.remove(facultadRemove);
    }
}
