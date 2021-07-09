/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import mca.apimiel.Entidades.Apicultor;

/**
 *
 * @author Jesus
 */
public interface ApicultoresRepositorio extends JpaRepository<Apicultor, String> {
    
}
