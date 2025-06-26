package cue.edu.co.sistema_novedades.controller;

import cue.edu.co.sistema_novedades.dto.ActualizarRequest;
import cue.edu.co.sistema_novedades.dto.ActualizarTipoRequest;
import cue.edu.co.sistema_novedades.dto.NovedadRequest;
import cue.edu.co.sistema_novedades.model.Novedad;
import cue.edu.co.sistema_novedades.service.NovedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/novedades")
public class NovedadController {

    private final NovedadService novedadService;

    @Autowired
    public NovedadController(NovedadService novedadService) {
        this.novedadService = novedadService;
    }

    @PostMapping
    public ResponseEntity<?> crearNovedad(@RequestBody NovedadRequest request) {

        try {
            Novedad novedad = novedadService.crearNovedad(
                    request.getTipo(),
                    request.getIdentificacionId(),
                    request.getNombre(),
                    request.getApellido(),
                    request.getProgramaFormacion(),
                    LocalDateTime.now(),
                    request.getDescripcion()
            );
            return ResponseEntity.ok(novedad);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Novedad> obtenerTodas() {
        return novedadService.obtenerTodas();
    }

    @GetMapping("/estudiante/{identificacionId}")
    public List<Novedad> buscarPorEstudiante(@PathVariable String identificacionId) {
        return novedadService.buscarPorEstudiante(identificacionId);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Novedad> listarPorTipo(@PathVariable String tipo) {
        return novedadService.listarPorTipo(tipo);
    }

    @PutMapping("/{id}")
    public Novedad actualizarNovedad(@PathVariable String id, @RequestBody ActualizarRequest request) {
        return novedadService.actualizarNovedad(id, request);
    }

    @PutMapping("/actualizar-tipo")
    public Novedad actualizarTipoNovedad(@RequestBody ActualizarTipoRequest request) {
        return novedadService.actualizarTipoNovedad(
                request.getIdentificacionId(),
                request.getTipoActual(),
                request.getTipoNuevo()
        );
    }

    @DeleteMapping("/{id}")
    public void eliminarNovedad(@PathVariable String id) {
        novedadService.eliminarNovedad(id);
    }
}
