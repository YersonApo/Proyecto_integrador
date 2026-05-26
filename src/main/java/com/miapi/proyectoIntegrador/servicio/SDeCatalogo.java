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
}
