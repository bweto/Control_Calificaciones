/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.CoordinadorEntity;
import edu.konrad.controlcalificaciones.persisten.CoordinadorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class CoordinadorLogic {

    @Inject
    private CoordinadorPersistence persistence;

    public List<CoordinadorEntity> ObtenerCoordinador() {
        List<CoordinadorEntity> coordinador = persistence.findAll();
        return coordinador;
    }

    public CoordinadorEntity ObtenerCoordinador(long id) {
        CoordinadorEntity coordinador = persistence.find(id);
        return coordinador;
    }

    public CoordinadorEntity crearCoordinador(CoordinadorEntity coordinador) {
        persistence.create(coordinador);
        return coordinador;
    }

    public CoordinadorEntity actualizarCoordinador(long id, CoordinadorEntity coordinador) {
        CoordinadorEntity coordinadorUpdate = persistence.Update(coordinador);
        return coordinadorUpdate;
    }

    public void borrarCoordinador(long id) {
        persistence.remove(id);
    }
}
