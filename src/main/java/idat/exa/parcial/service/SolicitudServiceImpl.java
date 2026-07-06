package idat.exa.parcial.service;
import idat.exa.parcial.exception.RecursoNoEncontradoException;
import idat.exa.parcial.model.Solicitud;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SolicitudServiceImpl implements SolicitudService {


    private final List<Solicitud> solicitudes = new ArrayList<>();


    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Solicitud crearSolicitud(Solicitud solicitud) {
        solicitud.setId(idGenerator.getAndIncrement());
        solicitud.setFechaCreacion(java.time.LocalDate.now());
        solicitud.setEstado("Abierto");
        solicitudes.add(solicitud);
        return solicitud;
    }

    @Override
    public List<Solicitud> obtenerTodas() {
        return solicitudes;
    }

    @Override
    public Solicitud obtenerPorId(Long id) {
        return solicitudes.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RecursoNoEncontradoException("Solicitud no encontrada con id: " + id));
    }

    @Override
    public Solicitud actualizarSolicitud(Long id, Solicitud solicitudActualizada) {
        Solicitud solicitudExistente = obtenerPorId(id);
        solicitudExistente.setTitulo(solicitudActualizada.getTitulo());
        solicitudExistente.setDescripcion(solicitudActualizada.getDescripcion());
        solicitudExistente.setEstado(solicitudActualizada.getEstado());
        solicitudExistente.setCliente(solicitudActualizada.getCliente());
        solicitudExistente.setTecnico(solicitudActualizada.getTecnico());
        return solicitudExistente;
    }

    @Override
    public void eliminarSolicitud(Long id) {
        Solicitud solicitud = obtenerPorId(id);
        solicitudes.remove(solicitud);
    }
}