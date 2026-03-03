package com.miapi.proyectoIntegrador.servicio;


import com.miapi.proyectoIntegrador.modelo.Planta;
import com.miapi.proyectoIntegrador.repositorio.RDePlantas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SDePlantas {
    @Autowired
    private RDePlantas repositorio;


    public Planta guardarPlanta(Planta planta) {
        return repositorio.save(planta);
    }
    public List<Planta> mostrarPlantas(){
        return repositorio.findAll();
    }
    public void eliminarPlanta(int id) {
        repositorio.deleteById(id);
    }
    public void actualizarPlanta(int id,Planta nuevainfo ) {
        Planta plantaExistente = repositorio.findById(id).orElseThrow(()->new RuntimeException("Planta no encontrada"));
        plantaExistente.setNombre(nuevainfo.getNombre());
        plantaExistente.setDescripcion(nuevainfo.getDescripcion());
        repositorio.save(plantaExistente);
    }

}
