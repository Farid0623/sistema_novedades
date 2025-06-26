package cue.edu.co.sistema_novedades.service;

import cue.edu.co.sistema_novedades.model.Novedad;
import cue.edu.co.sistema_novedades.model.TipoNovedad;

import java.util.List;
import java.time.LocalDateTime;

public interface NovedadService {
    Novedad crearNovedad(TipoNovedad tipo, String identificacionId, String nombre, String apellido,
                         String programaFormacion, LocalDateTime fecha, String descripcion);

    List<Novedad> obtenerTodas();
    Novedad obtenerPorId(String id);

    // Métodos personalizados
    List<Novedad> buscarPorEstudiante(String identificacionId);
    List<Novedad> listarPorTipo(String tipo);
    Novedad actualizarTipoNovedad(String identificacionId, TipoNovedad tipoActual, TipoNovedad tipoNuevo);

    Novedad actualizarNovedad(String id, String descripcion);
    void eliminarNovedad(String id);
}