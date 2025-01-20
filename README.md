# LiterAlura

**LiterAlura** es una aplicación que interactúa con la API de Gutendex para obtener información sobre libros y autores. Permite registrar autores y libros, y obtener datos de libros desde una base de datos embebida, facilitando la gestión de información literaria.

## Funcionalidades principales

- **Búsqueda de libros**: Permite buscar libros por título y obtener información adicional de la API de Gutendex.
- **Registro de autores**: Si un autor no está registrado, se registra automáticamente en la base de datos.
- **Asociación de autores a libros**: Los libros registrados pueden asociarse con autores existentes.
- **Base de datos embebida**: Utiliza una base de datos embebida para almacenar los registros de libros y autores.

## Requisitos previos

- JDK 11 o superior
- Maven
- IDE (por ejemplo, IntelliJ IDEA, Eclipse)
- Conexión a internet (para interactuar con la API de Gutendex)

## Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/LiterAlura.git
cd LiterAlura
