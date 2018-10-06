/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.MateriaInscritaEntity;
import edu.konrad.controlcalificaciones.persisten.MateriaInscritaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class MateriaInscritaLogic {

    @Inject
    private MateriaInscritaPersistence persistence;

    public List<MateriaInscritaEntity> ObtenerMateriaInscrita() {
        List<MateriaInscritaEntity> materiaInscrita = persistence.findAll();
        return materiaInscrita;
    }

    public MateriaInscritaEntity ObtenerMateriaInscrita(long id) {
        MateriaInscritaEntity materiaInscrita = persistence.find(id);
        return materiaInscrita;
    }

    public MateriaInscritaEntity crearMateriaInscrita(MateriaInscritaEntity materiaInscrita) {
        persistence.create(materiaInscrita);
        return materiaInscrita;
    }

    public MateriaInscritaEntity actualizarMateriaInscrita(long id, MateriaInscritaEntity materiaInscrita) {
        MateriaInscritaEntity materiaInscritaUpdate = persistence.update(materiaInscrita);
        return materiaInscritaUpdate;
    }

    public void borrarMateriaInscrita(long id) {
        persistence.remove(id);
    }
}
