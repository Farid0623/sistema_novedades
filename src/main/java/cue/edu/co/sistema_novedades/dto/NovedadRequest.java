package cue.edu.co.sistema_novedades.dto;

import cue.edu.co.sistema_novedades.model.TipoNovedad;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class NovedadRequest {
    private TipoNovedad tipo;
    private String identificacionId;
    private String nombre;
    private String apellido;
    private String programaFormacion;
    private String descripcion;
}
