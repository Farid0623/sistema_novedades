package cue.edu.co.sistema_novedades.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualizarRequest {
    private String identificacionId;
    private String nombre;
    private String apellido;
    private String programaFormacion;
    private String descripcion;
}
