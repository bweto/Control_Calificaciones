/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.CursoEntity;
import edu.konrad.controlcalificaciones.persisten.CursoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class CursoLogic {

    @Inject
    private CursoPersistence persistence;

    public List<CursoEntity> ObtenerCurso() {
        List<CursoEntity> curso = persistence.findAll();
        return curso;
    }

    public CursoEntity ObtenerCurso(long id) {
        CursoEntity curso = persistence.find(id);
        return curso;
    }

    public CursoEntity crearCurso(CursoEntity curso) {
        persistence.create(curso);
        return curso;
    }

    public CursoEntity actualizarCurso(long id, CursoEntity curso) {
        CursoEntity cursoUpdate = persistence.update(curso);
        return cursoUpdate;
    }

    public void borrarCurso(long id) {
        persistence.remove(id);
    }
}
