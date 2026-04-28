package com.miapi.proyectoIntegrador.servicio;

import com.miapi.proyectoIntegrador.modelo.Catalogo;
import com.miapi.proyectoIntegrador.repositorio.RDeCatalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SDeCatalogo {

    @Autowired
    private RDeCatalogo repositorio;

    public List<Catalogo> verCatalogo() {
        return repositorio.findAll();
    }

    public Catalogo VerPlantaId(int id) {
        return repositorio.findById(id).orElseThrow(() -> new RuntimeException("Planta no encontrada"));
    }

    public Catalogo VerPlantaNombre(String nombre){
        return repositorio.findByNombre(nombre);
    }

}
