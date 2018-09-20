
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.NivelAcademicoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase para la persistencia de los objetos NivelAcademico
 * @author Dayan Olaya, Roberto garcia
 */
@Stateless
public class NivelAcademicoPersistence {
    
    /*
    *Atributo para la persistencia de la clase
    */
    @PersistenceContext(unitName = "contorlcalificacionesPU")
    private EntityManager entityManager;
    
    /*
    *Metodo para buscar todos los elementos del tipo NivelAcademico
    */
    public List<NivelAcademicoEntity> findAll(){
        Query query = entityManager.createQuery("select n from nivel_academico n");
        return query.getResultList();
    }
    
    /*
    *Metodo para buscar un nivelAcademico por id
    */
    public NivelAcademicoEntity find(long id){
        return entityManager.find(NivelAcademicoEntity.class, id);
    }
    
    /*
    *Metodo para crear un elemento del tipo nivelAcademico
    */
    public NivelAcademicoEntity create(NivelAcademicoEntity nivelAcademicoNew){
        entityManager.persist(nivelAcademicoNew);
        return nivelAcademicoNew;
    }
    
    /*
    *Metodo para actualizar un elemento del tipo nivelAcademico
    */
    public NivelAcademicoEntity update(NivelAcademicoEntity nivelAcademicoUpdate){
        entityManager.merge(nivelAcademicoUpdate);
        return nivelAcademicoUpdate;
    }
    
    /*
    *metodo para borrar un nivelAcademico
    */
    public void remove(long id){
       NivelAcademicoEntity nivelRemove = entityManager.find(NivelAcademicoEntity.class, id);
       entityManager.remove(nivelRemove);
    }
}
