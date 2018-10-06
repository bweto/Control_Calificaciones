/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.MateriaInscritaEntity;
import edu.konrad.controlcalificaciones.entities.ProfesorEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase encargada de la persistencia de la clase Profesor
 * @author Dayan olaya, Roberto garcia
 */
@Stateless
public class ProfesorPersistence {
   
    /*
    *Atributo de persistencia
    */
    @PersistenceContext(unitName = "contorlcalificacionesPU"
            + "")
    private EntityManager entityManager;
    
    /*
    *Metodo para buscar todos los elementos 
    */
    public List<ProfesorEntity> findAll(){
     Query query = entityManager.createQuery("select p from profesor p");
     return query.getResultList();
    }
    
    /*
    *Metodo Para buscar un profesor por Id
    */
    public ProfesorEntity find(long id){        
        return entityManager.find(ProfesorEntity.class, id);
    }
    
    
    /*
    *Metodo para crear un nuevo Profesor
    */
    public ProfesorEntity create(ProfesorEntity profesorNew){
        entityManager.persist(profesorNew);
        return profesorNew;
    }
    
    /*
    *Metodo para aactualiza un profesor
    */
    public ProfesorEntity update(ProfesorEntity profesorUpdate){
        entityManager.merge(profesorUpdate);
        return profesorUpdate;
    }
    
    /*
    *Metodo para borrar un profesor
    */
    public void remove(long id){
        ProfesorEntity programaRemove = entityManager.find(ProfesorEntity.class, id);
        entityManager.remove(programaRemove);
    }
}
