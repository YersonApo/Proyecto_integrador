package com.miapi.proyectoIntegrador.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank (message = "el usuario no puede estar vacio")
    @Column(unique = true, nullable = false)
    private String nombre;

    @NotBlank(message = "la contraseña no puede estar vacia")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
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
