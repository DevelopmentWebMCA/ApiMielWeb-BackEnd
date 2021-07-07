package mca.apimiel.Controladores;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mca.apimiel.Entidades.Usuario;
import mca.apimiel.Repositorios.UsuariosRepositorio;
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
public class UsuariosControlador {
    
    @Autowired
    UsuariosRepositorio repoUsuarios;
    
    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return repoUsuarios.findAll();
    }
    
    @GetMapping("/usuarios/page/{idrol}/{page}")
    public List<Usuario> getUsuariosPage(@PathVariable("idrol") Integer idrol,@PathVariable("page") Integer page) {
        return repoUsuarios.findAllByRolUsuario(idrol, PageRequest.of(page, 2));
    }
   
    
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuarioPorId(@PathVariable("id") Integer id){
        Optional<Usuario> usuarioId = repoUsuarios.findById(id);
        if (!usuarioId.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioId.get());
    }
    
    @GetMapping(value = "/usuarios", params = {"nombre"})
    public List<Usuario> buscarUsuarioPorNombre(
        @RequestParam("nombre") String cadena){
        return repoUsuarios.findByNombreUsuarioContaining(cadena);
    }
    
    @GetMapping(value = "/usuarios/rol/{id}")
    public List<Usuario> buscarUsuariosPorRol(
        @PathVariable("id") Integer idRol){
        return repoUsuarios.buscarUsuariosPorIdRol(idRol);  
    }
    
    @PostMapping("/usuarios/agregar")
    public ResponseEntity<Object> agregarUsuario(@RequestBody @Valid Usuario usuario, Errors errores){
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
            repoUsuarios.save(usuario);
            
            URI urlNuevoUsuario = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .build(usuario.getIdUsuario());
            return ResponseEntity
                    .created(urlNuevoUsuario)
                    .build();
        }
        catch(Exception ex){
            return ResponseEntity
                    .status(505)
                    .header("ERROR", ex.getMessage())
                    .build();
        }
    }
    
    @PutMapping("/usuarios/modificar/{id}")
    public ResponseEntity<Object> modificarUsuario(
            @PathVariable("id") Integer id,
            @RequestBody Usuario usuario){
         try{
            usuario.setIdUsuario(id);
            repoUsuarios.save(usuario);
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
    
    @DeleteMapping("/usuarios/eliminar/{id}")
    public ResponseEntity eliminarUsuario(@PathVariable("id") Integer id){
        try{
            repoUsuarios.deleteById(id);
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
