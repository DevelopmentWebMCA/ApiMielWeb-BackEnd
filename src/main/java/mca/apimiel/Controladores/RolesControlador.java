/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Controladores;

import java.util.Optional;
import mca.apimiel.Entidades.RolUsuario;
import mca.apimiel.Repositorios.RolesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/roles/{id}")
    public ResponseEntity<RolUsuario> getUsuarioPorId(@PathVariable("id") Integer id){
        Optional<RolUsuario> rol = repoRoles.findById(id);
        if (!rol.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rol.get());
    }
}
