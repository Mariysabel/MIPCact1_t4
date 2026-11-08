package com.act1.spring.app1.springboot_aplications.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoRestController {

    @GetMapping("/alumno")
    public Map<String, Object> alumno() {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("Nombre", "María Isabel Pérez Cruz");

        return respuesta;
    }

    @GetMapping("/tutor")
    public Object info_tutor() {

        return Map.of(
                "nombre", "Sonia Araceli Cruz Méndez",
                "contacto", "9512444635");

    }
}