package edu.konrad.controlcalificaciones.dto;

import edu.konrad.controlcalificaciones.entities.CursoEntity;
//import edu.konrad.controlcalificaciones.entities.EstudianteEntity;
import edu.konrad.controlcalificaciones.entities.InscripcionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase encargada de hacer el mapeo relacional de los objetos de tipo inscripción 
 * 
 * @author Dayan Olaya Roberto Garcia
 */
public class InscripcionDto {

    private long idInscripcion;
     
    private CursoDto curso;
     
    private EstudianteDto estudiante;
    
    /*
    *Constructor Basico
    */
    public InscripcionDto() {
    }
    
    /*
    *Constructor de un objeto inscripcionDto a partir de un objeto inscripcionentity
    */
    public InscripcionDto(InscripcionEntity inscripcion) {
       this.idInscripcion = inscripcion.getIdInscripcion();
       if(inscripcion.getCurso()!= null){
           CursoEntity entity = new CursoEntity();
           entity.setGrupo(inscripcion.getCurso().getGrupo());
           entity.setIdCurso(inscripcion.getCurso().getIdCurso());
//           entity.setNivelAcademico(inscripcion.getCurso().getNivelAcademico());
           entity.setNombreCurso(inscripcion.getCurso().getNombreCurso());
//           entity.setProfesor(inscripcion.getCurso().getProfesor());
//           entity.setTipoCurso(inscripcion.getCurso().getTipoCurso());
           entity.setEstudiante(inscripcion.getCurso().getEstudiante());
           this.curso = new CursoDto(entity);
       } 
       
//       if(inscripcion.getEstudiante() != null){
//           EstudianteEntity entity = new EstudianteEntity();
//           entity.setCantidadMaterias(inscripcion.getEstudiante().getCantidadMaterias());
//           entity.setCodigoEstudiante(inscripcion.getEstudiante().getCodigoEstudiante());
//           entity.setIdEstudiante(inscripcion.getEstudiante().getIdEstudiante());
//           entity.setPrograma(inscripcion.getEstudiante().getPrograma());
//           entity.setUsuario(inscripcion.getEstudiante().getUsuario());
//           this.estudiante = new EstudianteDto(entity);
//                   
//        }
        
    }
    
    /*
     Crear una InscripcionEntity con un objeto relacional
     @return InscripcionEntity
    */
    public InscripcionEntity toEntity(){
        InscripcionEntity entity = new InscripcionEntity();
        entity.setIdInscripcion(this.idInscripcion);
        entity.setCurso(this.curso.toEntity());
//        entity.setEstudiante(this.estudiante.toEntity());
        return entity;
    }
    
    /*
     Metodo para crear una lista de objetos relacionaleas apartir de una lista
     de objetos inscripcionEntity
    */
    public static List<InscripcionDto> toInscripcionDtoList(List<InscripcionEntity> inscripcionList){
        List<InscripcionDto> inscripcionDtoList = new ArrayList<>();
        for(InscripcionEntity entity : inscripcionList){
            inscripcionDtoList.add(new InscripcionDto(entity));
        }
        return inscripcionDtoList;
    }

    public long getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(long idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public CursoDto getCurso() {
        return curso;
    }

    public void setCurso(CursoDto curso) {
        this.curso = curso;
    }

    public EstudianteDto getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDto estudiante) {
        this.estudiante = estudiante;
    }

}
