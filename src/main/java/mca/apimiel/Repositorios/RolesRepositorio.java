/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Repositorios;

import mca.apimiel.Entidades.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Andres Cuevas
 */
public interface RolesRepositorio extends JpaRepository<RolUsuario, Integer>{
    
}

//RolesRepositorio repoRoles;
//    @GetMapping(value = "/usuarios", params = {"idrol"})
//    public List<Usuario> buscarUsuariosPorRol(
//        @PathVariable("rol") int idrol){
//        Optional<RolUsuario>rol = repoRoles.findById(idrol);
//        return repoUsuarios.findByrolUsuarioLike(ResponseEntity.ok(rol.get()));    
//    }
