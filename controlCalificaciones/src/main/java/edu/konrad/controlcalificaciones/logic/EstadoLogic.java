/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.EstadoEntity;
import edu.konrad.controlcalificaciones.persisten.EstadoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class EstadoLogic {

    @Inject
    private EstadoPersistence persistence;

    public List<EstadoEntity> ObtenerEstado() {
        List<EstadoEntity> estado = persistence.findAll();
        return estado;
    }

    public EstadoEntity ObtenerEstado(long id) {
        EstadoEntity estado = persistence.find(id);
        return estado;
    }

    public EstadoEntity crearEstado(EstadoEntity estado) {
        persistence.create(estado);
        return estado;
    }

    public EstadoEntity actualizarEstado(long id, EstadoEntity estado) {
        EstadoEntity estadoUpdate = persistence.update(estado);
        return estadoUpdate;
    }

    public void borrarEstado(long id) {
        persistence.remove(id);
    }
}
