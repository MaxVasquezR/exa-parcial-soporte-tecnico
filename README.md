# API REST - Solicitudes de Soporte Técnico

API desarrollada con **Java 21** y **Spring Boot 3.5** para registrar, consultar, actualizar y eliminar solicitudes de soporte técnico. Los datos se almacenan en memoria (sin base de datos).

## Requisitos

- Java 21 (JDK)
- Maven (incluido el wrapper `mvnw`)

## Instalación y ejecución

1. Clonar el repositorio:

```bash
git clone https://github.com/MaxVasquezR/exa-parcial-soporte-tecnico.git
cd exa-parcial-soporte-tecnico
```

2. Ejecutar la aplicación:

**Windows (PowerShell):**

```powershell
.\mvnw.cmd spring-boot:run
```

**Linux / macOS:**

```bash
./mvnw spring-boot:run
```

3. La API estará disponible en: `http://localhost:8080`

## Documentación Swagger

- Swagger UI: http://localhost:8080/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

## Endpoints

| Método | URL | Descripción |
|--------|-----|-------------|
| POST | `/api/solicitudes` | Crear solicitud |
| GET | `/api/solicitudes` | Listar todas |
| GET | `/api/solicitudes/{id}` | Obtener por ID |
| PUT | `/api/solicitudes/{id}` | Actualizar solicitud |
| DELETE | `/api/solicitudes/{id}` | Eliminar solicitud |

### Ejemplo de cuerpo (POST / PUT)

```json
{
  "titulo": "PC no enciende",
  "descripcion": "El equipo no responde al presionar el botón de encendido",
  "cliente": {
    "nombre": "Juan Pérez",
    "email": "juan@empresa.com"
  },
  "tecnico": {
    "nombre": "Carlos Ruiz",
    "especialidad": "Hardware"
  }
}
```

## Arquitectura

El proyecto sigue una arquitectura en capas:

1. **Controller** — Expone los endpoints REST y valida las peticiones entrantes.
2. **Service** — Contiene la lógica de negocio y el mapeo entre DTOs y modelos.
3. **Repository** — Gestiona el almacenamiento en memoria de las solicitudes.
4. **DTO** — Objetos de transferencia para las peticiones (`SolicitudCreateDTO`) y respuestas (`SolicitudResponseDTO`).
5. **Model** — Entidades del dominio (`Solicitud`, `Cliente`, `Tecnico`).
6. **Exception** — Manejo centralizado de errores (validación y recursos no encontrados).

## Estructura del proyecto

```
src/main/java/idat/exa/parcial/
├── controller/    # Controladores REST
├── service/       # Lógica de negocio e interfaces
├── repository/    # Persistencia en memoria
├── dto/           # Objetos de entrada y salida de la API
├── model/         # Entidades del dominio
└── exception/     # Manejo centralizado de errores
```

## Equipo

- Integrante 1: _(completar)_
- Integrante 2: _(completar)_
- Integrante 3: _(completar)_
