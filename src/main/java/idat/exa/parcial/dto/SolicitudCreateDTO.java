package idat.exa.parcial.dto;

import idat.exa.parcial.model.Cliente;
import idat.exa.parcial.model.Tecnico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
    public class SolicitudCreateDTO {
    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @Valid @NotNull(message = "El cliente es obligatorio")
    private Cliente cliente;

    @Valid @NotNull(message = "El técnico es obligatorio")
    private Tecnico tecnico;
}