package idat.exa.parcial.service;
import idat.exa.parcial.model.Solicitud;
import java.util.List;

public interface SolicitudService {
    Solicitud crearSolicitud(Solicitud solicitud);
    List<Solicitud> obtenerTodas();
    Solicitud obtenerPorId(Long id);
    Solicitud actualizarSolicitud(Long id, Solicitud solicitud);
    void eliminarSolicitud(Long id);
}