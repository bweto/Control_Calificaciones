package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.FacultadEntity;
import edu.konrad.controlcalificaciones.entities.NivelAcademicoEntity;
import edu.konrad.controlcalificaciones.entities.ProgramaEntity;
import edu.konrad.controlcalificaciones.entities.TipoCursoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Calse para hacer el mapeo relacional de progrmaEntity
 * @author dayan Olaya, Roberto Garcia
 */
public class ProgramaDto {
    
    /*
    *Identificacion del programa
    */
    private long idPrograma;
    /*
    *Identificación de la facultad
    */
    private FacultadDto Facultad;
    /*
    *Nombre del programa
    */
    private String nombrePrograma;
    private TipoCursoDto tipoCurso;
    private NivelAcademicoDto nivelAcademico;
    /*
    *Constructor basico
    */

    public ProgramaDto() {
    }
    
    /*
    *Constructor apartir de una entidad programa
    */

    public ProgramaDto(ProgramaEntity programa) {
        this.idPrograma = programa.getIdPrograma();
        this.nombrePrograma = programa.getNombrePrograma();
        if(programa.getFacultad() != null){
            FacultadEntity entity = new FacultadEntity();
            entity.setIdFacultad(programa.getFacultad().getIdFacultad());
            entity.setNombreFacultad(programa.getFacultad().getNombreFacultad());
            this.Facultad = new FacultadDto(entity);
        }
        if(programa.getNivelAcademico() != null){
            NivelAcademicoEntity entity = new NivelAcademicoEntity();
            entity.setCursos(programa.getNivelAcademico().getCursos());
            entity.setIdNivelAcademico(programa.getNivelAcademico().getIdNivelAcademico());
            entity.setNombreNivelAcademico(programa.getNivelAcademico().getNombreNivelAcademico());
            this.nivelAcademico = new NivelAcademicoDto(entity);
        }
        if(programa.getTipoCurso() != null){
            TipoCursoEntity entity = new TipoCursoEntity();
            entity.setIdTipoCurso(programa.getTipoCurso().getIdTipoCurso());
            entity.setNombreTipoCurso(programa.getTipoCurso().getNombreTipoCurso());
//            entity.setPrograma(programa.getTipoCurso().getPrograma());
            this.tipoCurso = new TipoCursoDto(entity);
        }
    }
    
    /*
    *Crear una entidad apartir de un modelo relacional
    *@return ProgramaEntity
    */
    public ProgramaEntity toEntity(){
        ProgramaEntity entity = new ProgramaEntity();
        entity.setIdPrograma(this.idPrograma);
        entity.setFacultad(this.Facultad.toEntity());
        entity.setNombrePrograma(this.nombrePrograma);
        entity.setNivelAcademico(this.nivelAcademico.toEntity());
         entity.setTipoCurso(this.tipoCurso.toEnntity());
        return entity;
    }
    
    /*
    *Metodo para crear una lista de objetos relacionales a partir de una lista 
    *de la entidad programa
    */
    public static List<ProgramaDto> toProgramaList(List<ProgramaEntity> programaList){
       List<ProgramaDto> ProgramaDtoList = new ArrayList<>();
       for(ProgramaEntity entity : programaList){
           ProgramaDtoList.add(new ProgramaDto(entity));
       }
       return ProgramaDtoList;
    }
    
    /*
    *getters and setters
    */

    public long getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(long idPrograma) {
        this.idPrograma = idPrograma;
    }

    

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public FacultadDto getFacultad() {
        return Facultad;
    }

    public void setFacultad(FacultadDto Facultad) {
        this.Facultad = Facultad;
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
