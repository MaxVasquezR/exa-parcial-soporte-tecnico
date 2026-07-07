package idat.exa.parcial.controller;

import idat.exa.parcial.dto.SolicitudCreateDTO;
import idat.exa.parcial.dto.SolicitudResponseDTO;
import idat.exa.parcial.service.SolicitudService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @PostMapping
    public ResponseEntity<SolicitudResponseDTO> crear(@Valid @RequestBody SolicitudCreateDTO dto) {
        SolicitudResponseDTO nueva = solicitudService.crearSolicitud(dto);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SolicitudResponseDTO>> obtenerTodas() {
        return ResponseEntity.ok(solicitudService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(solicitudService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody SolicitudCreateDTO dto) {
        return ResponseEntity.ok(solicitudService.actualizarSolicitud(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        solicitudService.eliminarSolicitud(id);
        return ResponseEntity.noContent().build();
    }
}