/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.ProgramaEntity;
import edu.konrad.controlcalificaciones.persisten.ProgramaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class ProgramaLogic {

    @Inject
    private ProgramaPersistence persistence;

    public List<ProgramaEntity> ObtenerPrograma() {
        List<ProgramaEntity> programa = persistence.findAll();
        return programa;
    }

    public ProgramaEntity ObtenerPrograma(long id) {
        ProgramaEntity programa = persistence.find(id);
        return programa;
    }

    public ProgramaEntity crearPrograma(ProgramaEntity programa) {
        persistence.create(programa);
        return programa;
    }

    public ProgramaEntity actualizarPrograma(long id, ProgramaEntity programa) {
        ProgramaEntity programaUpdate = persistence.update(programa);
        return programaUpdate;
    }

    public void borrarPrograma(long id) {
        persistence.remove(id);
    }
}
