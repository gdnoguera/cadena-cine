package com.bezkoder.spring.data.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sucursal")
public class Sucursal {

    @Id
    private String id;

    private String nombre;
    private String direccion;
    private String administrador;

    public Sucursal() {

    }

    public Sucursal(String nombre, String direccion, String administrador) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.administrador = administrador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return "Sucursal [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", administrador=" + administrador + "]";
    }
}
