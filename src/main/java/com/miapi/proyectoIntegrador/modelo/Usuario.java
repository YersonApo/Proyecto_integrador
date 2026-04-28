package com.miapi.proyectoIntegrador.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue

    private int id;

    @Column(unique = true, nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String contra;

    @OneToMany(mappedBy = "usuario" , cascade = CascadeType.ALL, orphanRemoval = true )
    List<Planta> listaDePlantas = new ArrayList<>();

    public Usuario(){

    }

    public Usuario(String nombre,String contra){

        this.nombre=nombre;
        this.contra =contra;

    }
}
