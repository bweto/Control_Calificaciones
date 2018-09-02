
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.MateriaInscritaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase Para la persistencia de la materiaInscrita
 * @author Dayan olaya, Roberto garcia
 */
@Stateless
public class MateriaInscritaPersistence {
    
    /*
    *atributo para la persistencia
    */
    @PersistenceContext(unitName = "materiaInscritaPU")
    private EntityManager entityManager;
    
    /*
    *Metodo para buscar todos los elementos de materiaInscrita
    */
    public List<MateriaInscritaEntity> findAll(){
        Query query = entityManager.createQuery("select m from MateriInscritaEntety m");
        return query.getResultList();
    }
    /*
    *Metodo Para buscar una materiaInscrita por Id
    */
    public MateriaInscritaEntity find(long id){        
        return entityManager.find(MateriaInscritaEntity.class, id);
    }
    
    /*
    *Metodo para crear una materiainscrita
    */
    public MateriaInscritaEntity create(MateriaInscritaEntity materiainscritaNew){
        entityManager.persist(materiainscritaNew);
        return materiainscritaNew;
    }
    
    /*
    *Metodo para actualizar una materiaInscrita
    */
    public MateriaInscritaEntity update(MateriaInscritaEntity materiInscriptaUpdate){
        entityManager.merge(materiInscriptaUpdate);
        return materiInscriptaUpdate;
    }
    /*
    *Metodo para borrar un elemento MateriaInscrita
    */
    public void remove(long id){
        MateriaInscritaEntity materiaRemove = entityManager.find(MateriaInscritaEntity.class, id);
        entityManager.remove(materiaRemove);
    }
}
