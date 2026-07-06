package idat.exa.parcial.model;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

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


    public Solicitud() {}

    public Solicitud(Long id, String titulo, String descripcion, Cliente cliente, Tecnico tecnico) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = "Abierto";
        this.fechaCreacion = LocalDate.now();
        this.cliente = cliente;
        this.tecnico = tecnico;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDate getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Tecnico getTecnico() { return tecnico; }
    public void setTecnico(Tecnico tecnico) { this.tecnico = tecnico; }
}