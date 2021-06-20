package mca.apimiel.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mca.apimiel.Entidades.Posts;
import mca.apimiel.Repositorios.NotasRepositorio;

@RestController
@RequestMapping(path = "/apimiel/notas")
public class NotasControlador {

	@Autowired
	NotasRepositorio notasRepositorio;
	
	@GetMapping("/notas")
	public List<Posts> getNotas(){
		return notasRepositorio.findAll();
	}
}
