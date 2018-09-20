/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.AreaEntity;
import edu.konrad.controlcalificaciones.persisten.AreaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class AreaLogic {

    @Inject
    private AreaPersistence persistence;

    public List<AreaEntity> ObtenerArea() {
        List<AreaEntity> area = persistence.findAll();
        return area;
    }

    public AreaEntity ObtenerArea(long id) {
        AreaEntity area = persistence.find(id);
        return area;
    }

    public AreaEntity crearArea(AreaEntity area) {
        persistence.create(area);
        return area;
    }

    public AreaEntity actualizarArea(long id, AreaEntity area) {
        AreaEntity areaUpdate = persistence.update(area);
        return areaUpdate;
    }

    public void borrarArea(long id) {
        persistence.remove(id);
    }
}
