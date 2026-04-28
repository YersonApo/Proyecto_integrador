package com.miapi.proyectoIntegrador.repositorio;

import com.miapi.proyectoIntegrador.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RDeUsuarios extends JpaRepository <Usuario, Integer> {

    public Usuario findByNombre(String nombre);

}
