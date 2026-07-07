package idat.exa.parcial.model;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {
    private Long id;
    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;
    private String estado;
    private LocalDate fechaCreacion;
    @Valid @NotNull(message = "El cliente es obligatorio")
    private Cliente cliente;
    @Valid @NotNull(message = "El técnico es obligatorio")
    private Tecnico tecnico;
}