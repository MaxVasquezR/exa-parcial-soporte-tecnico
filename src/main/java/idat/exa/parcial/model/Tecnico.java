package idat.exa.parcial.model;
import jakarta.validation.constraints.NotBlank;

public class Tecnico {
    @NotBlank(message = "El nombre del técnico es obligatorio")
    private String nombre;
    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    public Tecnico() {}

    public Tecnico(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}