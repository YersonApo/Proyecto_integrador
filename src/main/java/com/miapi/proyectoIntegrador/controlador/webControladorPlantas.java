package com.miapi.proyectoIntegrador.controlador;

import com.miapi.proyectoIntegrador.modelo.Planta;
import com.miapi.proyectoIntegrador.servicio.SDePlantas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vista")
public class webControladorPlantas {

    @Autowired
    private SDePlantas servicio;

    @GetMapping("/")
    public String inicio() {
        return "inicio";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/plantas")
    public String listar(Model model) {
        model.addAttribute("plantas", servicio.mostrarPlantas());
        return "listarPlantas";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("planta", new Planta());
        return "formularioPlanta";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Planta planta) {
        servicio.guardarPlanta(planta);
        return "redirect:/vista/plantas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Planta planta = servicio.mostrarPlantas()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Planta no encontrada"));
        model.addAttribute("planta", planta);
        return "formularioPlanta";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute Planta planta) {
        servicio.actualizarPlanta(id, planta);
        return "redirect:/vista/plantas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        servicio.eliminarPlanta(id);
        return "redirect:/vista/plantas";
    }
}