package com.example.guardarclaves;

import java.io.Serializable;

public class Usuario implements Serializable {

   private String nombre, clave, claveSeguridad;

    public Usuario(String nombre, String clave, String claveSeguridad) {
        this.nombre = nombre;
        this.clave = clave;
        this.claveSeguridad = claveSeguridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClaveSeguridad() {
        return claveSeguridad;
    }

    public void setClaveSeguridad(String claveSeguridad) {
        this.claveSeguridad = claveSeguridad;
    }
}
