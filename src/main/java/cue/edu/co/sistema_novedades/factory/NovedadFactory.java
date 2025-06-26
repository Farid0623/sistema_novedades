package cue.edu.co.sistema_novedades.factory;

import cue.edu.co.sistema_novedades.model.*;

import java.time.LocalDateTime;

public class NovedadFactory {

    public static Novedad crearNovedad(
            TipoNovedad tipo,
            String identificacionId,
            String nombre,
            String apellido,
            String programaFormacion,
            LocalDateTime fecha,
            String descripcion
    ) {
        return switch (tipo) {
            case EN_INDUCCION -> new NovedadEnInduccion(identificacionId, nombre, apellido, programaFormacion, fecha, descripcion);
            case EN_FORMACION -> new NovedadEnFormacion(identificacionId, nombre, apellido, programaFormacion, fecha, descripcion);
            case RETIRO_VOLUNTARIO -> new NovedadRetiroVoluntario(identificacionId, nombre, apellido, programaFormacion, fecha, descripcion);
            case CANCELADO -> new NovedadCancelado(identificacionId, nombre, apellido, programaFormacion, fecha, descripcion);
            case CERTIFICADO -> new NovedadCertificado(identificacionId, nombre, apellido, programaFormacion, fecha, descripcion);
            default -> throw new IllegalArgumentException("Tipo de novedad no soportado: " + tipo);
        };
    }
}
