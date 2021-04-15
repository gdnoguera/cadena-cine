/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezkoder.spring.data.mongodb.controller;

import com.bezkoder.spring.data.mongodb.model.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.data.mongodb.repository.SucursalRepository;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Gregorio Noguera
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SucursalController {

    @Autowired
    SucursalRepository sucursalRepository;

    @PostMapping("/sucursal")
    public ResponseEntity<Sucursal> createSucursal(@RequestBody Sucursal sucursal) {
        try {
            Sucursal _sucursal = sucursalRepository.save(new Sucursal(sucursal.getNombre(), sucursal.getDireccion(), sucursal.getAdministrador()));
            return new ResponseEntity<>(_sucursal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
