package com.miapi.proyectoIntegrador.controlador;

import com.miapi.proyectoIntegrador.modelo.Usuario;
import com.miapi.proyectoIntegrador.servicio.SDePlantas;
import com.miapi.proyectoIntegrador.modelo.Planta;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantas")

public class CDePlantas {

    @Autowired
    private SDePlantas servicio;

    @PostMapping
    public Planta crearPlanta(@RequestBody Planta planta, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if(usuario == null){
            throw new RuntimeException("Usuario no autenticado");
        }
        return servicio.guardarPlanta(planta,usuario);
    }

    @GetMapping
    public List<Planta> listarPlantas(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if(usuario == null){
            throw new RuntimeException("Usuario no autenticado");
        }
        return servicio.mostrarPlantas(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarPlanta(@PathVariable int id,HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if(usuario == null){
            throw new RuntimeException("Usuario no autenticado");
        }
        servicio.eliminarPlanta(id, usuario);
    }

    @PutMapping("/{id}")
    public Planta actualizarPlanta(@PathVariable int id, @RequestBody Planta nuevaInfo,HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) {
            throw new RuntimeException("Usuario no autenticado");
        }
        return servicio.actualizarPlanta(id, nuevaInfo, usuario);
    }
}


