/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.NivelAcademicoEntity;
import edu.konrad.controlcalificaciones.persisten.NivelAcademicoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class NivelAcademicoLogic {

    @Inject
    private NivelAcademicoPersistence persistence;

    public List<NivelAcademicoEntity> ObtenerNivelAcademico() {
        List<NivelAcademicoEntity> nivelAcademico = persistence.findAll();
        return nivelAcademico;
    }

    public NivelAcademicoEntity ObtenerNivelAcademico(long id) {
        NivelAcademicoEntity nivelAcademico = persistence.find(id);
        return nivelAcademico;
    }

    public NivelAcademicoEntity crearNivelAcademico(NivelAcademicoEntity nivelAcademico) {
        persistence.create(nivelAcademico);
        return nivelAcademico;
    }

    public NivelAcademicoEntity actualizarNivelAcademico(long id, NivelAcademicoEntity nivelAcademico) {
        NivelAcademicoEntity nivelAcademicoUpdate = persistence.update(nivelAcademico);
        return nivelAcademicoUpdate;
    }

    public void borrarNivelAcademico(long id) {
        persistence.remove(id);
    }
}
