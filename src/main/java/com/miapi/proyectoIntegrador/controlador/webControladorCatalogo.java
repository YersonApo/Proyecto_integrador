package com.miapi.proyectoIntegrador.controlador;

import com.miapi.proyectoIntegrador.servicio.SDeCatalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class webControladorCatalogo {

    @Autowired
    private SDeCatalogo servicio;

    @GetMapping("/catalogo")
    public String mostrarCatalogo(Model model) {
        model.addAttribute("plantas", servicio.verCatalogo());
        return "Catalogo/catalogo";
    }

    @GetMapping("/inicioc")
    public String inicioCatalogo() {
        return "Catalogo/inicioc";
    }
}