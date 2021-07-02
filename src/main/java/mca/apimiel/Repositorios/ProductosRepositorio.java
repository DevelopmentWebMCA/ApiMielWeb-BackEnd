package mca.apimiel.Repositorios;

import mca.apimiel.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepositorio extends JpaRepository<Producto, String> {

}

