
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.GrupoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase para la persistencia de objetos tipo Grupo
 * @author Dayan olaya, Roberto Garcia
 */
@Stateless
public class GrupoPersistence {
   
    /*
    *Atributo para la persistencia
    */
    @PersistenceContext(unitName = "grupoPU")
    private EntityManager entityManager;
    
    /*
    *Metodo para obtener todos los grupos
    */
    public List<GrupoEntity> findAll(){
        Query query = entityManager.createQuery("select g from GrupoEntity g");
        return query.getResultList();
    }
    
    /*
    *Metodo para buscar un grupo por id
    */
    public GrupoEntity find(long id){
        return entityManager.find(GrupoEntity.class, id); 
    }
    
    /*
    *Metodo para crear un grupo 
    */
    public GrupoEntity create( GrupoEntity grupoNew){
        entityManager.persist(grupoNew);
        return grupoNew;
    }
    
    /*
    *Metodo para actualizar un grupo
    */
    public GrupoEntity update(GrupoEntity grupoUpdate){
        entityManager.merge(grupoUpdate);
        return grupoUpdate;
    }
    
    /*
    *Metodo para remover un grupo
    */
    public void remove(long id){
        GrupoEntity grupoRemove = entityManager.find(GrupoEntity.class, id);
        entityManager.remove(grupoRemove);
    }
}
