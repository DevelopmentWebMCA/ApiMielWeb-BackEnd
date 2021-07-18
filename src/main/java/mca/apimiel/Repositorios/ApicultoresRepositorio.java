/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import mca.apimiel.Entidades.Apicultor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Jesus
 */
public interface ApicultoresRepositorio extends JpaRepository<Apicultor, String> {

    @Query("SELECT api FROM Apicultor api WHERE api.actualizacion>=?1")
    List<Apicultor> getApicultoresAfterFecha(Date fecha);
}
