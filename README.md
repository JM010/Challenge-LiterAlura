# 📚 Literalura

Proyecto Java con **Spring Boot** orientado a consola (CLI) para consultar información de libros y autores desde una API pública, procesar los datos y persistirlos en una base de datos relacional.

---

## 📝 Descripción

**Literalura** es una aplicación de ejemplo pensada para practicar:

- Consumo de APIs REST
- Conversión de datos (DTO → Entidades)
- Persistencia con JPA/Hibernate
- Organización en capas siguiendo buenas prácticas

La aplicación se ejecuta por consola y presenta un **menú interactivo** que permite realizar búsquedas, listados y consultas sobre libros y autores.

---

## ✨ Características principales

- Aplicación **CLI** (no web) con menú interactivo.
- Consumo de una **API pública de libros**.
- Persistencia de datos usando **Spring Data JPA**.
- Relación entre entidades **Libro** y **Autor**.
- Uso de **DTOs** y **Mapper** para desacoplar la capa externa de la interna.
- Manejo de idiomas y criterios de búsqueda mediante **Enums**.

---

## 🧰 Tecnologías utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL**
- **Maven**
- **Jackson** (serialización/deserialización JSON)

---

## 🗂️ Estructura del proyecto

La estructura del proyecto sigue una organización en capas para mantener el codigo limpio y modular:

```
com.JCservicios.literalura
│
├── dto
│   ├── DatosAutor
│   └── DatosBook
│
├── entity
│   ├── Autor
│   └── Libro
│
├── Enum
│   ├── Busqueda
│   └── Idiomas
│
├── mapper
│   └── LibroMapper
│
├── principal
│   └── Principal
│
├── repository
│   ├── AutorRepository
│   └── LibrosRepository
│
├── service
│   ├── AutorService
│   ├── ConsumoAPI
│   ├── ConvertirDatos
│   ├── IConvertirDatos
│   └── LibroService
│
└── LiteraluraApplication
```

---

## 📦 Capas y responsabilidades

### `dto`
Clases que representan los datos tal como llegan desde la API externa. No tienen lógica de negocio ni anotaciones JPA.

### `entity`
Entidades JPA persistidas en la base de datos. Representan el modelo del dominio (Libro, Autor).

### `Enum`
Enums utilizados para:
- Tipos de búsqueda
- Idiomas disponibles de los libros

### `mapper`
Responsable de convertir DTOs en entidades del dominio, evitando acoplar la lógica de conversión a los servicios.

### `repository`
Interfaces que extienden de **JpaRepository** para acceder a la base de datos.

### `service`
Capa de negocio:
- Consumo de la API externa
- Conversión de datos
- Operaciones sobre libros y autores

### `principal`
Contiene la clase `Principal`, encargada de:
- Mostrar el menú por consola
- Leer la entrada del usuario
- Delegar acciones a los servicios

### `LiteraluraApplication`
Clase principal con el método `main`. Punto de entrada de la aplicación Spring Boot.

---

## ▶️ Uso de la aplicación

Al ejecutar la aplicación se muestra un **menú interactivo** en consola que permite:

1. Buscar libros por título.
2. Listar libros almacenados.
3. Listar autores registrados.
4. Listar libros por idioma.
5. Buscar autores por nombre.
6. Top 10 libros más descargados.
7. Estadísticas de descargas.
8. Listar Autores vivos por un año determinado.
0. Salir

Los libros obtenidos desde la API pueden persistirse para evitar búsquedas repetidas.

---

## ⚙️ Configuración

La configuración de la base de datos se realiza desde `application.properties`, utilizando variables de entorno para:

- Host de la base de datos
- Nombre de la base
- Usuario
- Contraseña

Hibernate se encarga de crear o actualizar el esquema según la configuración JPA.

---


## 📄 Licencia

Proyecto educativo / de práctica. Agregar licencia si se desea publicar o reutilizar.

---

