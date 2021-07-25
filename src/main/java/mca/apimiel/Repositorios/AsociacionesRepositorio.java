package mca.apimiel.Repositorios;

import mca.apimiel.Entidades.Asociacion;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AsociacionesRepositorio extends JpaRepository<Asociacion, String> {

    @Query("SELECT aso FROM Asociacion aso WHERE aso.actualizacion>=?1")
    List<Asociacion> getAsociacionesAfterFecha(Date fechaCorte);

    List <Asociacion> findByNombreAsociacionContaining(String nombre);
}
