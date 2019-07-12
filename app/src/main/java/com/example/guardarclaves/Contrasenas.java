package com.example.guardarclaves;

public class Contrasenas {
    private String nombreCuenta, usuario, contrasena, url, descripcion;
    private int id;

    public Contrasenas(int id, String nombreCuenta, String usuario, String contrasena) {
        this.id = id;
        this.nombreCuenta = nombreCuenta;
        this.usuario = usuario;
        this.contrasena = contrasena;

    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
public String toString(){
        return nombreCuenta;
}
}
