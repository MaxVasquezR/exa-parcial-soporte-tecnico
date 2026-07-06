# API REST - Solicitudes de Soporte Técnico

API desarrollada con **Java 21** y **Spring Boot 3.5** para registrar, consultar, actualizar y eliminar solicitudes de soporte técnico. Los datos se almacenan en memoria (sin base de datos).

## Requisitos

- Java 21 (JDK)
- Maven (incluido el wrapper `mvnw`)

## Instalación y ejecución

1. Clonar el repositorio:

```bash
git clone <URL_DEL_REPOSITORIO>
cd exa.parcial
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

## Estructura del proyecto

```
src/main/java/idat/exa/parcial/
├── controller/    # Controladores REST
├── service/       # Lógica de negocio
├── model/         # Entidades (Solicitud, Cliente, Tecnico)
└── exception/     # Manejo centralizado de errores
```

## Equipo

- Integrante 1: _(completar)_
- Integrante 2: _(completar)_
- Integrante 3: _(completar)_
