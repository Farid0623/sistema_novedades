package cue.edu.co.sistema_novedades.service.impl;

import cue.edu.co.sistema_novedades.dto.ActualizarRequest;
import cue.edu.co.sistema_novedades.factory.NovedadFactory;
import cue.edu.co.sistema_novedades.model.Novedad;
import cue.edu.co.sistema_novedades.model.TipoNovedad;
import cue.edu.co.sistema_novedades.repository.NovedadRepository;
import cue.edu.co.sistema_novedades.service.NovedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
public class NovedadServiceImpl implements NovedadService {

    private final NovedadRepository novedadRepository;

    @Autowired
    public NovedadServiceImpl(NovedadRepository novedadRepository) {
        this.novedadRepository = novedadRepository;
    }

    @Override
    public Novedad crearNovedad(TipoNovedad tipo, String identificacionId, String nombre, String apellido,
                                String programaFormacion, LocalDateTime fecha, String descripcion) {

        List<Novedad> existentes = novedadRepository.findByIdentificacionId(identificacionId);
        if (!existentes.isEmpty()) {
            throw new IllegalArgumentException("Ya existe una novedad para el identificacionId: " + identificacionId);
        }

        Novedad novedad = NovedadFactory.crearNovedad(tipo, identificacionId, nombre, apellido,
                programaFormacion, fecha, descripcion);
        return novedadRepository.save(novedad);
    }

    @Override
    public List<Novedad> obtenerTodas() {
        return novedadRepository.findAll();
    }

    @Override
    public Novedad obtenerPorId(String id) {
        Optional<Novedad> novedad = novedadRepository.findById(id);
        return novedad.orElse(null);
    }

    @Override
    public List<Novedad> buscarPorEstudiante(String identificacionId) {
        return novedadRepository.findByIdentificacionId(identificacionId);
    }

    @Override
    public List<Novedad> listarPorTipo(String tipo) {
        return novedadRepository.findByTipo(tipo);
    }

    @Override
    public Novedad actualizarTipoNovedad(String identificacionId, TipoNovedad tipoActual, TipoNovedad tipoNuevo) {
        // Buscar la novedad actual del estudiante por tipo
        Optional<Novedad> novedadActual = novedadRepository.findByIdentificacionIdAndTipo(
                identificacionId,
                obtenerStringTipo(tipoActual)
        );

        if (novedadActual.isPresent()) {
            Novedad novedad = novedadActual.get();

            // Crear nueva novedad con el nuevo tipo manteniendo los datos del estudiante
            Novedad nuevaNovedad = NovedadFactory.crearNovedad(
                    tipoNuevo,
                    novedad.getIdentificacionId(),
                    novedad.getNombre(),
                    novedad.getApellido(),
                    novedad.getProgramaFormacion(),
                    LocalDateTime.now(), // Nueva fecha de actualización
                    "Actualización de estado de " + obtenerStringTipo(tipoActual) + " a " + obtenerStringTipo(tipoNuevo)
            );

            // Eliminar la novedad anterior
            novedadRepository.delete(novedad);

            // Guardar la nueva novedad
            return novedadRepository.save(nuevaNovedad);
        }

        return null; // No se encontró la novedad actual
    }

    @Override
    public Novedad actualizarNovedad(String id, ActualizarRequest request) {
        Optional<Novedad> optionalNovedad = novedadRepository.findById(id);
        if (optionalNovedad.isPresent()) {
            Novedad novedad = optionalNovedad.get();

            if (request.getIdentificacionId() != null) {
                novedad.setIdentificacionId(request.getIdentificacionId());
            }
            if (request.getNombre() != null) {
                novedad.setNombre(request.getNombre());
            }
            if (request.getApellido() != null) {
                novedad.setApellido(request.getApellido());
            }
            if (request.getProgramaFormacion() != null) {
                novedad.setProgramaFormacion(request.getProgramaFormacion());
            }
            if (request.getDescripcion() != null) {
                novedad.setDescripcion(request.getDescripcion());
            }

            return novedadRepository.save(novedad);
        }
        return null;
    }

    @Override
    public void eliminarNovedad(String id) {
        novedadRepository.deleteById(id);
    }

    private String obtenerStringTipo(TipoNovedad tipo) {
        switch (tipo) {
            case EN_INDUCCION: return "En Induccion";
            case EN_FORMACION: return "En Formacion";
            case RETIRO_VOLUNTARIO: return "Retiro Voluntario";
            case CANCELADO: return "Cancelado";
            case CERTIFICADO: return "Certificado";
            default: return "";
        }
    }
}
