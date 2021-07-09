package mca.apimiel.Controladores;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.validation.Errors;
import mca.apimiel.Entidades.Asociacion;
import mca.apimiel.Repositorios.AsociacionesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path= "/apimiel/web")
public class AsociacionesControlador {
    @Autowired
    AsociacionesRepositorio asociacionesRepositorio;

    //Se obtienen todas las asociaciones

    @GetMapping("/asociaciones")
    public List<Asociacion> getAsociaciones(){
        return asociacionesRepositorio.findAll();
    }

    //Se obtiene una asociación por ID
    @GetMapping("/asociaciones/{id}")
    public ResponseEntity<Asociacion> getAsociacion(@PathVariable("id") String id){
        Optional<Asociacion> aso = asociacionesRepositorio.findById(id);
        if(!aso.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aso.get());
    }

    //Método para agregar una asociación
    @PostMapping("/asociaciones/agregar")
    public ResponseEntity agregarAsociacion(@RequestBody @Valid Asociacion aso, Errors errores){
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
            aso.setActualizacion(d);
            asociacionesRepositorio.save(aso);
            URI urlNuevaAsociacion= ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .build(aso.getIdAsociacion());

            return ResponseEntity
                    .created(urlNuevaAsociacion)
                    //.body(art);
                    .build();
        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .header("ERROR", ex.getMessage())
                    .build();
        }

    }


    @PutMapping("/asociaciones/modificar/{id}")
    public ResponseEntity modificarAsociacion(
            @PathVariable("id") String id,
            @RequestBody Asociacion aso
    ){
        try{
            aso.setIdAsociacion(id);
            Date d = new Date();
            aso.setActualizacion(d);
            asociacionesRepositorio.save(aso);
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
    @DeleteMapping("/asociaciones/eliminar/{id}")
    public ResponseEntity eliminarAsociacion(@PathVariable String id){
        try{
            asociacionesRepositorio.deleteById(id);
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
