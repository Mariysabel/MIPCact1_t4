package com.act1.spring.app1.springboot_aplications.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class MateriaRestController {

    @GetMapping("/materias")
    public Map<String, Object> materias() {

        Map<String, Object> respuesta = new HashMap<>();

        List<Map<String, Object>> listaMaterias = new ArrayList<>();

        Map<String, Object> materia1 = new HashMap<>();
        materia1.put("Nombre", "Desarrollo de Aplicaciones Web");
        materia1.put("Creditos", 5);
        materia1.put("Semestre", 7);

        Map<String, Object> materia2 = new HashMap<>();
        materia2.put("Nombre", "Administración de Bases de Datos");
        materia2.put("Creditos", 5);
        materia2.put("Semestre", 7);

        Map<String, Object> materia3 = new HashMap<>();
        materia3.put("Nombre", "Ingeniería de Software");
        materia3.put("Creditos", 4);
        materia3.put("Semestre", 7);

        listaMaterias.add(materia1);
        listaMaterias.add(materia2);
        listaMaterias.add(materia3);

        respuesta.put("Alumno", "María Isabel Pérez Cruz");
        respuesta.put("Materias", listaMaterias);

        return respuesta;
    }
}
