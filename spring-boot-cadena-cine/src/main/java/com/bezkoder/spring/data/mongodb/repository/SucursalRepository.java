/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezkoder.spring.data.mongodb.repository;

import com.bezkoder.spring.data.mongodb.model.Sucursal;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Gregorio Noguera
 */
public interface SucursalRepository extends MongoRepository<Sucursal, String> {

    List<Sucursal> findByNombreContaining(String nombre);

}
