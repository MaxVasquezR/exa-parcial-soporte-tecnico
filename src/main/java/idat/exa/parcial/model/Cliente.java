package idat.exa.parcial.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera Getters, Setters, toString, equals, hashCode
@NoArgsConstructor // Genera el constructor vacío (¡Arregla el error de Swagger!)
@AllArgsConstructor // Genera el constructor con todos los campos
public class Cliente {
    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String nombre;
    @NotBlank(message = "El email del cliente es obligatorio")
    private String email;
}