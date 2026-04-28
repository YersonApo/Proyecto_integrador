package com.miapi.proyectoIntegrador.controlador;


import com.miapi.proyectoIntegrador.modelo.Usuario;
import com.miapi.proyectoIntegrador.servicio.SDeUsuarios;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class webControladorUsuario {

    @Autowired
    private SDeUsuarios sDeUsuarios;

    @GetMapping("/acceso")
    public String registro() {
        return "ingreso/ingreso";
    }

    @GetMapping("/nuevousuario")
    public String nuevousuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "ingreso/registroU";
    }

    @PostMapping("/registrar-nuevo")
    public String registrar(@ModelAttribute Usuario usuario, HttpSession session, Model model) {
        try {
            Usuario guardado = sDeUsuarios.registrarUsu(usuario);
            session.setAttribute("usuarioLogueado", guardado); // Guarda la sesión tras registrar
            return "redirect:/menu";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "ingreso/registroU";
        }
    }

    @PostMapping("/acceso")
    public String usuarioexistente(@RequestParam String nombre, @RequestParam String contra, HttpSession session, org.springframework.ui.Model model) {
        try{
            Usuario usuario = sDeUsuarios.ingresarUsu(nombre, contra);
            session.setAttribute("usuarioLogueado", usuario);
            return "redirect:/menu";
        }catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "/ingreso/ingreso";
        }
    }

    @GetMapping("/menu")
    public String menuPrincipal() {
        return "ingreso/menu";
    }

}
