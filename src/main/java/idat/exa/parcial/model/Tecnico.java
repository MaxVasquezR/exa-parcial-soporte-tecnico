package idat.exa.parcial.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tecnico {
    @NotBlank(message = "El nombre del técnico es obligatorio")
    private String nombre;
    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;
}