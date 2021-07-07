package mca.apimiel.Controladores;

import java.util.List;
import mca.apimiel.Entidades.RolUsuario;
import mca.apimiel.Repositorios.RolesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres Cuevas
 */

@RestController
@RequestMapping(path = "/apimiel/web")
public class RolesControlador {
    
    @Autowired
    RolesRepositorio repoRoles;
    
    @GetMapping("/roles")
    public List<RolUsuario> getRoles() {
        return repoRoles.findAll();
    }
}
