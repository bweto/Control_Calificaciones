/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.CoordinadorEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase para la persistencia del coordinador
 * @author Dayan Olaya, Roberto Garcia
 */
@Stateless
public class CoordinadorPersistence {
    /*
    *Atributo para la persistencia
    */
    @PersistenceContext(unitName = "coordinadorPU")
    private EntityManager entityManager;
    
    /*
    *Metodo para buscar todos los coordinadores
    */
    public List<CoordinadorEntity> findAll(){
        Query query = entityManager.createQuery("select c from CoordinadorEntity c");
        return query.getResultList();
    }
    
    /*
    *Metodo para la busqueda de un coordinador por id
    */
    public CoordinadorEntity find(long id){
        return entityManager.find(CoordinadorEntity.class, id);
    }
    
    /*
    *Metodo para crear un coordinador
    */
    public CoordinadorEntity create(CoordinadorEntity coordinadorNew){
        entityManager.persist(coordinadorNew);
        return coordinadorNew;
    }
    
    /*
    *Metodo para actuliazar un coordinador
    */
    public CoordinadorEntity Update(CoordinadorEntity coordinadorUpdate){
        entityManager.merge(coordinadorUpdate);
        return coordinadorUpdate;
    }
    
    /*
    *Metodo para borrar un Coordinador por id
    */
    public void remove(long id){
        CoordinadorEntity coordinadorRemove = entityManager.find(CoordinadorEntity.class, id);
        entityManager.remove(coordinadorRemove);
    }
}
