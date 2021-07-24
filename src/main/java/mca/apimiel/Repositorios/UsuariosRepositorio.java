/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Repositorios;

import java.util.List;
import mca.apimiel.Entidades.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Andres Cuevas
 */
public interface UsuariosRepositorio extends JpaRepository<Usuario, Integer>, PagingAndSortingRepository <Usuario, Integer>{//
    List <Usuario> findByNombreUsuarioContaining(String value);
    
    @Query("SELECT usuarios FROM Usuario usuarios WHERE usuarios.rolUsuario.idRol = :idRol")
    List <Usuario> buscarUsuariosPorIdRol(@Param("idRol")Integer idRol);
    
    @Query("SELECT usuarios FROM Usuario usuarios WHERE usuarios.rolUsuario.idRol = :idRol")
    List <Usuario> findAllByRolUsuario(@Param("idRol")Integer idRol, Pageable page);

    Usuario findByNombreUsuarioAndContrasenia(String nombreUsuario, String contrasenia);

    Usuario findByNombreUsuario(String nombreUsuario);

}
