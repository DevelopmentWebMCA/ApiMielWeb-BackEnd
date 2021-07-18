/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Controladores;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import mca.apimiel.Entidades.Apicultor;
import mca.apimiel.Repositorios.ApicultoresRepositorio;

/**
 *
 * @author Jesus
 */

@RestController
@RequestMapping(path = "/apimiel/web")
public class ApicultoresControlador {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuariosControlador.class); 
	
	@Autowired
	ApicultoresRepositorio apicultorRepositorio;
	
	@GetMapping("/apicultores")
	public List<Apicultor> getApicultores(){
		return apicultorRepositorio.findAll();
	}
	
	@GetMapping("/apicultores/{id}")
	public ResponseEntity<Apicultor> getApicultorById(@PathVariable("id") String id){
		Optional<Apicultor> apicultor = apicultorRepositorio.findById(id);
		if(!apicultor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(apicultor.get());
		
	}
	
	
	
	@PostMapping("/apicultores/agregar")
	public ResponseEntity<Object> agregarApicultor(@RequestBody Apicultor apicultor, Errors errores){
		
		try {
			if(errores.hasFieldErrors()) {
				String mensaje = errores.getFieldErrors()
						.stream()
						.map(fe -> fe.getField() + " " + fe.getDefaultMessage())
						.collect(Collectors.joining(","));
				LOGGER.warn(mensaje);
				return ResponseEntity
						.badRequest()
						.header("Error", mensaje)
						.build();
			}
			apicultorRepositorio.save(apicultor);
			
			URI urlNuevoPost = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.build(apicultor.getIdApicultor());
			
			return ResponseEntity
					.created(urlNuevoPost)
					.build();				
		}
		catch(Exception ex) {
			LOGGER.warn("Error al crear apicultor", ex);
			return ResponseEntity
					.status(500)
					.header("ERROR", ex.getMessage())
					.build();
			
		}
		
	}
	
	@PutMapping("/apicultores/modificar/{id}")
	public ResponseEntity modificarApicultor(@PathVariable("id") String id, @RequestBody Apicultor apicultor) {
		try {
			apicultor.setIdApicultor(id);
			apicultorRepositorio.save(apicultor);
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
	
	@DeleteMapping("/apicultores/eliminar/{id}")
	public ResponseEntity eliminarApicultor(@PathVariable String id) {
		try {
			apicultorRepositorio.deleteById(id);
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
