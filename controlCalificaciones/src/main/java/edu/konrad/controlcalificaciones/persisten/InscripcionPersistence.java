/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.InscripcionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase para la persistencia de objeto inscripcion
 * @author Dayan olaya, Roberto Garcia
 */
@Stateless
public class InscripcionPersistence {
    
    /*
    *Atributo para la persistencia
    */
    @PersistenceContext(unitName = "inscripcionPU")
    private EntityManager entityManager;
    
    /*
    *Metodo para buscar todas las inscripciones
    */
    
    public List<InscripcionEntity> findAll(){
        Query query = entityManager.createQuery("select i from InscripcionEntity i");
        return query.getResultList() ;
    }
    
    /*
    *Metodo para obtener una inscripcion por id
    */
    
    public InscripcionEntity find(long id){
        return entityManager.find(InscripcionEntity.class, id);
    }
    
    /*
    *Metodo para crear un objeto del tipo inscripcion
    */
    
    public InscripcionEntity create(InscripcionEntity inscripcionNew){
        entityManager.persist(inscripcionNew);
        return inscripcionNew;
    }
    
    /*
    *Metodo para actuaizar una inscripcion
    */
    public InscripcionEntity update(InscripcionEntity inscripcionUpdate){
        entityManager.merge(inscripcionUpdate);
        return inscripcionUpdate;
    } 
    
    /*
    *Metodo para remover una inscripcion
    */
    public void remove(long id){
        InscripcionEntity inscripcionRemove = entityManager.find(InscripcionEntity.class, id);
        entityManager.remove(inscripcionRemove);
    }
}
