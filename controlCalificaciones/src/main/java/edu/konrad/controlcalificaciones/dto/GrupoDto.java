/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.GrupoEntity;
import edu.konrad.controlcalificaciones.entities.MateriaInscritaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bwto
 */
public class GrupoDto {
    
    private long idGrupo;
    private String horario;
    private int cupo;

    public GrupoDto() {
    }
    
    public GrupoDto(GrupoEntity grupo) {
        this.idGrupo = grupo.getIdGrupo();
        this.horario = grupo.getHorario();
        this.cupo = grupo.getCupo();
    }
    
    /*
     
    */
    public GrupoEntity toEntity(){
        GrupoEntity entity = new GrupoEntity();
        entity.setIdGrupo(this.idGrupo);
        entity.setHorario(this.horario);
        entity.setCupo(this.cupo);
        return entity;
    }
    
    /*
    
    */
    public List<GrupoDto> toGrupoDtoList(List<GrupoEntity> grupoList){
        List<GrupoDto> grupoDtoList = new ArrayList<>();
        for(GrupoEntity entity : grupoList){
            grupoDtoList.add(new GrupoDto(entity));
        }
        return grupoDtoList;
    }

    public long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
    
    
}
