package idat.exa.parcial.repository;

import idat.exa.parcial.model.Solicitud;
import java.util.List;
import java.util.Optional;

public interface SolicitudRepository {
    Solicitud save(Solicitud solicitud);
    List<Solicitud> findAll();
    Optional<Solicitud> findById(Long id);
    void deleteById(Long id);
}