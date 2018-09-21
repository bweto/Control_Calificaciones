/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.CoordinadorEntity;
import edu.konrad.controlcalificaciones.entities.ProgramaEntity;
import edu.konrad.controlcalificaciones.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase Dto para realizar el mapeo relacional de la información de los
 * coordinadores
 * @author Dayan Olaya y Roberto Garcia 
 */
public class CoordinadorDto {
    
    /*
    *identificación del coordindor
    */
    private long idCoordinador;
    
    /*
    *Objeto usuario, donde se almacena la información general del coordinador
    */
    private UsuarioEntity usuario;
    
    /*
    * Objeto programa, donde se almacena la información general del programa
    */
    private ProgramaEntity programa;
    
    /*
    * Constructor basico
    */
    public CoordinadorDto() {
    }
    
    /*
    *Constructor de Dto apartir de un coordinador entity
    */
    public CoordinadorDto(CoordinadorEntity coordinador) {
        this.idCoordinador = coordinador.getIdCoordinador();
        this.usuario = coordinador.getUsuario();
        this.programa = coordinador.getPrograma();
    }
    
    /*
    crear un dto apartir de una entidad Coordinador
    */
    public CoordinadorEntity toEntity(){
        CoordinadorEntity entity = new CoordinadorEntity();
        entity.setIdCoordinador(this.idCoordinador);
        entity.setPrograma(this.programa);
        entity.setUsuario(this.getUsuario());
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos Coordinador Entity
    */
    public List<CoordinadorDto> toCoordinadorDtoList(List<CoordinadorEntity> coordinadorList){
        List<CoordinadorDto> coordinadorDtoList = new ArrayList<>();
        for(CoordinadorEntity entity : coordinadorList){
            coordinadorDtoList.add(new CoordinadorDto(entity));
        }
        return coordinadorDtoList;
    }
    
    public long getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(long idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public ProgramaEntity getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaEntity programa) {
        this.programa = programa;
    }
    
    
}
