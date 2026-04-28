package com.miapi.proyectoIntegrador.controlador;

import com.miapi.proyectoIntegrador.servicio.SDeCatalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class webControladorCatalogo {

    @Autowired
    private SDeCatalogo servicio;

    @GetMapping("/referencias")
    public String mostrarCatalogo(Model model) {
        model.addAttribute("plantas", servicio.verCatalogo());
        return "Catalogo/catalogo";
    }

    @GetMapping("/sugerencias")
    public String inicioSugerencias() {
        return "Catalogo/referencias";
    }
}