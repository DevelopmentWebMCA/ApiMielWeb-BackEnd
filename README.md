# ApiMielWeb-BackEnd
El presente proyecto se realizó con el objetivo de construir una API REST utilizando spring-boot para la consulta y registro de información de un sistema encargado del control de apicultura. La versión de java utilizada es la número 11.

### Las dependencias instaladas para este proyecto son:
```

Spring web
Spring data JPA
Spring Security

```
### Ejecución

Se debe tener creada la base de datos a"apimiel" adjunta en la carpeta modelos, junto con el usuario definido en el archivo properties. Una vez creada se puede ejecutar
el servidor Tomcat para spring.


### Estructura del proyecto
El proyecto tiene las carpetas que crea por defecto un proyecto creado en spring, bajo este aspecto las carpetas de mayor relevancia en el proyecto son:
```
|-- bin
|-- src
  |-- main
    |-- java
      |-- mca
        |--apimiel
          |-- Controladores
            |-- AppMovil
              |-- RequestController
            |--ApicultoresControlador
            |--AreasFloracionControlador
            |--AsociacionesControlador
            |--NotasControlador 
            |--ProductosControlador 
            |--RolesControlador 
            |--UsuariosControlador 
          |-- Entidades    //Aqui se encuentran las entidades utilizadas en el proyecto
            |--Apicultor
            |--ArchivoPost
            |--AreaFloracion
            |--Asociacion
            |--CategoriaPost
            |--DetalleProduccion
            |--Post
            |--Producto
            |--RolUsuario
            |--Usuario
          |-- Repositorios // Archivos correspondientes a los repositorios que se encargarán de establecer los metodos HTTP para las peticiones 
            |--ApicultoresRepositorio
            |--AreasFloracionRepositorio
            |--AsociacionesRepositorio
            |--DetalleProduccionRepositorio
            |--NotasRepositorio
            |--ProductosRepositorio
            |--RolesRepositorio
            |--UsuariosRepositorio
          |-- Security     //Dedicado a implementar spring security para manejo de seguridad
          |-- Servicios   
  |-- resources
    |-- application.properties  //Archivo de configuración donde se especifica credenciales para la base de datos, puerto de servidor y seguridad
|--gitignore   //Aqui se especifican los archivos y carpetas que ignorará git para cambios
```









