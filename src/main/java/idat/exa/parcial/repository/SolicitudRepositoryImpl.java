package idat.exa.parcial.repository;
import idat.exa.parcial.model.Solicitud;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class SolicitudRepositoryImpl implements SolicitudRepository {

    private final List<Solicitud> solicitudes = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Solicitud save(Solicitud solicitud) {
        solicitud.setId(idGenerator.getAndIncrement());
        solicitudes.add(solicitud);
        return solicitud;
    }

    @Override
    public List<Solicitud> findAll() {
        return solicitudes;
    }

    @Override
    public Optional<Solicitud> findById(Long id) {
        return solicitudes.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        solicitudes.removeIf(s -> s.getId().equals(id));
    }
}