package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Laptop;
import com.example.obrestdatajpa.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {

    //Le indicamos a Spring que nos inyecte la clase LaptopRepository
    @Autowired
    private LaptopRepository laptopRepository;

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    //Creamos un registro en la base de datos
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){

        System.out.println(headers.get("User-Agent"));
        if (laptop.getId() != null){
            log.warn("Tratando de crear un registro con un id existente");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    //Buscamos todos los registros existentes
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){

        return laptopRepository.findAll();

    }

    //Buscamos un registro en concreto en la base de datos
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> fineOneById(@PathVariable long id){

        Laptop laptop = laptopRepository.findById(id).orElse(null);
        if(laptop != null) {
            return ResponseEntity.ok(laptop);
        }
        return ResponseEntity.notFound().build();
    }

    //Actualizamos un registro en concreto de la base de datos
    @PutMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> updateLaptop(@PathVariable(value = "id") Long laptopId, @RequestBody Laptop laptop){

        if (!laptopRepository.existsById(laptopId)){
            log.warn("Tratando de actualizar un registro no existente");
            return ResponseEntity.notFound().build();
        }
        laptop.setId(laptopId);
        laptopRepository.save(laptop);
        return ResponseEntity.ok(laptop);

    }

    //Borramos un elemento en la base de datos
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable(name = "id") Long id) {

        if (laptopRepository.findById(id).isPresent()) {

            Laptop delete = laptopRepository.findById(id).orElse(null);
            laptopRepository.deleteById(id);
            return ResponseEntity.ok(delete);
        }

        return ResponseEntity.notFound().build();
    }

    //Borramos todos elemento en la base de datos si hay
    @DeleteMapping("/api/laptops")
    public void deleteAll() {
        if (laptopRepository.count() > 0) {
            log.warn("Eliminando todos los datos");
            laptopRepository.deleteAll();
        }
        log.warn("No hay elementos para eliminar");
    }
}
