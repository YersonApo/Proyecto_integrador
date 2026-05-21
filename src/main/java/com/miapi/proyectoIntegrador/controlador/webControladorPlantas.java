package com.miapi.proyectoIntegrador.controlador;

import com.miapi.proyectoIntegrador.modelo.Planta;
import com.miapi.proyectoIntegrador.modelo.Usuario;
import com.miapi.proyectoIntegrador.servicio.SDePlantas;
import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/inventario")
    public String menuInventario() {
        return "inventario/menu2";
    }

    @GetMapping("/inventario/pc")
    public String verPlantas(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) {
           throw new RuntimeException("Usuario no autenticado");
        }
        model.addAttribute("plantas",servicio.mostrarPlantas(usuario));
        return "inventario/inventario";
    }

    @GetMapping("/inventario/nueva")
    public String formularioRegistro(Model model) {
        model.addAttribute("planta", new Planta());
        return "inventario/registro";
    }

    @GetMapping("/inventario/actualizar")
    public String gestionarInventario(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) {
            throw new RuntimeException("Usuario no autenticado");
        }
        model.addAttribute("plantas",servicio.mostrarPlantas(usuario));
        return "inventario/modificar";
    }

    @GetMapping("/inventario/editar")
    public String paginaEdicion() {
        return "inventario/edicion";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Planta planta, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if(usuario == null){
            throw new RuntimeException("Usuario no autenticado");
        }
        servicio.guardarPlanta(planta, usuario);
        return "redirect:/vista/inventario/pc";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if(usuario == null){
            throw new RuntimeException("Usuario no autenticado");
        }
        Planta planta = servicio.mostrarPlantas(usuario)
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Planta no encontrada"));
        model.addAttribute("planta", planta);
        return "inventario/edicion";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute Planta planta, HttpSession session) {
        planta.setId(id);
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if(usuario == null){
            throw new RuntimeException("Usuario no autenticado");
        }
        servicio.actualizarPlanta(id, planta, usuario);
        return "redirect:/vista/inventario/pc";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        servicio.eliminarPlanta(id, usuario);
        return "redirect:/vista/inventario/pc";
    }
}