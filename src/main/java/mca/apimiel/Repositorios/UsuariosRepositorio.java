/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Repositorios;

import java.util.List;
import mca.apimiel.Entidades.RolUsuario;
import mca.apimiel.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Andres Cuevas
 */
public interface UsuariosRepositorio extends JpaRepository<Usuario, Integer>{
    List <Usuario> findByNombreUsuarioContaining(String value);
    List <Usuario> findByrolUsuarioLike(RolUsuario idRol);
}
