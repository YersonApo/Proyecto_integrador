package com.miapi.proyectoIntegrador.modelo;

import jakarta.persistence.*;

@Entity

public class Planta {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private String descripcion;
    private String cuidados;
    private String familia;

    public Planta() {

    }

    public Planta(int id, String nombre, String descripcion, String cuidados, String familia) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cuidados = cuidados;
        this.familia = familia;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCuidados() {
        return cuidados;
    }

    public void setCuidados(String cuidados) {
        this.cuidados = cuidados;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }
}
