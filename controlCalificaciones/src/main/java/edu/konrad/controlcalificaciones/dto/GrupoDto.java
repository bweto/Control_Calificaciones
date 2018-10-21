package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.CursoEntity;
import edu.konrad.controlcalificaciones.entities.GrupoEntity;
import edu.konrad.controlcalificaciones.entities.ProfesorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que hace el mapeo relacional de objetos tipo grupo
 * @author Dayan olaya y Roberto Garcia
 */
public class GrupoDto {

  
    
    private long idGrupo;
    private String horario;
    private int cupo;
    private ProfesorDto profesor;
    private CursoDto curso;
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
        if(grupo.getProfesor()!= null){
           ProfesorEntity entity = new ProfesorEntity();
           entity.setIdProfesor(grupo.getProfesor().getIdProfesor());
           entity.setUsuario(grupo.getProfesor().getUsuario());
           entity.setCantidadCursos(grupo.getProfesor().getCantidadCursos());
           this.profesor = new ProfesorDto(entity);
        }
//        if(grupo.getCurso()!= null){
//           CursoEntity entity = new CursoEntity();
//           entity.setIdCurso(grupo.getCurso().getIdCurso());
//           entity.setNombreCurso(grupo.getCurso().getNombreCurso());
//           
//           this.curso = new CursoDto(entity);
//        }
    }
    
    /*
    *crea un grupoEntity a partir de un grupoDto 
    */
    public GrupoEntity toEntity(){
        GrupoEntity entity = new GrupoEntity();
        entity.setIdGrupo(this.idGrupo);
        entity.setHorario(this.horario);
        entity.setCupo(this.cupo);
        entity.setProfesor(this.profesor.toEntity());
//        entity.setCurso(this.curso.toEntity());
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

    public ProfesorDto getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorDto profesor) {
        this.profesor = profesor;
    }

    public CursoDto getCurso() {
        return curso;
    }

    public void setCurso(CursoDto curso) {
        this.curso = curso;
    }
    
    
    
}
