package idat.exa.parcial.controller;
import idat.exa.parcial.model.Solicitud;
import idat.exa.parcial.service.SolicitudService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController // controlador REST
@RequestMapping("/api/solicitudes") // URL base para todos los endpoints
public class SolicitudController {

    private final SolicitudService solicitudService;


    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }


    @PostMapping
    public ResponseEntity<Solicitud> crear(@Valid @RequestBody Solicitud solicitud) {
        Solicitud nueva = solicitudService.crearSolicitud(solicitud);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Solicitud>> obtenerTodas() {
        return ResponseEntity.ok(solicitudService.obtenerTodas());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(solicitudService.obtenerPorId(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizar(@PathVariable Long id, @Valid @RequestBody Solicitud solicitud) {
        return ResponseEntity.ok(solicitudService.actualizarSolicitud(id, solicitud));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        solicitudService.eliminarSolicitud(id);
        return ResponseEntity.noContent().build();
    }
}