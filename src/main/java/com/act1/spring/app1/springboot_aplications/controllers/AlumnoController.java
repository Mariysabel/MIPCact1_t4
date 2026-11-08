package com.act1.spring.app1.springboot_aplications.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
public class AlumnoController {

    @GetMapping("/detalles_alumno")
    

    public String info(Model model){
        model.addAttribute("titulo", "Servidor en linea");
        model.addAttribute("prueba", "Servidor en linea");

        return "detalles_alumno";
    }
}
