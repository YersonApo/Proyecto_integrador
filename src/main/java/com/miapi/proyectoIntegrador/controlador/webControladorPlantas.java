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

    @GetMapping("/registro")
    public String registro() {
        return "ingreso/ingreso";
    }

    @GetMapping("/menu")
    public String menuPrincipal() {
        return "ingreso/menu";
    }

    @GetMapping("/inventario")
    public String menuInventario() {
        return "inventario/menu2";
    }

    @GetMapping("/inventario/pc")
    public String verPlantas(Model model) {
        model.addAttribute("plantas",servicio.mostrarPlantas());
        return "inventario/inventario";
    }

    @GetMapping("/inventario/nueva")
    public String formularioRegistro(Model model) {
        model.addAttribute("planta", new Planta());
        return "inventario/registro";
    }

    @GetMapping("/inventario/actualizar")
    public String gestionarInventario(Model model) {
        model.addAttribute("plantas",servicio.mostrarPlantas());
        return "inventario/modificar";
    }

    @GetMapping("/inventario/editar")
    public String paginaEdicion() {
        return "inventario/edicion";
    }

    @GetMapping("/sugerencias")
    public String inicioSugerencias() {
        return "su/sugerencias";
    }

    @GetMapping("/referencias")
    public String inicioReferencias() {
        return "re/referencias";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Planta planta) {
        servicio.guardarPlanta(planta);
        return "redirect:/vista/inventario/pc";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Planta planta = servicio.mostrarPlantas()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Planta no encontrada"));
        model.addAttribute("planta", planta);
        return "inventario/edicion";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute Planta planta) {
        planta.setId(id);
        servicio.actualizarPlanta(id, planta);
        return "redirect:/vista/inventario/pc";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        servicio.eliminarPlanta(id);
        return "redirect:/vista/inventario/pc";
    }
}