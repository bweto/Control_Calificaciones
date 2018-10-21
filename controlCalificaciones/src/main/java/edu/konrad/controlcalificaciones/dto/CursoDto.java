package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.CursoEntity;
import edu.konrad.controlcalificaciones.entities.EstudianteEntity;
import edu.konrad.controlcalificaciones.entities.GrupoEntity;
//import edu.konrad.controlcalificaciones.entities.NivelAcademicoEntity;
//import edu.konrad.controlcalificaciones.entities.ProfesorEntity;
//import edu.konrad.controlcalificaciones.entities.TipoCursoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 Clase Dto para realizar el mapeo relacional de la información de los
 * cursos
 * @author Dayan olaya y Roberto Garcia
 */
public class CursoDto {

    public static List<CursoDto> toCursoList(List<CursoEntity> curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private long idCurso;
    private String nombreCurso;
//    private ProfesorDto profesor;
    private GrupoDto grupo;
    private List<EstudianteDto> estudiante;
//    private TipoCursoDto tipoCurso;
//    private NivelAcademicoDto nivelAcademico;
    
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
//        if(curso.getProfesor() != null){
//            ProfesorEntity entity = new ProfesorEntity();
//            //entity.setArea(curso.getProfesor().getArea());
//            entity.setCantidadCursos(curso.getProfesor().getCantidadCursos());
//            entity.setIdProfesor(curso.getProfesor().getIdProfesor());
//            entity.setUsuario(curso.getProfesor().getUsuario());
//            this.profesor = new ProfesorDto(entity);
//        }
        int i = 0;
        for(EstudianteEntity entity: curso.getEstudiante()){
            if(entity != null){
                entity.setIdEstudiante(curso.getEstudiante().get(i).getIdEstudiante());
                entity.setCodigoEstudiante(curso.getEstudiante().get(i).getCodigoEstudiante());
                entity.setCantidadMaterias(curso.getEstudiante().get(i).getCantidadMaterias());
                entity.setUsuario(curso.getEstudiante().get(i).getUsuario());
                entity.setPrograma(curso.getEstudiante().get(i).getPrograma());
                EstudianteDto dto = new EstudianteDto(entity);
                this.estudiante.add(dto);
                i++;
            }
        }
        if(curso.getGrupo() != null){
            GrupoEntity entity = new GrupoEntity();
            entity.setCupo(curso.getGrupo().getCupo());
            entity.setHorario(curso.getGrupo().getHorario());
            entity.setIdGrupo(curso.getGrupo().getIdGrupo());
            entity.setProfesor(curso.getGrupo().getProfesor());
            this.grupo = new GrupoDto(entity);
        }

       
    }
    
    /*
    *crear un entity apartir de un dto
    */
     public CursoEntity toEntity(){
        CursoEntity entity = new CursoEntity();
        entity.setIdCurso(this.idCurso);
//        entity.setNivelAcademico(this.nivelAcademico.toEntity());
        entity.setNombreCurso(this.nombreCurso);
//        entity.setProfesor(this.profesor.toEntity());
        entity.setGrupo(this.grupo.toEntity());
//        entity.setTipoCurso(this.tipoCurso.toEnntity());
        List<EstudianteEntity> listaEstudiante = new ArrayList<>();
        for(EstudianteDto dto : this.estudiante){
            listaEstudiante.add(dto.toEntity()); 
        }
         entity.setEstudiante(listaEstudiante);
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

    public GrupoDto getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoDto grupo) {
        this.grupo = grupo;
    }

    public List<EstudianteDto> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(List<EstudianteDto> estudiante) {
        this.estudiante = estudiante;
    }

}
