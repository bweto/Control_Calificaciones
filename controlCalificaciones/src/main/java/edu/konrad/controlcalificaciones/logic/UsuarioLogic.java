/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.logic;

import edu.konrad.controlcalificaciones.entities.UsuarioEntity;
import edu.konrad.controlcalificaciones.persisten.UsuarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Dayan Olaya y Roberto Garcia
 */
@Stateless
public class UsuarioLogic {

    @Inject
    private UsuarioPersistence persistence;

    public List<UsuarioEntity> ObtenerUsuario() {
        List<UsuarioEntity> usuario = persistence.findAll();
        return usuario;
    }

    public UsuarioEntity ObtenerUsuario(long id) {
        UsuarioEntity usuario = persistence.find(id);
        return usuario;
    }

    public UsuarioEntity crearUsuario(UsuarioEntity usuario) {
        persistence.create(usuario);
        return usuario;
    }

    public UsuarioEntity actualizarUsuario(long id, UsuarioEntity usuario) {
        UsuarioEntity usuarioUpdate = persistence.update(usuario);
        return usuarioUpdate;
    }

    public void borrarUsuario(long id) {
        persistence.remove(id);
    }
}
