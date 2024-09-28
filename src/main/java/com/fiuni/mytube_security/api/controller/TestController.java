package com.fiuni.mytube_security.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
@RequestMapping("/api/test") //por metodo
public class TestController {

    // Metodo GET que devuelve los detalles del usuario autenticado
    @GetMapping
    public Object getAuthenticatedUser() {
        // Obtener la autenticación actual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Si el usuario autenticado es de tipo UserDetails
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails; // Devolver los detalles del usuario autenticado
        }

        // Si no es de tipo UserDetails, devolver el nombre (puede ser un servicio OAuth o similar)
        return authentication.getPrincipal();
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
    @PreAuthorize("hasRole('Administrator')")
    @DeleteMapping
    public String deleteExample() {
        return "DELETE: Eliminando un recurso";
    }
}
