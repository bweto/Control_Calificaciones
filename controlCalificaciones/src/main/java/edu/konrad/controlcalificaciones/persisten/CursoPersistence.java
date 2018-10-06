
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.CursoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Calse para la la persistencia de curso
 * @author Dayan Olaya, Roberto Garcia
 */
@Stateless
public class CursoPersistence {
    /*
    *Atributo para la persistencia
    */
    @PersistenceContext(unitName = "contorlcalificacionesPU")
    private EntityManager entityManager;
    
    /*
    *Metodo para buscar todos los cursos
    */
    public List<CursoEntity> findAll(){
        Query query = entityManager.createQuery("select c from curso c");
        return query.getResultList();
    }
    
    /*
    *Metodo para buscar un curso por id
    */
    public CursoEntity find(long id){
        return entityManager.find(CursoEntity.class, id);
    }
    
    /*
    *Metodo para crear un curso
    */
    public CursoEntity create(CursoEntity cursoNew){
        entityManager.persist(cursoNew);
        return cursoNew;
    }
    
    /*
    *Metodo para actualizar un curso
    */
    public CursoEntity update(CursoEntity cursoUpdate){
        entityManager.merge(cursoUpdate);
        return cursoUpdate;
    }
    
    /*
    *Metodo para borrar un curso
    */
    public void remove(long id){
        CursoEntity cursoRemove = entityManager.find(CursoEntity.class, id);
        entityManager.remove(cursoRemove);
    }
}
