package com.miapi.proyectoIntegrador.controlador;

import com.miapi.proyectoIntegrador.modelo.Catalogo;
import com.miapi.proyectoIntegrador.servicio.SDeSugerencias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class webControladorSugerencias {

    @Autowired
    private SDeSugerencias servicio;

    @GetMapping("/sugerencias")
    public String inicioSugerencias() {
        return "su/sugerencias";
    }

    @GetMapping("/sugerencia")
    public String mostrarFormulario() {
        return "su/formularioSu";
    }

    @PostMapping("/recomendar")
    public String recomendar(
            @RequestParam int luz,
            @RequestParam int riego,
            @RequestParam int temperatura,
            @RequestParam int ambiente,
            @RequestParam int cuidado,
            Model model) {

        Catalogo planta = servicio.Sugerir(luz, riego, temperatura, ambiente, cuidado);

        model.addAttribute("planta", planta);

        return "su/resultadoSu";
    }
}