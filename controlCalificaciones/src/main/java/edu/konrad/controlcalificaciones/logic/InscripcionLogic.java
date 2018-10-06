/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.InscripcionEntity;
import edu.konrad.controlcalificaciones.persisten.InscripcionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class InscripcionLogic {

    @Inject
    private InscripcionPersistence persistence;

    public List<InscripcionEntity> ObtenerInscripcion() {
        List<InscripcionEntity> inscripcion = persistence.findAll();
        return inscripcion;
    }

    public InscripcionEntity ObtenerInscripcion(long id) {
        InscripcionEntity inscripcion = persistence.find(id);
        return inscripcion;
    }

    public InscripcionEntity crearInscripcion(InscripcionEntity inscripcion) {
        persistence.create(inscripcion);
        return inscripcion;
    }

    public InscripcionEntity actualizarInscripcion(long id, InscripcionEntity inscripcion) {
        InscripcionEntity inscripcionUpdate = persistence.update(inscripcion);
        return inscripcionUpdate;
    }

    public void borrarInscripcion(long id) {
        persistence.remove(id);
    }
}
