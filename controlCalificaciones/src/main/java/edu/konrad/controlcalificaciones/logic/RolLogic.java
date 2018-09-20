/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.RolEntity;
import edu.konrad.controlcalificaciones.persisten.RolPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class RolLogic {

    @Inject
    private RolPersistence persistence;

    public List<RolEntity> ObtenerRol() {
        List<RolEntity> rol = persistence.findAll();
        return rol;
    }

    public RolEntity ObtenerRol(long id) {
        RolEntity rol = persistence.find(id);
        return rol;
    }

    public RolEntity crearRol(RolEntity rol) {
        persistence.create(rol);
        return rol;
    }

    public RolEntity actualizarRol(long id, RolEntity rol) {
        RolEntity rolUpdate = persistence.update(rol);
        return rolUpdate;
    }

    public void borrarRol(long id) {
        persistence.remove(id);
    }
}
