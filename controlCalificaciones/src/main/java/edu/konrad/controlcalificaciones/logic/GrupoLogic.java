/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.GrupoEntity;
import edu.konrad.controlcalificaciones.persisten.GrupoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class GrupoLogic {

    @Inject
    private GrupoPersistence persistence;

    public List<GrupoEntity> ObtenerGrupo() {
        List<GrupoEntity> grupo = persistence.findAll();
        return grupo;
    }

    public GrupoEntity ObtenerGrupo(long id) {
        GrupoEntity grupo = persistence.find(id);
        return grupo;
    }

    public GrupoEntity crearGrupo(GrupoEntity grupo) {
        persistence.create(grupo);
        return grupo;
    }

    public GrupoEntity actualizarGrupo(long id, GrupoEntity grupo) {
        GrupoEntity grupoUpdate = persistence.update(grupo);
        return grupoUpdate;
    }

    public void borrarGrupo(long id) {
        persistence.remove(id);
    }
}
