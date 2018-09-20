/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.CalificacionEntity;
import edu.konrad.controlcalificaciones.persisten.CalificacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
 
/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class CalificacionLogic {

    @Inject
    private CalificacionPersistence persistence;

    public List<CalificacionEntity> ObtenerCalificacion() {
        List<CalificacionEntity> calificacion = persistence.findAll();
        return calificacion;
    }

    public CalificacionEntity ObtenerCalificacion(long id) {
        CalificacionEntity calificacion = persistence.find(id);
        return calificacion;
    }

    public CalificacionEntity crearCalificacion(CalificacionEntity calificacion) {
        persistence.create(calificacion);
        return calificacion;
    }

    public CalificacionEntity actualizarCalificacion(long id, CalificacionEntity calificacion) {
        CalificacionEntity calificacionUpdate = persistence.update(calificacion);
        return calificacionUpdate;
    }

    public void borrarCalificacion(long id) {
        persistence.remove(id);
    }
}
