package com.miapi.proyectoIntegrador.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Planta {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private String descripcion;
    private String cuidados;
    private String familia;

    @ManyToOne
    @JoinColumn (name="usuario_id")
    private Usuario usuario;

    public Planta() {

    }

    public Planta(int id, String nombre, String descripcion, String cuidados, String familia) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cuidados = cuidados;
        this.familia = familia;
    }

}
