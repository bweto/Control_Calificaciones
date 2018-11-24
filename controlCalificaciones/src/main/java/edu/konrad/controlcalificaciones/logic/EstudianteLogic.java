/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.EstudianteEntity;
import edu.konrad.controlcalificaciones.persisten.EstudiantePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class EstudianteLogic {

    @Inject
    private EstudiantePersistence persistence;

    public List<EstudianteEntity> ObtenerEstudiante() {
        List<EstudianteEntity> estudiante = persistence.findAll();
        return estudiante;
    }

    public EstudianteEntity ObtenerEstudiante(Long id) {
        EstudianteEntity estudiante = persistence.find(id);
        return estudiante;
    }

    public EstudianteEntity crearEstudiante(EstudianteEntity estudiante) {
        persistence.create(estudiante);
        return estudiante;
    }

    public EstudianteEntity actualizarEstudiante(Long id, EstudianteEntity estudiante) {
        EstudianteEntity estudianteUpdate = persistence.update(estudiante);
        return estudianteUpdate;
    }

    public void borrarEstudiante(Long id) {
        persistence.remove(id);
    }
}
