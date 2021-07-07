package mca.apimiel.Repositorios;

import mca.apimiel.Entidades.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Andres Cuevas
 */
public interface RolesRepositorio extends JpaRepository<RolUsuario, Integer>{
    
}


