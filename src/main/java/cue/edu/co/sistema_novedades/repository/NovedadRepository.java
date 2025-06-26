package cue.edu.co.sistema_novedades.repository;

import cue.edu.co.sistema_novedades.model.Novedad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NovedadRepository extends MongoRepository<Novedad, String> {
    List<Novedad> findByIdentificacionId(String identificacionId);

    List<Novedad> findByTipo(String tipo);

    Optional<Novedad> findByIdentificacionIdAndTipo(String identificacionId, String tipo);
}
