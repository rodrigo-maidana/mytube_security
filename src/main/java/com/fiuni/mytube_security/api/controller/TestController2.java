package com.fiuni.mytube_security.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test2") //por url
public class TestController2 {
    // Metodo GET
    @GetMapping
    public String getExample() {
        return "GET: Devolviendo un recurso";
    }

    // Metodo POST usuario regular
    @PostMapping
    public String postExample() {
        return "POST: Creando un nuevo recurso";
    }

    // Metodo PUT usuario regular
    @PutMapping
    public String putExample() {
        return "PUT: Actualizando un recurso existente";
    }

    // Metodo DELETE solo para admin
    @DeleteMapping
    public String deleteExample() {
        return "DELETE: Eliminando un recurso";
    }
}
