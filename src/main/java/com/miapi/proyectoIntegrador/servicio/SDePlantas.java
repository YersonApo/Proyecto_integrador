package com.miapi.proyectoIntegrador.servicio;


import com.miapi.proyectoIntegrador.modelo.Planta;
import com.miapi.proyectoIntegrador.modelo.Usuario;
import com.miapi.proyectoIntegrador.repositorio.RDePlantas;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SDePlantas {
    @Autowired
    private RDePlantas repositorio;


    public Planta guardarPlanta(Planta planta, Usuario usuario) {
        Usuario usuarioActual = usuario;
        planta.setUsuario(usuarioActual);
        return repositorio.save(planta);
    }
    public List<Planta> mostrarPlantas(Usuario usuario) {
        return repositorio.findByUsuario(usuario);
    }
    public void eliminarPlanta(int id,Usuario usuario) {
        Planta planta = repositorio.findById(id).orElseThrow(() -> new RuntimeException("Planta no encontrada"));
        if (planta.getUsuario().getId() != usuario.getId() ) {
            throw new RuntimeException("Uy esta planta no te pertenece");
        }
        repositorio.delete(planta);
    }
    public Planta actualizarPlanta(int id,Planta nuevainfo,Usuario usuario) {
        Planta plantaExistente = repositorio.findById(id).orElseThrow(()->new RuntimeException("Planta no encontrada"));
        if (plantaExistente.getUsuario().getId() != usuario.getId()) {
            throw new RuntimeException("Uy esta planta no te pertenece");
        }
        plantaExistente.setNombre(nuevainfo.getNombre());
        plantaExistente.setFamilia(nuevainfo.getFamilia());
        plantaExistente.setDescripcion(nuevainfo.getDescripcion());
        plantaExistente.setCuidados(nuevainfo.getCuidados());

        return repositorio.save(plantaExistente);
    }

}
