package cue.edu.co.sistema_novedades.model;

import java.time.LocalDateTime;

public class NovedadCertificado extends Novedad {
    public NovedadCertificado(String identificacionId, String nombre, String apellido, String programaFormacion, LocalDateTime fecha, String descripcion) {
        super(identificacionId, nombre, apellido, programaFormacion, fecha, descripcion);
        setTipo(getTipo());
    }

    @Override
    public String getTipo() {
        return "Certificado";
    }
}
