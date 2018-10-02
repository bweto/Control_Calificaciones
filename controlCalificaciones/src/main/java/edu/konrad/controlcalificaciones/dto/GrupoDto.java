package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.GrupoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que hace el mapeo relacional de objetos tipo grupo
 * @author Dayan olaya y Roberto Garcia
 */
public class GrupoDto {

    public static List<GrupoDto> toGrupoList(List<GrupoEntity> grupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private long idGrupo;
    private String horario;
    private int cupo;
    
    /*
    *Constructor basico
    */
    public GrupoDto() {
    }
    
    /*
    *Constructor para crear un grupoDto a partir de un grupoEntity
    */
    public GrupoDto(GrupoEntity grupo) {
        this.idGrupo = grupo.getIdGrupo();
        this.horario = grupo.getHorario();
        this.cupo = grupo.getCupo();
    }
    
    /*
    *crea un grupoEntity a partir de un grupoDto 
    */
    public GrupoEntity toEntity(){
        GrupoEntity entity = new GrupoEntity();
        entity.setIdGrupo(this.idGrupo);
        entity.setHorario(this.horario);
        entity.setCupo(this.cupo);
        return entity;
    }
    
    /*
    *crea un grupo de objetos dto a partir de un grupo de objetos grupo entity
    */
    public static List<GrupoDto> toGrupoDtoList(List<GrupoEntity> grupoList){
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
