package com.miapi.proyectoIntegrador.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private int luz;
    private int riego;
    private int temperatura;
    private int ambiente;
    private int cuidado;

    public Catalogo() {}

    public Catalogo(String nombre, String descripcion, String imagen, int luz, int riego, int temperatura, int ambiente, int cuidado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.luz = luz;
        this.riego = riego;
        this.temperatura = temperatura;
        this.ambiente = ambiente;
        this.cuidado = cuidado;
    }
}
