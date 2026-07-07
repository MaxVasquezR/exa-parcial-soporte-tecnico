package idat.exa.parcial.service; // Ajusta tu paquete

import idat.exa.parcial.dto.SolicitudCreateDTO;
import idat.exa.parcial.dto.SolicitudResponseDTO;
import idat.exa.parcial.exception.RecursoNoEncontradoException;
import idat.exa.parcial.model.Solicitud;
import idat.exa.parcial.repository.SolicitudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository repository;

    // Inyectamos el repositorio
    public SolicitudServiceImpl(SolicitudRepository repository) {
        this.repository = repository;
    }

    @Override
    public SolicitudResponseDTO crearSolicitud(SolicitudCreateDTO dto) {
        // Convertimos DTO a Modelo
        Solicitud solicitud = new Solicitud();
        solicitud.setTitulo(dto.getTitulo());
        solicitud.setDescripcion(dto.getDescripcion());
        solicitud.setCliente(dto.getCliente());
        solicitud.setTecnico(dto.getTecnico());
        solicitud.setEstado("Abierto");
        solicitud.setFechaCreacion(LocalDate.now());

        // Guardamos usando el repositorio
        Solicitud saved = repository.save(solicitud);

        // Convertimos Modelo a DTO de Respuesta
        return mapToResponseDTO(saved);
    }

    @Override
    public List<SolicitudResponseDTO> obtenerTodas() {
        return repository.findAll().stream().map(this::mapToResponseDTO).toList();
    }

    @Override
    public SolicitudResponseDTO obtenerPorId(Long id) {
        Solicitud solicitud = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Solicitud no encontrada con id: " + id));
        return mapToResponseDTO(solicitud);
    }

    @Override
    public SolicitudResponseDTO actualizarSolicitud(Long id, SolicitudCreateDTO dto) {
        Solicitud solicitudExistente = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Solicitud no encontrada con id: " + id));

        solicitudExistente.setTitulo(dto.getTitulo());
        solicitudExistente.setDescripcion(dto.getDescripcion());
        solicitudExistente.setCliente(dto.getCliente());
        solicitudExistente.setTecnico(dto.getTecnico());

        return mapToResponseDTO(solicitudExistente);
    }

    @Override
    public void eliminarSolicitud(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new RecursoNoEncontradoException("Solicitud no encontrada con id: " + id);
        }
        repository.deleteById(id);
    }

    // Método privado para no repetir código de conversión
    private SolicitudResponseDTO mapToResponseDTO(Solicitud solicitud) {
        SolicitudResponseDTO responseDTO = new SolicitudResponseDTO();
        responseDTO.setId(solicitud.getId());
        responseDTO.setTitulo(solicitud.getTitulo());
        responseDTO.setDescripcion(solicitud.getDescripcion());
        responseDTO.setEstado(solicitud.getEstado());
        responseDTO.setFechaCreacion(solicitud.getFechaCreacion());
        responseDTO.setCliente(solicitud.getCliente());
        responseDTO.setTecnico(solicitud.getTecnico());
        return responseDTO;
    }
}