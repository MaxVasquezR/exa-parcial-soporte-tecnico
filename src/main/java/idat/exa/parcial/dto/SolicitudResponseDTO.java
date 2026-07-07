package idat.exa.parcial.dto;

import idat.exa.parcial.model.Cliente;
import idat.exa.parcial.model.Tecnico;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SolicitudResponseDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private String estado;
    private LocalDate fechaCreacion;
    private Cliente cliente;
    private Tecnico tecnico;
}