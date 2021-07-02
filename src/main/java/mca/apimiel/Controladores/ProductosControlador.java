package mca.apimiel.Controladores;
import java.net.URI;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.validation.Errors;
import mca.apimiel.Entidades.Producto;
import mca.apimiel.Repositorios.ProductosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Unknow
 */
@RestController
@RequestMapping(path = "/apimiel/web")
public class ProductosControlador {

    @Autowired
    ProductosRepositorio productosRepositorio;

    //Se obtienen todas las asociaciones

    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return productosRepositorio.findAll();
    }

    //Se obtiene una asociación por ID
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> getProductos(@PathVariable("id") String id){
        Optional<Producto> pro = productosRepositorio.findById(id);
        if(!pro.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pro.get());
    }

    //Método para agregar una asociación
    @PostMapping("/productos/agregar")
    public ResponseEntity agregarProducto(@RequestBody @Valid Producto pro, Errors errores){
        try{
            if(errores.hasFieldErrors()){
                String mensaje = errores.getFieldErrors().
                        stream().map(fe -> fe.getField() + " " + fe.getDefaultMessage()).
                        collect(Collectors.joining(","));
                return ResponseEntity.badRequest().
                        header("ERROR",mensaje).
                        build();
            }
            Date d = new Date();
            pro.setActualizacion(d);
            productosRepositorio.save(pro);
            URI urlNuevoProducto = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .build(pro.getIdProducto());

            return ResponseEntity
                    .created(urlNuevoProducto)
                    //.body(art);
                    .build();
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .header("ERROR", ex.getMessage())
                    .build();
        }

    }


    @PutMapping("/productos/modificar/{id}")
    public ResponseEntity modificarProducto(
            @PathVariable("id") String id,
            @RequestBody Producto pro
    ){
        try{
            pro.setIdProducto(id);
            Date d = new Date();
            pro.setActualizacion(d);
            productosRepositorio.save(pro);
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

    //Método para eliminar una asociación
    @DeleteMapping("/productos/eliminar/{id}")
    public ResponseEntity eliminarProducto(@PathVariable String id){
        try{
            productosRepositorio.deleteById(id);
            return ResponseEntity
                    .ok()
                    .build();
        }
        catch(Exception ex){
            return ResponseEntity.
                    status(500).
                    header("ERROR",ex.getMessage()).
                    build();
        }
    }
}
