package com.miapi.proyectoIntegrador.repositorio;

import com.miapi.proyectoIntegrador.modelo.Planta;
import com.miapi.proyectoIntegrador.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RDePlantas extends JpaRepository<Planta, Integer> {

    List<Planta> findByUsuario(Usuario usuario);

}
