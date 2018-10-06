/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.TipoCursoEntity;
import edu.konrad.controlcalificaciones.persisten.TipoCursoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class TipoCursoLogic {

    @Inject
    private TipoCursoPersistence persistence;

    public List<TipoCursoEntity> ObtenerTipoCurso() {
        List<TipoCursoEntity> tipoCurso = persistence.findAll();
        return tipoCurso;
    }

    public TipoCursoEntity ObtenerTipoCurso(long id) {
        TipoCursoEntity tipoCurso = persistence.find(id);
        return tipoCurso;
    }

    public TipoCursoEntity crearTipoCurso(TipoCursoEntity tipoCurso) {
        persistence.create(tipoCurso);
        return tipoCurso;
    }

    public TipoCursoEntity actualizarTipoCurso(long id, TipoCursoEntity tipoCurso) {
        TipoCursoEntity tipoCursoUpdate = persistence.update(tipoCurso);
        return tipoCursoUpdate;
    }

    public void borrarTipoCurso(long id) {
        persistence.remove(id);
    }
}
