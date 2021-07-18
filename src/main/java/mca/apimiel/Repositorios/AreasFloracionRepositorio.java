package mca.apimiel.Repositorios;

import java.util.Date;
import java.util.List;
import mca.apimiel.Entidades.AreaFloracion;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Andres Cuevas
 */
public interface AreasFloracionRepositorio extends JpaRepository<AreaFloracion, Integer>{
    List <AreaFloracion> findByRegionEstadoContaining(String value);
    List <AreaFloracion> findByFamiliaFloresContaining(String value);
    List <AreaFloracion> findByNombreComunContaining(String value);
    
    @Query("SELECT area FROM AreaFloracion area WHERE area.regionEstado LIKE :region")
    List <AreaFloracion> findAllByRegion(@Param("region")String region, Pageable page);

    @Query("SELECT area FROM AreaFloracion area WHERE area.actualizacion>=?1")
    List <AreaFloracion> getAreasFloracionAfterFecha(Date fechaCorte);
}
