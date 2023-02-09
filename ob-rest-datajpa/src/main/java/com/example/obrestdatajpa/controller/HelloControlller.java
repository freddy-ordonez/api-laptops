package com.example.obrestdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControlller {

    @GetMapping("/api/hola")
    public String hola(){
        return "Hola Mundo";
    }
}
