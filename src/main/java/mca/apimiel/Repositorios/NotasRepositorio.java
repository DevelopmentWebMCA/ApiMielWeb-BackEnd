package mca.apimiel.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import mca.apimiel.Entidades.Posts;

public interface NotasRepositorio extends JpaRepository<Posts, Integer> {

}
