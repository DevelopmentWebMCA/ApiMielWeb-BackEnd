# ApiMielWeb-BackEnd
El presente proyecto se realizó con el objetivo de construir una API REST utilizando spring-boot para la consulta y registro de información de un sistema encargado del control
de apicultura en la ciudad de Xalapa, Ver.
# Estructura del proyecto
El proyecto tiene las carpetas que crea por defecto un proyecto creado en spring, bajo este aspecto las carpetas de mayor relevancia en el proyecto son:
```
|-- bin
|-- src
  |-- main
    |-- java
      |-- mca
        |--apimiel
          |-- Controladores
          |-- Entidades    //Aqui se encuentran las entidades utilizadas en el proyecto
          |-- Repositorios // Archivos correspondientes a los repositorios que se encargarán de establecer los metodos HTTP para las peticiones 
          |-- Security     //Dedicado a implementar spring security para manejo de seguridad
          |-- Servicios   
  |-- resources
    |-- application.properties  //Archivo de configuración donde se especifica credenciales para la base de datos, puerto de servidor y seguridad
|--gitignore   //Aqui se especifican los archivos y carpetas que ignorará git para cambios
```
