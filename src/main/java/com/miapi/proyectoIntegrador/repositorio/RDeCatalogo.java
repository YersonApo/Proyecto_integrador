package com.miapi.proyectoIntegrador.repositorio;

import com.miapi.proyectoIntegrador.modelo.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RDeCatalogo extends JpaRepository<Catalogo, Integer> {
    public Catalogo findByNombre(String nombre);
}
