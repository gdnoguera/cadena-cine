/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezkoder.spring.data.mongodb.controller;

import com.bezkoder.spring.data.mongodb.model.Sala;
import com.bezkoder.spring.data.mongodb.model.Sucursal;
import com.bezkoder.spring.data.mongodb.model.TipoSala;
import com.bezkoder.spring.data.mongodb.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.data.mongodb.repository.SucursalRepository;
import com.bezkoder.spring.data.mongodb.repository.TipoSalaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Gregorio Noguera
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SalaController {

    @Autowired
    SalaRepository salaRepository;

    @Autowired
    TipoSalaRepository tipoSalaRepository;

    @Autowired
    SucursalRepository sucursalRepository;

    @PostMapping("/sala")
    public @ResponseBody
    String createSala(@RequestBody Sala sala) {
        Optional<Sucursal> sucursalObtenida = sucursalRepository.findById(sala.getSucursal().getId());
        if (!sucursalObtenida.isPresent()) {
            return "La sucucursal no se encuentra registrada";
        }
        Optional<TipoSala> tipoSalaObtenida = tipoSalaRepository.findById(sala.getTipoSala().getId());
        if (!tipoSalaObtenida.isPresent()) {
            return "El tipo de sala no se encuentra registrada";
        }
        Sala _sala = salaRepository.save(new Sala(tipoSalaObtenida.get(), sala.getNumeroFila(),
                sala.getMaximoSilla(), sucursalObtenida.get()));
        if (_sala != null) {
            return "Sala creada exitosamente";
        }
        return null;

    }

    @PostMapping("/tipoSala")
    public ResponseEntity<TipoSala> createTipoSala(@RequestBody TipoSala tipoSala) {
        try {

            TipoSala _tipoSala = tipoSalaRepository.save(new TipoSala(tipoSala.getNombre().toUpperCase()));
            return new ResponseEntity<>(_tipoSala, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @GetMapping("/tipoSala/all")
    public ResponseEntity<List<TipoSala>> getAllTipoSala(@RequestParam(required = false) String nombre) {
        try {
            List<TipoSala> tipoSalas = new ArrayList<TipoSala>();
            if (nombre == null) {
                tipoSalaRepository.findAll().forEach(tipoSalas::add);
            } else {
                tipoSalaRepository.findByNombreContaining(nombre.toUpperCase()).forEach(tipoSalas::add);
            }
            if (tipoSalas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tipoSalas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
