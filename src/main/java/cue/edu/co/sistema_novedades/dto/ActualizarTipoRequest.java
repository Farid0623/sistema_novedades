package cue.edu.co.sistema_novedades.dto;

import cue.edu.co.sistema_novedades.model.TipoNovedad;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualizarTipoRequest {
    private String identificacionId;
    private TipoNovedad tipoActual;
    private TipoNovedad tipoNuevo;
}
