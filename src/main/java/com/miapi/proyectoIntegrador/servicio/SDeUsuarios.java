package com.miapi.proyectoIntegrador.servicio;

import com.miapi.proyectoIntegrador.modelo.Usuario;
import com.miapi.proyectoIntegrador.repositorio.RDeUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class SDeUsuarios {

    @Autowired
    private RDeUsuarios repositorio;
    @Autowired
    private PasswordEncoder codificadorContra;

    public Usuario registrarUsu(Usuario usuario) {
        Usuario usuario1 = repositorio.findByNombre(usuario.getNombre());
        if (usuario1 != null) {
         throw new RuntimeException("El nombre de usuario ya esta en uso");
        }
        if(usuario.getContra()==null || usuario.getContra().isEmpty()){
            throw new RuntimeException("La contraseña no puede estar vacia");
        }
        usuario.setContra(codificadorContra.encode(usuario.getContra()));

        return repositorio.save(usuario);
    }

    public Usuario ingresarUsu(String nombre, String contra) {
        Usuario usuario = repositorio.findByNombre(nombre);
        if (usuario == null) {
            throw new RuntimeException("El usuario no existe");
        }else if(!codificadorContra.matches(contra, usuario.getContra())){
            throw new RuntimeException("La contraseña no coincide");
        }
        return usuario;
    }
}
