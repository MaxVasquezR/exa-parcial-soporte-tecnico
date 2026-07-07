package idat.exa.parcial.service;

import idat.exa.parcial.dto.SolicitudCreateDTO;
import idat.exa.parcial.dto.SolicitudResponseDTO;
import java.util.List;

public interface SolicitudService {
    SolicitudResponseDTO crearSolicitud(SolicitudCreateDTO dto);
    List<SolicitudResponseDTO> obtenerTodas();
    SolicitudResponseDTO obtenerPorId(Long id);
    SolicitudResponseDTO actualizarSolicitud(Long id, SolicitudCreateDTO dto);
    void eliminarSolicitud(Long id);
}