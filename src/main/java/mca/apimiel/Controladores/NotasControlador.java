package mca.apimiel.Controladores;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import mca.apimiel.Entidades.Post;
import mca.apimiel.Repositorios.NotasRepositorio;

@RestController
@RequestMapping(path = "/apimiel/web")
public class NotasControlador {

	@Autowired
	NotasRepositorio notasRepositorio;
	
	@GetMapping("/notas")
	public List<Post> getNotas(){
		return notasRepositorio.findAll();
	}
	
	@GetMapping("/notas/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable("id") Integer id){
		Optional<Post> posts = notasRepositorio.findById(id);
		if(!posts.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(posts.get());
		
	}
	
	
	
	@PostMapping("/notas/agregar")
	public ResponseEntity<Object> agregarNotas(@RequestBody Post posts, Errors errores){
		
		try {
			if(errores.hasFieldErrors()) {
				String mensaje = errores.getFieldErrors()
						.stream()
						.map(fe -> fe.getField() + " " + fe.getDefaultMessage())
						.collect(Collectors.joining(","));
				return ResponseEntity
						.badRequest()
						.header("Error", mensaje)
						.build();
			}
			notasRepositorio.save(posts);
			
			URI urlNuevoPost = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.build(posts.getIdPost());
			return ResponseEntity
					.created(urlNuevoPost)
					.build();				
		}
		catch(Exception ex) {
			return ResponseEntity
					.status(500)
					.header("ERROR", ex.getMessage())
					.build();
			
		}
		
	}
	
	@PutMapping("/notas/modificar/{id}")
	public ResponseEntity modificarPost(@PathVariable("id") Integer id, @RequestBody Post posts) {
		try {
			posts.setIdPost(id);
			notasRepositorio.save(posts);
			return ResponseEntity
					.ok()
					.build();
					
		}
		catch(Exception ex) {
			return ResponseEntity
					.status(500)
					.header("ERROR", ex.getMessage())
					.build();
			
		}
	}
	
	@DeleteMapping("/notas/eliminar/{id}")
	public ResponseEntity eliminarPost(@PathVariable int id) {
		try {
			notasRepositorio.deleteById(id);
			return ResponseEntity
					.ok()
					.build();
		} catch (Exception ex) {
			return ResponseEntity
					.status(500)
					.header("ERROR", ex.getMessage())
					.build();
		}
	}
}
