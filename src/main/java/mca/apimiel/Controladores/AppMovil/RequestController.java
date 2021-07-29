package mca.apimiel.Controladores.AppMovil;
import java.net.URI;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mca.apimiel.Entidades.*;
import mca.apimiel.Repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path= "/apimiel/movil")
public class RequestController {
    @Autowired
    AsociacionesRepositorio asociacionesRepositorio;
    @Autowired
    ProductosRepositorio productosRepositorio;
    @Autowired
    DetalleProduccionRepositorio dpRepositorio;
    @Autowired
    AreasFloracionRepositorio areasFloracionRepositorio;
    @Autowired
    ApicultoresRepositorio apicultoresRepositorio;
    @Autowired
    UsuariosRepositorio usuariosRepositorio;
    @Autowired
    NotasRepositorio postRepositorio;

    @Autowired
    ApicultoresRepositorioMovil apicultoresRepositorioMovil;

     //Petición de las asociaciones con una fecha de corte
    @GetMapping(value = "/asociaciones/{fechaCorte}")
    public List<Asociacion> getAsociacionesAferFecha(@PathVariable("fechaCorte") String fechaCorte){
        Date d = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        fechaCorte = fechaCorte.replace('-','/');
        try
        { d = formato.parse(fechaCorte); }
        catch(ParseException e){
            System.out.println("error " + e.getMessage());
        }
        return asociacionesRepositorio.getAsociacionesAfterFecha(d);
    }

    //Petición de los productos con una fecha de corte

    @GetMapping(value = "/productos/{fechaCorte}")
    public List<Producto> getProductosAfterFecha(@PathVariable("fechaCorte") String fechaCorte){
        Date d = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        fechaCorte = fechaCorte.replace('-','/');
        try
        { d = formato.parse(fechaCorte); }
        catch(ParseException e){
            System.out.println("error " + e.getMessage());
        }
        return productosRepositorio.getProductosAfterFecha(d);
    }


    //Petición de los apicultores con una fecha de corte
    @GetMapping(value = "/apicultores/{fechaCorte}")
    public List<ApicultorMovil> getApicultoresAfterFecha(@PathVariable("fechaCorte") String fechaCorte){
        Date d = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        fechaCorte = fechaCorte.replace('-','/');
        try
        { d = formato.parse(fechaCorte); }
        catch(ParseException e){
            System.out.println("error " + e.getMessage());
        }
        return apicultoresRepositorioMovil.getApicultoresAfterFecha(d);
    }

    //Petición de las áreas de floración con una fecha de corte
    @GetMapping(value = "/areas_floracion/{fechaCorte}")
    public List<AreaFloracion> getAreasFloracionAfterFecha(@PathVariable("fechaCorte") String fechaCorte){
        Date d = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        fechaCorte = fechaCorte.replace('-','/');
        try
        { d = formato.parse(fechaCorte); }
        catch(ParseException e){
            System.out.println("error " + e.getMessage());
        }
        return areasFloracionRepositorio.getAreasFloracionAfterFecha(d);
    }
    
    @GetMapping(value = "/post/{fechaCorte}")
    public List<Post> getPostAfterFecha(@PathVariable("fechaCorte") String fechaCorte){
        Date d = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        fechaCorte = fechaCorte.replace('-','/');
        try
        { d = formato.parse(fechaCorte); }
        catch(ParseException e){
            System.out.println("error " + e.getMessage());
        }
        return postRepositorio.getPostAfterFecha(d);
    }

    @GetMapping(value="/usuarios/{nombreUsuario}/{contrasenia}")
    public Usuario getUsuario(@PathVariable("nombreUsuario") String nombreUsuario, @PathVariable("contrasenia")
                              String contrasenia){
        Usuario user = usuariosRepositorio.findByNombreUsuarioAndContrasenia(nombreUsuario,contrasenia);
        return user;
    }

    //Petición para guardar la producción de un apicultor
    @PostMapping(value = "/detalle_produccion/agregar")
    public ResponseEntity agregarProduccion(@RequestBody @Valid DetalleProduccion dp, Errors errores){
        try{
            if(errores.hasFieldErrors()){
                String mensaje = errores.getFieldErrors().
                        stream().map(fe -> fe.getField() + " " + fe.getDefaultMessage()).
                        collect(Collectors.joining(","));
                return ResponseEntity.badRequest().
                        header("ERROR",mensaje).
                        build();
            }
            dpRepositorio.save(dp);
            URI urlNuevoProduccion = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .build(dp.getIdDetalleProduccion());

            return ResponseEntity
                    .created(urlNuevoProduccion)
                    //.body(art);
                    .build();
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .header("ERROR", ex.getMessage())
                    .build();
        }
    }

    @PutMapping("/detalle_produccion/modificar/{id}")
    public ResponseEntity modificarProduccion(
            @PathVariable("id") int id,
            @RequestBody DetalleProduccion det
    ){
        try{
            det.setIdDetalleProduccion(id);
            Date d = new Date();
            det.setIdDetalleProduccion(id);
            dpRepositorio.save(det);
            return ResponseEntity.
                    ok()
                    .build();
        }catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .header("ERROR", ex.getMessage())
                    .build();
        }
    }

}
