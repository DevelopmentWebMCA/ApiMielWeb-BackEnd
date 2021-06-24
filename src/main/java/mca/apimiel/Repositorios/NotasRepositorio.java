package mca.apimiel.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import mca.apimiel.Entidades.Post;

public interface NotasRepositorio extends JpaRepository<Post, Integer> {

}
