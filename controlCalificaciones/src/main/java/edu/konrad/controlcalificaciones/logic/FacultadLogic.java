/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.FacultadEntity;
import edu.konrad.controlcalificaciones.persisten.FacultadPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class FacultadLogic {

    @Inject
    private FacultadPersistence persistence;

    public List<FacultadEntity> ObtenerFacultad() {
        List<FacultadEntity> facultad = persistence.findAll();
        return facultad;
    }

    public FacultadEntity ObtenerFacultad(long id) {
        FacultadEntity facultad = persistence.find(id);
        return facultad;
    }

    public FacultadEntity crearFacultad(FacultadEntity facultad) {
        persistence.create(facultad);
        return facultad;
    }

    public FacultadEntity actualizarFacultad(long id, FacultadEntity facultad) {
        FacultadEntity facultadUpdate = persistence.update(facultad);
        return facultadUpdate;
    }

    public void borrarFacultad(long id) {
        persistence.remove(id);
    }
}
