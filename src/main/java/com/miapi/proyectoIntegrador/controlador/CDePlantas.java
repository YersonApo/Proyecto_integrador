package com.miapi.proyectoIntegrador.controlador;

import com.miapi.proyectoIntegrador.servicio.SDePlantas;
import com.miapi.proyectoIntegrador.modelo.Planta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantas")

public class CDePlantas {

    @Autowired
    private SDePlantas servicio;

    @PostMapping
    public Planta crearPlanta(@RequestBody Planta planta) {
        return servicio.guardarPlanta(planta);
    }

    @GetMapping
    public List<Planta> listarPlantas() {
        return servicio.mostrarPlantas();
    }

    @DeleteMapping("/{id}")
    public void eliminarPlanta(@PathVariable int id) {
        servicio.eliminarPlanta(id);
    }

    @PutMapping("/{id}")
    public Planta actualizarPlanta(@PathVariable int id, @RequestBody Planta nuevaInfo) {
        servicio.actualizarPlanta(id, nuevaInfo);
        return servicio.mostrarPlantas().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}


