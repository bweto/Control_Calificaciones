
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.ProgramaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase de persistencia para la entidad Programa
 * @author Dayan olaya, Roberto Garcia
 */
@Stateless
public class ProgramaPersistence {
    
    /*
    *Atributo de persistencia
    */
    @PersistenceContext(unitName = "contorlcalificacionesPU")
    private EntityManager entityManager;
    
    /*
    *Metodo para obtener todos los objetos tipo Programa
    */
    public List<ProgramaEntity> findAll(){
       Query query = entityManager.createQuery("Select p from programa p");
        return query.getResultList();
    }
    /*
    *Metodo para buscar un Programa por Id
    */
    public ProgramaEntity find(long id){
        return entityManager.find(ProgramaEntity.class, id);
    }
    
    /*
    *Metodo para crear un objeto programa
    */
    public ProgramaEntity create(ProgramaEntity programaNew){
       entityManager.persist(programaNew);
        return programaNew;
    }
    /*
    *Metodo para actualizar un objeto programa
    */
    public ProgramaEntity update(ProgramaEntity programaUpdate){
       return entityManager.merge(programaUpdate);
    }
    /*
    *Metodo para borrar un objeto programa por id
    */
    public void remove(long id){
        ProgramaEntity programaRemove = entityManager.find(ProgramaEntity.class, id);
        entityManager.remove(programaRemove);
    }
    
}
