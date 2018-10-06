/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.ProfesorEntity;
import edu.konrad.controlcalificaciones.persisten.ProfesorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class ProfesorLogic {

    @Inject
    private ProfesorPersistence persistence;

    public List<ProfesorEntity> ObtenerProfesor() {
        List<ProfesorEntity> profesor = persistence.findAll();
        return profesor;
    }

    public ProfesorEntity ObtenerProfesor(long id) {
        ProfesorEntity profesor = persistence.find(id);
        return profesor;
    }

    public ProfesorEntity crearProfesor(ProfesorEntity profesor) {
        persistence.create(profesor);
        return profesor;
    }

    public ProfesorEntity actualizarProfesor(long id, ProfesorEntity profesor) {
        ProfesorEntity profesorUpdate = persistence.update(profesor);
        return profesorUpdate;
    }

    public void borrarProfesor(long id) {
        persistence.remove(id);
    }
}
