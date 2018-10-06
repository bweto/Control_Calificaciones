/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.TipoIdEntity;
import edu.konrad.controlcalificaciones.persisten.TipoIdPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class TipoIdLogic {

    @Inject
    private TipoIdPersistence persistence;

    public List<TipoIdEntity> ObtenerTipoId() {
        List<TipoIdEntity> tipoId = persistence.findAll();
        return tipoId;
    }

    public TipoIdEntity ObtenerTipoId(long id) {
        TipoIdEntity tipoId = persistence.find(id);
        return tipoId;
    }

    public TipoIdEntity crearTipoId(TipoIdEntity tipoId) {
        persistence.create(tipoId);
        return tipoId;
    }

    public TipoIdEntity actualizarTipoId(long id, TipoIdEntity tipoId) {
        TipoIdEntity tipoIdUpdate = persistence.update(tipoId);
        return tipoIdUpdate;
    }

    public void borrarTipoId(long id) {
        persistence.remove(id);
    }
}
