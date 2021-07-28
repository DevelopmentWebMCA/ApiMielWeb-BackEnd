package mca.apimiel.Repositorios;

import mca.apimiel.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductosRepositorio extends JpaRepository<Producto, String> {

    @Query("SELECT pro FROM Producto pro WHERE pro.actualizacion>=?1")
    List<Producto> getProductosAfterFecha(Date fechaCorte);
    List <Producto> findByNombreProductoContaining(String nombre);
}

