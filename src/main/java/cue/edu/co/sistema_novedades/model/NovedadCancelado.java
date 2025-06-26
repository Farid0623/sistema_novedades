package cue.edu.co.sistema_novedades.model;


import java.time.LocalDateTime;

public class NovedadCancelado extends Novedad {
    public NovedadCancelado(String identificacionId, String nombre, String apellido, String programaFormacion, LocalDateTime fecha, String descripcion) {
        super(identificacionId, nombre, apellido, programaFormacion, fecha, descripcion);
        setTipo(getTipo());
    }

    @Override
    public String getTipo() {
        return "Cancelado";
    }
}
