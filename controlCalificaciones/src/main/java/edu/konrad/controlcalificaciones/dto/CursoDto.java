package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.CursoEntity;
import edu.konrad.controlcalificaciones.entities.GrupoEntity;
import edu.konrad.controlcalificaciones.entities.NivelAcademicoEntity;
import edu.konrad.controlcalificaciones.entities.ProfesorEntity;
import edu.konrad.controlcalificaciones.entities.TipoCursoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 Clase Dto para realizar el mapeo relacional de la información de los
 * cursos
 * @author Dayan olaya y Roberto Garcia
 */
public class CursoDto {
    
    private long idCurso;
    private String nombreCurso;
    private ProfesorDto profesor;
    private GrupoDto grupo;
    private TipoCursoDto tipoCurso;
    private NivelAcademicoDto nivelAcademico;
    
    /*
    *Constructor basico
    */
    public CursoDto() {
    }
    
    /*
    *crear un Dto a partir de un entity
    */
    public CursoDto(CursoEntity curso) {
        this.idCurso = curso.getIdCurso();
        this.nombreCurso = curso.getNombreCurso();
        if(curso.getProfesor() != null){
            ProfesorEntity entity = new ProfesorEntity();
            entity.setArea(curso.getProfesor().getArea());
            entity.setCantidadCursos(curso.getProfesor().getCantidadCursos());
            entity.setIdProfesor(curso.getProfesor().getIdProfesor());
            entity.setUsuario(curso.getProfesor().getUsuario());
            this.profesor = new ProfesorDto(entity);
        }
        if(curso.getGrupo() != null){
            GrupoEntity entity = new GrupoEntity();
            entity.setCupo(curso.getGrupo().getCupo());
            entity.setHorario(curso.getGrupo().getHorario());
            entity.setIdGrupo(curso.getGrupo().getIdGrupo());
            this.grupo = new GrupoDto(entity);
        }
        if(curso.getNivelAcademico() != null){
            NivelAcademicoEntity entity = new NivelAcademicoEntity();
            entity.setCursos(curso.getNivelAcademico().getCursos());
            entity.setIdNivelAcademico(curso.getNivelAcademico().getIdNivelAcademico());
            entity.setNombreNivelAcademico(curso.getNivelAcademico().getNombreNivelAcademico());
            this.nivelAcademico = new NivelAcademicoDto(entity);
        }
        if(curso.getTipoCurso() != null){
            TipoCursoEntity entity = new TipoCursoEntity();
            entity.setIdTipoCurso(curso.getTipoCurso().getIdTipoCurso());
            entity.setNombreTipoCurso(curso.getTipoCurso().getNombreTipoCurso());
            entity.setPrograma(curso.getTipoCurso().getPrograma());
            this.tipoCurso = new TipoCursoDto(entity);
        }
       
    }
    
    /*
    *crear un entity apartir de un dto
    */
     public CursoEntity toEntity(){
        CursoEntity entity = new CursoEntity();
        entity.setIdCurso(this.idCurso);
        entity.setNivelAcademico(this.nivelAcademico.toEntity());
        entity.setNombreCurso(this.nombreCurso);
        entity.setProfesor(this.profesor.toEntity());
        entity.setGrupo(this.grupo.toEntity());
        entity.setTipoCurso(this.tipoCurso.toEnntity());
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos cursoEntity
    */
    public static List<CursoDto> toCursoDtoList(List<CursoEntity> cursoList){
        List<CursoDto> cursoDtoList = new ArrayList<>();
        for(CursoEntity entity : cursoList){
            cursoDtoList.add(new CursoDto(entity));
        }
        return cursoDtoList;
    }
    
    public long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public ProfesorDto getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorDto profesor) {
        this.profesor = profesor;
    }

    public GrupoDto getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoDto grupo) {
        this.grupo = grupo;
    }

    public TipoCursoDto getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(TipoCursoDto tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public NivelAcademicoDto getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(NivelAcademicoDto nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

   
    
    
    
    
}
