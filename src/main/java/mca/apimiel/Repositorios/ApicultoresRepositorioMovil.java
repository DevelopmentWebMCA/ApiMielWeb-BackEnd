package mca.apimiel.Repositorios;


import mca.apimiel.Entidades.ApicultorMovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ApicultoresRepositorioMovil extends JpaRepository<ApicultorMovil, String> {

    @Query("SELECT api FROM ApicultorMovil api WHERE api.actualizacion>=?1")
    List<ApicultorMovil> getApicultoresAfterFecha(Date fecha);

}
