# Sistema de Gestión de Novedades Estudiantiles

## Descripción

Este proyecto es una API REST para gestionar las novedades de los estudiantes, tales como su estado en el programa académico. Permite crear, consultar, actualizar y eliminar registros de novedades.

## Tecnologías Utilizadas

*   **Java:** Lenguaje de programación principal.
*   **Spring Boot:** Framework para facilitar el desarrollo de aplicaciones Java.
*   **Spring Data MongoDB:** Para la interacción con la base de datos MongoDB.
*   **MongoDB:** Base de datos NoSQL para el almacenamiento de la información.
*   **Maven:** Herramienta de gestión de dependencias y construcción del proyecto.

## Requisitos

*   Java 17 o superior
*   Maven instalado
*   MongoDB instalado y en ejecución

## Instrucciones de Ejecución

1.  **Clonar el repositorio:**

    ```bash
    git clone https://github.com/Farid0623/sistema_novedades.git
    cd sistema_novedades
    ```

2.  **Configurar la conexión a MongoDB:**

    Modificar el archivo `src/main/resources/application.properties` con la información de conexión a tu instancia de MongoDB:

    ```properties
    spring.data.mongodb.uri=mongodb://localhost:27017/novedadesdb
    spring.data.mongodb.database=novedadesdb
    ```

3.  **Compilar y ejecutar la aplicación:**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

    La aplicación estará disponible en el puerto 8080 por defecto.

## Notas Adicionales

*   Este proyecto utiliza el patrón de diseño Factory para la creación de objetos `Novedad`.
*   Se aplican principios SOLID para un código más mantenible y escalable.