/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.persisten;

import edu.konrad.controlcalificaciones.entities.EstudianteEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *clase para la persistencia de Estudiantes
 * @author Dayan olaya, Roberto Garcia
 */
@Stateless
public class EstudiantePersistence {
    
    /*
    *Atributo de persistencia
    */
    @PersistenceContext(unitName = "estudiantePU")
    private EntityManager entityManager;
    
    /*
    *Metodo para buscar todos los estudiantes
    */
    public List<EstudianteEntity> findAll(){
       Query query = entityManager.createQuery("select e from EstudianteEntity e");
        return query.getResultList();
    }
    
    /*
    * Metodo para buscar un estudiante por id
    */
    public EstudianteEntity find(long id){
        return entityManager.find(EstudianteEntity.class, id);
    }
    
    /*
    *Metodo para crear un estudiante
    */
    public EstudianteEntity create(EstudianteEntity estudianteNew){
        entityManager.persist(estudianteNew);
        return estudianteNew;
    }
    
    /*
    *Metodo para actualizar un estudiante
    */
    public EstudianteEntity update(EstudianteEntity estudianteUpdate){
        entityManager.merge(estudianteUpdate);
        return  estudianteUpdate;
    }
    
    /*
    *Metodo para borrar un estudiante 
    */
    public void remove(long id){
        EstudianteEntity estudianteRemove = entityManager.find(EstudianteEntity.class, id);
        entityManager.remove(estudianteRemove);
    }
}
