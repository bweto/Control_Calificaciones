
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.TipoCursoEntity;
import edu.konrad.controlcalificaciones.entities.TipoIdEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *clase encargada de crear la persistencia para los tipos de cursos
 * @author Dayan Olaya, Roberto Garcia
 */
@Stateless
public class TipoCursoPersistence {
  
    /*
    *Atributo de persistenia para la clase tipoCurso
    */
    @PersistenceContext(unitName = "contorlcalificacionesPU")
    private EntityManager entityManager;
    
    /*
    *Metodo para encontrar todos los objetos de tipoCurso
    */
    public List<TipoCursoEntity> findAll(){
        Query queryTipoCurso = entityManager.createQuery("select t from tipo_curso t");
        return queryTipoCurso.getResultList();
    }
    
    /*
    *Metodo para encontrar un tipoCurso por  id
    */
    public TipoCursoEntity find(long id){
        return entityManager.find(TipoCursoEntity.class, id);
    }
    
    /*
    *Metodo para crear un objeto de tipocurso
    */
    public TipoCursoEntity create(TipoCursoEntity tipoCursoNew){
        entityManager.persist(tipoCursoNew);
        return tipoCursoNew;
    }
    
    /*
    *Metodo para actualiza un tipoCurso
    */
    public TipoCursoEntity update(TipoCursoEntity tipoCursoUpdate){
        entityManager.merge(tipoCursoUpdate);
        return tipoCursoUpdate;
    }
    
    /*
    *Metodo para remover un tipoCuerpo
    */
    public void remove(long id){
        TipoIdEntity tipoCursoRemove = entityManager.find(TipoIdEntity.class, id);
        entityManager.remove(tipoCursoRemove);
    }
}
