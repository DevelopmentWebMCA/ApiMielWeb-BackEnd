package mca.apimiel.Controladores;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mca.apimiel.Entidades.AreaFloracion;
import mca.apimiel.Repositorios.AreasFloracionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Andres Cuevas
 */

@RestController
@RequestMapping(path = "/apimiel/web")
public class AreasFloracionControlador {
    @Autowired
    AreasFloracionRepositorio repoAreas;
    
    @GetMapping("/areasfloracion")
    public List<AreaFloracion> getAreasFloracion() {
        return repoAreas.findAll();
    }
    
    @GetMapping("/areasfloracion/{id}")
    public ResponseEntity<AreaFloracion> getAreaFloracionPorId(@PathVariable("id") Integer id){
        Optional<AreaFloracion> areaId = repoAreas.findById(id);
        if (!areaId.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(areaId.get());
    }
    
    //Busquedas por parametros
    
    @GetMapping("/areasfloracion/page/{region}/{page}")
    public List<AreaFloracion> getAreasFloracionPage(@PathVariable("region") String region,@PathVariable("page") Integer page) {
        return repoAreas.findAllByRegion(region, PageRequest.of(page, 2));
    }
    
    @GetMapping(value = "/areasfloracion", params = {"region"})
    public List<AreaFloracion> buscarAreaPorRegion(
        @RequestParam("region") String cadena){
        return repoAreas.findByRegionEstadoContaining(cadena);
    }
    
    @GetMapping(value = "/areasfloracion", params = {"familia"})
    public List<AreaFloracion> buscarAreaPorFamilia(
        @RequestParam("familia") String cadena){
        return repoAreas.findByFamiliaFloresContaining(cadena);
    }
    
    @GetMapping(value = "/areasfloracion", params = {"nombre"})
    public List<AreaFloracion> buscarAreaPorNombre(
        @RequestParam("nombre") String cadena){
        return repoAreas.findByNombreComunContaining(cadena);
    }
    
    @PostMapping("/areasfloracion/agregar")
    public ResponseEntity<Object> agregarAreaFloracion(@RequestBody @Valid AreaFloracion area, Errors errores){
        try{
            if(errores.hasFieldErrors()){
                String mensaje = errores.getFieldErrors()
                        .stream()
                        .map(fe -> fe.getField() + " " + fe.getDefaultMessage())
                        .collect(Collectors.joining(","));
                return ResponseEntity
                        .badRequest()
                        .header("ERROR", mensaje)
                        .build();
            }
            repoAreas.save(area);
            
            URI urlNuevaArea = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .build(area.getIdAreasFloracion());
            return ResponseEntity
                    .created(urlNuevaArea)
                    .build();
        }
        catch(Exception ex){
            return ResponseEntity
                    .status(505)
                    .header("ERROR", ex.getMessage())
                    .build();
        }
    }
    
    @PutMapping("/areasfloracion/modificar/{id}")
    public ResponseEntity<Object> modificarAreaFloracion(
            @PathVariable("id") Integer id,
            @RequestBody AreaFloracion area){
         try{
            Date d = new Date();
            area.setActualizacion(d);
            area.setIdAreasFloracion(id);
            repoAreas.save(area);
            return ResponseEntity.
                    ok()
                    .build();
        } catch(Exception ex){
            return ResponseEntity
                    .status(505)
                    .header("ERROR",ex.getMessage())
                    .build();
        }
    }
    
    @DeleteMapping("/areasfloracion/eliminar/{id}")
    public ResponseEntity eliminarAreaFloracion(@PathVariable("id") Integer id){
        try{
            repoAreas.deleteById(id);
            return ResponseEntity
                    .ok()
                    .build();
        }
        catch(Exception ex){
            return ResponseEntity
                    .status(500)
                    .header("ERROR", ex.getMessage())
                    .build();
        }
    }
}
