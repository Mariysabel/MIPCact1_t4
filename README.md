# Proyecto Spring Boot: datos del alumno y materias

**Autor:** Mariysabel

Aplicación web desarrollada con Spring Boot para practicar controladores MVC,
vistas Thymeleaf y endpoints REST que devuelven JSON. El ejemplo principal
muestra la información de un alumno, su tutor y las materias que cursa.

## Requisitos

- Java 25 o superior.
- Maven. El proyecto incluye Maven Wrapper.

## Tecnologías

- Spring Boot 4.1.2
- Spring MVC (`spring-boot-starter-webmvc`)
- Thymeleaf mediante `spring-boot-starter-thymeleaf`
- Spring Boot DevTools
- Endpoints REST con JSON

## Ejecutar el proyecto

Desde la carpeta raíz del proyecto:

```powershell
.\mvnw.cmd spring-boot:run
```

La aplicación utiliza el puerto `8082`, configurado en `application.properties`.

También se puede compilar y ejecutar el archivo JAR:

```powershell
.\mvnw.cmd package
java -jar target/springboot-aplications-0.0.1-SNAPSHOT.jar
```

## Estructura del proyecto

```text
src/main/java/com/act1/spring/app1/springboot_aplications/
├── SpringbootAplicationsApplication.java
└── controllers/
    ├── AlumnoController.java
    ├── AlumnoRestController.java
    └── MateriaRestController.java

src/main/resources/
├── application.properties
└── templates/
    └── detalles_alumno.html
```

## Configuración

En `application.properties` se define:

```properties
server.port=8082
spring.application.name=springboot-aplications
```

## Controladores MVC y vistas Thymeleaf

El controlador MVC se encuentra en:

```text
src/main/java/com/act1/spring/app1/springboot_aplications/controllers/AlumnoController.java
```

### GET /detalles_alumno

URL completa:

```text
http://localhost:8082/detalles_alumno
```

Muestra la vista `detalles_alumno.html`. El controlador envía los atributos
`titulo` y `prueba` mediante `Model`:

```java
model.addAttribute("titulo", "Servidor en linea");
model.addAttribute("prueba", "Servidor en linea");
```

La vista los muestra con `th:text`:

```html
<h1 th:text="${titulo}"></h1>
<h2 th:text="${prueba}"></h2>
```

## Endpoints REST

Los controladores REST usan `@RestController`, por lo que cada método devuelve
su resultado directamente como JSON.

```text
src/main/java/com/act1/spring/app1/springboot_aplications/controllers/AlumnoRestController.java
src/main/java/com/act1/spring/app1/springboot_aplications/controllers/MateriaRestController.java
```

### GET /alumno

URL completa:

```text
http://localhost:8082/alumno
```

Devuelve en JSON el nombre del alumno, construido con un `Map<String, Object>`.

Respuesta esperada:

```json
{
  "Nombre": "María Isabel Pérez Cruz"
}
```

### GET /tutor

URL completa:

```text
http://localhost:8082/tutor
```

Devuelve en JSON el nombre y el contacto del tutor, construidos con `Map.of`.

Respuesta esperada:

```json
{
  "nombre": "Sonia Araceli Cruz Méndez",
  "contacto": "9512444635"
}
```

### GET /materias

URL completa:

```text
http://localhost:8082/materias
```

Devuelve en JSON el nombre del alumno y una lista de materias. Cada materia
incluye `Nombre`, `Creditos` y `Semestre`.

Respuesta esperada (el orden de las claves puede variar, ya que se usa
`HashMap`):

```json
{
  "Alumno": "María Isabel Pérez Cruz",
  "Materias": [
    {
      "Nombre": "Desarrollo de Aplicaciones Web",
      "Creditos": 5,
      "Semestre": 7
    },
    {
      "Nombre": "Administración de Bases de Datos",
      "Creditos": 5,
      "Semestre": 7
    },
    {
      "Nombre": "Ingeniería de Software",
      "Creditos": 4,
      "Semestre": 7
    }
  ]
}
```

## Resumen de rutas

| Método | Ruta               | Tipo de respuesta        |
| ------ | ------------------ | ------------------------ |
| GET    | `/detalles_alumno` | Vista Thymeleaf (HTML)   |
| GET    | `/alumno`          | JSON                     |
| GET    | `/tutor`           | JSON                     |
| GET    | `/materias`        | JSON                     |

## Pruebas

El proyecto incluye una prueba `contextLoads` que verifica que el contexto de
Spring se carga correctamente.

Para ejecutar las pruebas automatizadas:

```powershell
.\mvnw.cmd test
```
